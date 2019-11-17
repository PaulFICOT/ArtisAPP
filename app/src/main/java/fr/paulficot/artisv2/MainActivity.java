package fr.paulficot.artisv2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * Application d'envoi de mail pour le SIQ de la mairie de RAISMES
 *
 * @author Paul FICOT
 * @version 1.1
 */

public class MainActivity extends AppCompatActivity {

    GridLayout main_Grid;

    /**
     * Display the view match the method while creating it
     * @param savedInstanceState save the state of the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_Grid = findViewById(R.id.mainGrid);

        //set Event
        setSingleEvent(main_Grid);
    }

    /**
     * Create a children cardview for finalI
     * @param main_Grid grid layout de l'activité MainActivity
     */
    private void setSingleEvent(GridLayout main_Grid) {
        //Loop all children of mainGrid
        for (int i = 0; i < main_Grid.getChildCount(); i++) {
            CardView main_cardView = (CardView) main_Grid.getChildAt(i);
            final int finalI = i;
            main_cardView.setOnClickListener(new View.OnClickListener() {
                                                 /**
                                                  *
                                                  * @param grid_view vue de main_Grid
                                                  */
                                                 @Override
                                                 public void onClick(View grid_view) {

                                                     if (finalI == 0)
                                                     {
                                                         String url_11 = Config.url_ligne_1;

                                                         Intent ligne_1_intent = new Intent();
                                                         ligne_1_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_1_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_1_intent.setData(Uri.parse(url_11));
                                                         startActivity(ligne_1_intent);

                                                     } else if (finalI == 1)
                                                     {
                                                         String url_l2 = Config.url_ligne_2;

                                                         Intent ligne_2_intent = new Intent();
                                                         ligne_2_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_2_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_2_intent.setData(Uri.parse(url_l2));
                                                         startActivity(ligne_2_intent);

                                                     } else if (finalI == 2)
                                                     {
                                                         String url_l3 = Config.url_ligne_3;

                                                         Intent ligne_3_intent = new Intent();
                                                         ligne_3_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_3_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_3_intent.setData(Uri.parse(url_l3));
                                                         startActivity(ligne_3_intent);

                                                     } else if (finalI == 3)
                                                     {
                                                         String url_l4 = Config.url_ligne_4;

                                                         Intent ligne_4_intent = new Intent();
                                                         ligne_4_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_4_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_4_intent.setData(Uri.parse(url_l4));
                                                         startActivity(ligne_4_intent);

                                                     } else if (finalI == 4)
                                                     {
                                                         String url_l5 = Config.url_ligne_5;

                                                         Intent ligne_5_intent = new Intent();
                                                         ligne_5_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_5_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_5_intent.setData(Uri.parse(url_l5));
                                                         startActivity(ligne_5_intent);

                                                     } else if (finalI == 5)
                                                     {
                                                         String url_l6 = Config.url_ligne_6;

                                                         Intent ligne_6_intent = new Intent();
                                                         ligne_6_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_6_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_6_intent.setData(Uri.parse(url_l6));
                                                         startActivity(ligne_6_intent);

                                                     } else if (finalI == 6)
                                                     {
                                                         String url_l7 = Config.url_ligne_7;

                                                         Intent ligne_7_intent = new Intent();
                                                         ligne_7_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_7_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_7_intent.setData(Uri.parse(url_l7));
                                                         startActivity(ligne_7_intent);

                                                     } else if (finalI == 7)
                                                     {
                                                         String url_l8 = Config.url_ligne_8;

                                                         Intent ligne_8_intent = new Intent();
                                                         ligne_8_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_8_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_8_intent.setData(Uri.parse(url_l8));
                                                         startActivity(ligne_8_intent);

                                                     } else if (finalI == 8)
                                                     {
                                                         String url_l9 = Config.url_ligne_9;

                                                         Intent ligne_9_intent = new Intent();
                                                         ligne_9_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_9_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_9_intent.setData(Uri.parse(url_l9));
                                                         startActivity(ligne_9_intent);

                                                     } else if (finalI == 9)
                                                     {
                                                         String url_l10 = Config.url_ligne_10;

                                                         Intent ligne_10_intent = new Intent();
                                                         ligne_10_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_10_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_10_intent.setData(Uri.parse(url_l10));
                                                         startActivity(ligne_10_intent);

                                                     } else if (finalI == 10)
                                                     {
                                                         String url_d1 = Config.url_ligne_d1;

                                                         Intent ligne_d1_intent = new Intent();
                                                         ligne_d1_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_d1_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_d1_intent.setData(Uri.parse(url_d1));
                                                         startActivity(ligne_d1_intent);

                                                     } else if (finalI == 11)
                                                     {
                                                         String url_d2 = Config.url_ligne_d2;

                                                         Intent ligne_d2_intent = new Intent();
                                                         ligne_d2_intent.setAction(Intent.ACTION_VIEW);
                                                         ligne_d2_intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                                         ligne_d2_intent.setData(Uri.parse(url_d2));
                                                         startActivity(ligne_d2_intent);

                                                     } else
                                                     {
                                                         Toast.makeText(MainActivity.this, "Erreur, contactez moi ici : paul.ficot@yahoo.fr", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
                                             }
            );
        }
    }
}

