package fr.paulficot.artisbus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;


public class MapActivity extends AppCompatActivity {

    private MapView mapViewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(   getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences( getApplicationContext()) );

        setContentView(R.layout.activity_map);

        Toolbar toolbarMap = findViewById(R.id.toolbar_map);
        setSupportActionBar(toolbarMap);

        mapViewMap = findViewById(R.id.mapview_map);
        mapViewMap.setTileSource(TileSourceFactory.MAPNIK); //Render
        mapViewMap.setBuiltInZoomControls(true); //Zoomable
        GeoPoint startPoint = new GeoPoint(43.65020, 7.00517);
        IMapController mapControllerMap = mapViewMap.getController();
        mapControllerMap.setZoom(18.0);
        mapControllerMap.setCenter(startPoint);

        ArrayList<OverlayItem> overlayItemsMap = new ArrayList<>();
        OverlayItem gare = new OverlayItem("Gare des bus", "", new GeoPoint(43.65020, 7.00517));
        Drawable myMarker = gare.getMarker(0);
        overlayItemsMap.add(gare);
        //overlayItemsMap.add(new OverlayItem("Test", "test", new GeoPoint(43, 7)));

        ItemizedOverlayWithFocus<OverlayItem> myOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(), overlayItemsMap, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });

        myOverlay.setFocusItemsOnTap(true);
        mapViewMap.getOverlays().add(myOverlay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewMap.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewMap.onResume();
    }

    @Override
    public void onBackPressed() {
        Intent intentRss = new Intent(MapActivity.this, MainActivity.class);
        MapActivity.this.startActivity(intentRss);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intentHome = new Intent(MapActivity.this, MainActivity.class);
                MapActivity.this.startActivity(intentHome);
                return true;

            case R.id.menu_website:
                String url_website = Config.url_artis_website;

                Intent intentWeb = new Intent();
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.addCategory(Intent.CATEGORY_BROWSABLE);

                intentWeb.setData(Uri.parse(url_website));
                startActivity(intentWeb);
                return true;

            case R.id.menu_rss:
                Intent intentRss = new Intent(MapActivity.this, RSSActivity.class);
                MapActivity.this.startActivity(intentRss);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}