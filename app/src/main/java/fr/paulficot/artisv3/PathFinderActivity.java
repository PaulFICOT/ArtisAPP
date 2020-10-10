package fr.paulficot.artisv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import fr.paulficot.artisv3.Model.RSSObject;

public class PathFinderActivity extends AppCompatActivity {

    Toolbar toolbarPathFinder;
    WebView webPathFinder;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_finder);

        toolbarPathFinder = findViewById(R.id.toolbar_path_finder);
        setSupportActionBar(toolbarPathFinder);

        webPathFinder = findViewById(R.id.webview_path_finder);

        WebSettings webSettingsPathFinder = webPathFinder.getSettings();
        webSettingsPathFinder.setJavaScriptEnabled(true);

        webPathFinder.loadUrl(Config.URL_path_finder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.path_finder_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intentHome = new Intent(PathFinderActivity.this, MainActivity.class);
                PathFinderActivity.this.startActivity(intentHome);
                return true;

            case R.id.menu_rss:
                Intent intentRss = new Intent(PathFinderActivity.this, RSSObject.class);
                PathFinderActivity.this.startActivity(intentRss);
                return true;

            case R.id.menu_refresh:
                webPathFinder.loadUrl(Config.URL_path_finder);
        }
        return super.onOptionsItemSelected(item);
    }
}