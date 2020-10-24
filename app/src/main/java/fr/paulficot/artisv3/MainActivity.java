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

public class MainActivity extends AppCompatActivity {

    GridLayout gridMain;
    Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        gridMain = findViewById(R.id.grid_main);
        setSingleEvent(gridMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
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
                Intent intentRss = new Intent(MainActivity.this, RSSActivity.class);
                MainActivity.this.startActivity(intentRss);
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
                        //Config.url_temp = Config.url_ligne_1;
                        Config.url_temp = Config.L1;
                        Intent intentL1 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL1);

                    } else if (finalI == 1) {
                        //Config.url_temp = Config.url_ligne_2;
                        Config.url_temp = Config.L2;
                        Intent intentL2 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL2);

                    } else if (finalI == 2) {
                        //Config.url_temp = Config.url_ligne_3;
                        Config.url_temp = Config.L3;
                        Intent intentL3 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL3);

                    } else if (finalI == 3) {
                        //Config.url_temp = Config.url_ligne_4;
                        Config.url_temp = Config.L4;
                        Intent intentL4 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL4);

                    } else if (finalI == 4) {
                        //Config.url_temp = Config.url_ligne_5;
                        Config.url_temp = Config.L5;
                        Intent intentL5 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL5);

                    } else if (finalI == 5) {
                        //Config.url_temp = Config.url_ligne_6;
                        Config.url_temp = Config.L6;
                        Intent intentL6 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL6);

                    } else if (finalI == 6) {
                        //Config.url_temp = Config.url_ligne_7;
                        Config.url_temp = Config.L7;
                        Intent intentL7 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL7);

                    } else if (finalI == 7) {
                        //Config.url_temp = Config.url_ligne_8;
                        Config.url_temp = Config.L8;
                        Intent intentL8 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL8);

                    } else if (finalI == 8) {
                        //Config.url_temp = Config.url_ligne_9;
                        Config.url_temp = Config.L9;
                        Intent intentL9 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL9);

                    } else if (finalI == 9) {
                        //Config.url_temp = Config.url_ligne_10;
                        Config.url_temp = Config.L10;
                        Intent intentL10 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentL10);

                    } else if (finalI == 10) {
                        //Config.url_temp = Config.url_ligne_d1;
                        Config.url_temp = Config.LD1;
                        Intent intentLD1 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentLD1);

                    } else if (finalI == 11) {
                        //Config.url_temp = Config.url_ligne_d2;
                        Config.url_temp = Config.LD2;
                        Intent intentLD2 = new Intent(MainActivity.this, PDFActivity.class);
                        startActivity(intentLD2);

                    } else {
                        Toast.makeText(MainActivity.this, "Erreur activité invalide. Contacter l'administrateur", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}