package fr.paulficot.artisv3;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import fr.paulficot.artisv3.Adapter.FeedAdapter;
import fr.paulficot.artisv3.Common.HTTPDataHandler;
import fr.paulficot.artisv3.Model.RSSObject;

public class RSSActivity extends AppCompatActivity {

    Toolbar toolbarRss;
    RecyclerView recyclerRss;
    RSSObject rssObjectRss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        toolbarRss = findViewById(R.id.toolbar_rss);
        setSupportActionBar(toolbarRss);

        recyclerRss = (RecyclerView)findViewById(R.id.recycler_rss);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerRss.setLayoutManager(linearLayoutManager);

        loadRSS();

    }

    @Override
    public void onBackPressed() {
        Intent intentRss = new Intent(RSSActivity.this, MainActivity.class);
        RSSActivity.this.startActivity(intentRss);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rss_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intentHome = new Intent(RSSActivity.this, MainActivity.class);
                RSSActivity.this.startActivity(intentHome);
                return true;

            case R.id.menu_website:
                String url_website = Config.url_artis_website;

                Intent intentWeb = new Intent();
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.addCategory(Intent.CATEGORY_BROWSABLE);

                intentWeb.setData(Uri.parse(url_website));
                startActivity(intentWeb);
                return true;

            case R.id.menu_refresh:
                loadRSS();

        }
        return super.onOptionsItemSelected(item);
    }

    private void loadRSS() {
        @SuppressLint("StaticFieldLeak") AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(RSSActivity.this);

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Veuiller patienter...");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                rssObjectRss = new Gson().fromJson(s,RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObjectRss,getBaseContext());
                recyclerRss.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };



        loadRSSAsync.execute(Config.RSS_to_Json_API + Config.RSS_URL);
    }

}
