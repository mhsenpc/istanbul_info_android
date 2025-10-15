package sibpardazan.gharb.istanbulinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private MaterialButton btnPrevious, btnNext;
    private PlacePagerAdapter adapter;
    private BookmarkManager bookmarkManager;
    private MenuItem bookmarkToggleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.main_title);
        setSupportActionBar(toolbar);

        bookmarkManager = BookmarkManager.getInstance(this);

        viewPager = findViewById(R.id.viewpager);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);

        setupViewPager();
        setupNavigationButtons();

        // Handle deep link to specific place
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent != null && intent.hasExtra("place_index")) {
            int placeIndex = intent.getIntExtra("place_index", 0);
            if (placeIndex >= 0 && placeIndex < adapter.getItemCount()) {
                viewPager.setCurrentItem(placeIndex, true);
            }
        }
    }

    private void setupViewPager() {
        adapter = new PlacePagerAdapter(this);
        viewPager.setAdapter(adapter);

        android.util.Log.d("MainActivity", "ViewPager setup complete. Total places: " + adapter.getItemCount());

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                android.util.Log.d("MainActivity", "Page selected: " + position);
                updateNavigationButtons(position);
                updateBookmarkIcon(position);
            }
        });
    }

    private void setupNavigationButtons() {
        btnPrevious.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem > 0) {
                viewPager.setCurrentItem(currentItem - 1);
            }
        });

        btnNext.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem < adapter.getItemCount() - 1) {
                viewPager.setCurrentItem(currentItem + 1);
            }
        });
    }

    private void updateNavigationButtons(int position) {
        btnPrevious.setEnabled(position > 0);
        btnNext.setEnabled(position < adapter.getItemCount() - 1);
    }

    private void updateBookmarkIcon(int position) {
        if (bookmarkToggleItem != null) {
            boolean isBookmarked = bookmarkManager.isBookmarked(position);
            if (isBookmarked) {
                bookmarkToggleItem.setIcon(R.drawable.star_filled);
                bookmarkToggleItem.setTitle(R.string.remove_bookmark);
            } else {
                bookmarkToggleItem.setIcon(R.drawable.star_empty);
                bookmarkToggleItem.setTitle(R.string.bookmark_place);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        bookmarkToggleItem = menu.findItem(R.id.action_bookmark_toggle);
        // Update initial bookmark icon
        updateBookmarkIcon(viewPager.getCurrentItem());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
            return true;
        } else if (item.getItemId() == R.id.action_bookmark_toggle) {
            // Toggle bookmark for current place
            int currentPosition = viewPager.getCurrentItem();
            bookmarkManager.toggleBookmark(currentPosition);
            updateBookmarkIcon(currentPosition);

            // Show feedback
            PlaceData.PlaceContent currentPlace = PlaceData.getPlace(currentPosition, this);
            if (currentPlace != null) {
                boolean isBookmarked = bookmarkManager.isBookmarked(currentPosition);
                String message = isBookmarked ?
                    currentPlace.title + " نشانکذاری شد" :
                    currentPlace.title + " از نشانکذاری‌ها حذف شد";
                android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show();
            }
            return true;
        } else if (item.getItemId() == R.id.action_bookmarks) {
            startActivity(new Intent(MainActivity.this, BookmarksActivity.class));
            return true;
        } else if (item.getItemId() == R.id.action_references) {
            startActivity(new Intent(MainActivity.this, ReferencesActivity.class));
            return true;
        } else if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}