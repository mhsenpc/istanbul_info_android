package sibpardazan.gharb.istanbulinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookmarksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView emptyText;
    private BookmarkAdapter adapter;
    private FloatingActionButton fabAddBookmark;
    private BookmarkManager bookmarkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        bookmarkManager = BookmarkManager.getInstance(this);

        setupToolbar();
        setupViews();
        setupFabButton();
        loadBookmarks();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.bookmarks);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.recycler_view_bookmarks);
        emptyText = findViewById(R.id.tv_empty_bookmarks);
        fabAddBookmark = findViewById(R.id.fab_add_bookmark);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupFabButton() {
        fabAddBookmark.setOnClickListener(v -> showAddBookmarkDialog());
    }

    private void showAddBookmarkDialog() {
        String[] placeNames = PlaceData.getAllPlaceNames(this);
        int[] bookmarkedPlaces = bookmarkManager.getBookmarkedPlaces();

        List<String> availablePlaces = new ArrayList<>();
        List<Integer> availableIndices = new ArrayList<>();

        for (int i = 0; i < placeNames.length; i++) {
            boolean isBookmarked = false;
            for (int bookmarked : bookmarkedPlaces) {
                if (bookmarked == i) {
                    isBookmarked = true;
                    break;
                }
            }
            if (!isBookmarked) {
                availablePlaces.add(placeNames[i]);
                availableIndices.add(i);
            }
        }

        if (availablePlaces.isEmpty()) {
            new AlertDialog.Builder(this)
                .setTitle(R.string.bookmarks)
                .setMessage("تمام مکان‌ها قبلاً نشانکذاری شده‌اند.")
                .setPositiveButton("باشه", null)
                .show();
            return;
        }

        String[] placesArray = availablePlaces.toArray(new String[0]);
        new AlertDialog.Builder(this)
            .setTitle("مکان را برای نشانکذاری انتخاب کنید")
            .setItems(placesArray, (dialog, which) -> {
                int placeIndex = availableIndices.get(which);
                bookmarkManager.addBookmark(placeIndex);
                loadBookmarks();
            })
            .setNegativeButton("لغو", null)
            .show();
    }

    private void loadBookmarks() {
        int[] bookmarkedIndices = bookmarkManager.getBookmarkedPlaces();

        if (bookmarkedIndices.length == 0) {
            recyclerView.setVisibility(View.GONE);
            emptyText.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);

            List<Integer> bookmarkedPlaces = new ArrayList<>();
            for (int index : bookmarkedIndices) {
                bookmarkedPlaces.add(index);
            }

            // Sort by bookmarked index
            Collections.sort(bookmarkedPlaces);

            adapter = new BookmarkAdapter(bookmarkedPlaces, this::onPlaceClick);
            recyclerView.setAdapter(adapter);
        }
    }

    private void onPlaceClick(int placeIndex) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("place_index", placeIndex);
        intent.putExtra("open_place", true);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBookmarks(); // Refresh bookmarks when activity resumes
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}