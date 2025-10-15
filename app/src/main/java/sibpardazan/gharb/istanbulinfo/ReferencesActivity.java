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
            "https://www.lonelyplanet.com/news/hagia-sophia-istanbul-mosque",
            "https://www.bluemosquetickets.com/about-blue-mosque/",
            "https://www.topkapipalace-tickets.com/topkapi-palace-entrance/",
            "https://en.wikipedia.org/wiki/S%C3%BCleymaniye_Mosque",
            "https://www.througheternity.com/en/blog/things-to-do/The-Grand-Bazaar-in-Istanbul-A-Shoppers-Paradise.html",
            "https://istanbul-tourist-information.com/dolmabahce-palace-visitor-uptade/",
            "https://www.galata-tower.com/de",
            "https://www.barcelo.com/guia-turismo/en/turkey/istanbul/things-to-do/galata-bridge/",
            "https://www.lonelyplanet.com/turkey/istanbul/sultanahmet/attractions/basilica-cistern/a/poi-sig/402088/1324696",
            "https://www.viator.com/de-AT/tours/Istanbul/Small-Group-Istanbul-Walking-Tour-Hagia-Sophia-Museum-and-the-Blue-Mosque/d585-5744ISTWALKING",
            "https://www.gothrace.com/site/news/maidens-tower---istanbul/169",
            "https://www.guidedistanbultours.com/en/blog/beylerbeyi-palace",
            "https://www.gettyimages.de/fotos/istiklal-avenue",
            "https://www.tripadvisor.de/Attraction_Review-g293974-d6223392-Reviews-Ahrida_Synagogue-Istanbul.html",
            "https://visitbursa.org/mekanlar/iznik-nilufer-hatun-imareti-turk-islam-eserleri-muzesi-252",
            "https://en.wikipedia.org/wiki/Atat%C3%BCrk_Airport",
            "https://theistanbulinsider.com/the-egyptian-or-spice-bazaar-the-hottest-spot-in-town/",
            "https://www.tripadvisor.com/Attraction_Review-g293974-d295153-Reviews-Rumeli_Fortress-Istanbul.html",
            "https://en.wikipedia.org/wiki/G%C3%BClhane_Park",
            "https://www.thecollector.com/what-are-the-theodosian-walls-of-constantinople/"
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