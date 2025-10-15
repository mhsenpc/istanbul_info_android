package sibpardazan.gharb.istanbulinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReferencesActivity extends AppCompatActivity {

    private ListView referencesListView;
    private ArrayAdapter<String> referencesAdapter;
    private List<String> referencesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.references_title);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        referencesListView = findViewById(R.id.references_list_view);

        setupReferencesList();
        setupReferencesAdapter();
        setupItemClickListener();
    }

    private void setupReferencesList() {
        // Define the reference URLs
        String[] referencesArray = {
            "https:/test.com"
        };

        referencesList = new ArrayList<>(Arrays.asList(referencesArray));
    }

    private void setupReferencesAdapter() {
        referencesAdapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            referencesList
        );
        referencesListView.setAdapter(referencesAdapter);
    }

    private void setupItemClickListener() {
        referencesListView.setOnItemClickListener((parent, view, position, id) -> {
            String url = referencesList.get(position);
            openWebPage(url);
        });
    }

    private void openWebPage(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            // Handle case where no browser app is available
            android.widget.Toast.makeText(this, R.string.error_no_browser, android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}