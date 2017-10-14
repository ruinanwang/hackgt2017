package io.github.httpssophiasun0515.hackgt2017;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btnShowCoord;
    EditText edtAddress;
    TextView txtCoord;
    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowCoord = (Button) findViewById(R.id.btnShowCoordinates);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        txtCoord = (TextView) findViewById(R.id.txtCoordinates);

        class GetCoordinates extends AsyncTask<String, Void, String> {
            ProgressDialog dialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog.setMessage("Please wait ...");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String response;
                try {
                    String address = strings[0];
                    HTTPDataHandler http = new HTTPDataHandler();
                    String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s", address);
                    response = http.getHTTPData(url);
                    return response;
                } catch (Exception ex) {

                }
                return null;

            }

            @Override
            protected void onPostExecute(String s) {

                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray addressComp = (JSONArray)(((JSONArray)jsonObject.get("results")).getJSONObject(0).get("address_components"));
                    for (int i = 0; i < addressComp.length(); i++) {
                        boolean hasLocality = false;
                        JSONObject cur = (JSONObject) addressComp.get(i);
                        JSONArray types = (JSONArray) cur.get("types");
                        for (int j = 0; j < types.length(); j++) {
                            if (types.get(j).equals("locality")) {
                                hasLocality = true;
                                break;
                            }
                        }
                        if (hasLocality) {
                            cityName = cur.get("short_name").toString();
                            txtCoord.setText(cityName);
                        }
                    }

                    Log.d("nancy debug", cityName);
//                    String lng = ((JSONArray)jsonObject.get("resultsgeor")).getJSONObject(0).getJSONObject("geometry")
//                            .getJSONObject("location").get("lng").toString();
//                    txtCoord.setText(String.format("Coordinates: %s / %s",lat, lng));

                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        btnShowCoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetCoordinates().execute(edtAddress.getText().toString().replace(" ","+"));
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
