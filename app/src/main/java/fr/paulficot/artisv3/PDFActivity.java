package fr.paulficot.artisv3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    PDFView pdfView;
    Toolbar toolbarBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        toolbarBus = findViewById(R.id.toolbar_bus);
        setSupportActionBar(toolbarBus);

        setSingleEvent();
    }

    @Override
    public void onBackPressed() {
        Intent intentRss = new Intent(PDFActivity.this, MainActivity.class);
        PDFActivity.this.startActivity(intentRss);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pdf_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intentHome = new Intent(PDFActivity.this, MainActivity.class);
                PDFActivity.this.startActivity(intentHome);
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
                Intent intentRss = new Intent(PDFActivity.this, RSSActivity.class);
                PDFActivity.this.startActivity(intentRss);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSingleEvent() {
        pdfView = findViewById(R.id.pdfview_bus);
        pdfView.fromAsset(Config.url_temp).load();
    }
}