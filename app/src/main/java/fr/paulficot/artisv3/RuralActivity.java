package fr.paulficot.artisv3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class RuralActivity extends AppCompatActivity {

    GridLayout gridRural;
    Toolbar toolbarRural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rural);
        toolbarRural = findViewById(R.id.toolbar_rural);
    setSupportActionBar(toolbarRural);

        gridRural = findViewById(R.id.grid_rural);
    setSingleEvent(gridRural);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pdf_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_website:
                String url_website = Config.url_artis_website;
                Intent intentWeb = new Intent();
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.addCategory(Intent.CATEGORY_BROWSABLE);

                intentWeb.setData(Uri.parse(url_website));
                startActivity(intentWeb);
                return true;

            case R.id.menu_rss:
                Intent intentRss = new Intent(RuralActivity.this, RSSActivity.class);
                startActivity(intentRss);
                return true;

            case R.id.menu_reguliere:
                Intent intentRegulieres = new Intent(RuralActivity.this, MainActivity.class);
                startActivity(intentRegulieres);
                return true;

            case R.id.menu_rural:
                Toast.makeText(this, "Rural", Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.menu_citadine:
                Config.url_temp = Config.Citadine;
                Intent intentCitadine = new Intent(RuralActivity.this, PDFActivity.class);
                startActivity(intentCitadine);
                return true;

            case R.id.menu_tad:
                Intent intentTAD = new Intent(RuralActivity.this, TADActivity.class);
                startActivity(intentTAD);
                return true;

            case R.id.menu_velectric:
                String url_Velectric = Config.VElectric;
                Intent intentVelectric = new Intent();
                intentVelectric.setAction(Intent.ACTION_VIEW);
                intentVelectric.addCategory(Intent.CATEGORY_BROWSABLE);

                intentVelectric.setData(Uri.parse(url_Velectric));
                startActivity(intentVelectric);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView mainCardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            mainCardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(finalI == 0) {
                        Config.url_temp = Config.LR11;
                        Intent intentL1 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL1);

                    } else if (finalI == 1) {
                        Config.url_temp = Config.LR12;
                        Intent intentL2 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL2);

                    } else if (finalI == 2) {
                        Config.url_temp = Config.LR13;
                        Intent intentL3 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL3);

                    } else if (finalI == 3) {
                        Config.url_temp = Config.LR14;
                        Intent intentL4 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL4);

                    } else if (finalI == 4) {
                        Config.url_temp = Config.LR15;
                        Intent intentL5 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL5);

                    } else if (finalI == 5) {
                        Config.url_temp = Config.LR16;
                        Intent intentL6 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL6);

                    } else if (finalI == 6) {
                        Config.url_temp = Config.LR17;
                        Intent intentL7 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL7);

                    } else if (finalI == 7) {
                    } else if (finalI == 8) {
                        Config.url_temp = Config.LR18;
                        Intent intentL8 = new Intent(RuralActivity.this, PDFActivity.class);
                        startActivity(intentL8);
                    } else {
                        Toast.makeText(RuralActivity.this, "Erreur activité invalide. Contacter l'administrateur", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            });
        }
    }
}