package sibpardazan.gharb.istanbulinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearch;
    private ImageView ivClearSearch;
    private RecyclerView rvSearchResults;
    private LinearLayout llEmptyState;
    private SearchAdapter searchAdapter;
    private List<SearchResult> searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setupToolbar();
        setupViews();
        setupSearchFunctionality();
    }

    private void setupToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.search_title);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setupViews() {
        etSearch = findViewById(R.id.et_search);
        ivClearSearch = findViewById(R.id.iv_clear_search);
        rvSearchResults = findViewById(R.id.rv_search_results);
        llEmptyState = findViewById(R.id.ll_empty_state);

        // Setup RecyclerView
        rvSearchResults.setLayoutManager(new LinearLayoutManager(this));
        searchResults = new ArrayList<>();
        searchAdapter = new SearchAdapter(searchResults, this::onPlaceClicked);
        rvSearchResults.setAdapter(searchAdapter);

        // Setup clear search button
        ivClearSearch.setOnClickListener(v -> {
            etSearch.setText("");
            etSearch.requestFocus();
        });
    }

    private void setupSearchFunctionality() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim();
                performSearch(query);

                // Show/hide clear button based on text
                ivClearSearch.setVisibility(query.isEmpty() ? View.GONE : View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });

        // Set focus to search field
        etSearch.requestFocus();
    }

    private void performSearch(String query) {
        searchResults.clear();

        if (query.isEmpty()) {
            showEmptyState();
            searchAdapter.notifyDataSetChanged();
            return;
        }

        // Search through all places
        for (int i = 0; i < PlaceData.getPlaceCount(); i++) {
            PlaceData.PlaceContent place = PlaceData.getPlace(i, this);
            if (place != null && placeMatchesQuery(place, query)) {
                searchResults.add(new SearchResult(i, place));
            }
        }

        if (searchResults.isEmpty()) {
            showNoResultsState();
        } else {
            showResults();
        }

        searchAdapter.notifyDataSetChanged();
    }

    private boolean placeMatchesQuery(PlaceData.PlaceContent place, String query) {
        String lowercaseQuery = query.toLowerCase();

        // Search in title
        if (place.title.toLowerCase().contains(lowercaseQuery)) {
            return true;
        }

        // Search in original name
        if (place.originalName.toLowerCase().contains(lowercaseQuery)) {
            return true;
        }

        // Search in history
        if (place.history.toLowerCase().contains(lowercaseQuery)) {
            return true;
        }

        // Search in info
        if (place.info.toLowerCase().contains(lowercaseQuery)) {
            return true;
        }

        // Search in tips
        if (place.tips.toLowerCase().contains(lowercaseQuery)) {
            return true;
        }

        return false;
    }

    private void showResults() {
        rvSearchResults.setVisibility(View.VISIBLE);
        llEmptyState.setVisibility(View.GONE);
    }

    private void showEmptyState() {
        rvSearchResults.setVisibility(View.GONE);
        llEmptyState.setVisibility(View.VISIBLE);

        // Update empty state text for no search query
        TextView emptyText = llEmptyState.findViewById(R.id.tv_empty_message);
        if (emptyText != null) {
            emptyText.setText(R.string.search_empty_state);
        }
    }

    private void showNoResultsState() {
        rvSearchResults.setVisibility(View.GONE);
        llEmptyState.setVisibility(View.VISIBLE);

        // Update empty state text for no results
        TextView emptyText = llEmptyState.findViewById(R.id.tv_empty_message);
        if (emptyText != null) {
            emptyText.setText(R.string.no_results_found);
        }
    }

    private void onPlaceClicked(SearchResult searchResult) {
        // Navigate to MainActivity with the specific place
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("place_index", searchResult.placeIndex);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Helper class to hold search results
    public static class SearchResult {
        public int placeIndex;
        public PlaceData.PlaceContent placeContent;
        public String description;

        public SearchResult(int placeIndex, PlaceData.PlaceContent placeContent) {
            this.placeIndex = placeIndex;
            this.placeContent = placeContent;
            // Create a short description from history or info
            this.description = createDescription(placeContent);
        }

        private String createDescription(PlaceData.PlaceContent place) {
            // Use first part of history as description, limit to reasonable length
            String history = place.history;
            if (history.length() > 100) {
                return history.substring(0, 97) + "...";
            }
            return history;
        }
    }
}