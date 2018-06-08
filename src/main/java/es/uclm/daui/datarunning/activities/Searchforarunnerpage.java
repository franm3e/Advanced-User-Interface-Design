/********************************************************/
/*  ACTIVITY: Search for a runner page                    */
/*                                                      */
/*  Generated with UML2Android                          */
/*  University of Castilla-La Mancha                    */
/*  Escuela Superior de Ingenieria informatica          */
/*  By: Victor Lopez-Jaquero                            */
/*                                                      */
/*  Author: Francisco Martinez Esteso                   */
/*                                                      */
/********************************************************/

package es.uclm.daui.datarunning.activities;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import es.uclm.daiu.datarunning.R;


public class Searchforarunnerpage extends AppCompatActivity {


    String[] carreras = new String[100];
    String[] tiempos = new String[100];
    String[] posiciones = new String[100];

    private ListView lvList;
    ListViewAdapter adapter;

    int totalraces = 4;
    int podiums = 1;
    double time = 0;
    String race = "";
    int rank = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchforarunnerpage);

        // Initialize the started data
        carreras[0] = "XV Popular Race of Albacete";
        carreras[1] = "XV Popular Race of Cuenca";
        carreras[2] = "XXII Half Marathon of Valencia";
        carreras[3] = "XXX Popular Race of La Roda";

        tiempos[0] = "00:32:15";
        tiempos[1] = "01:05:06";
        tiempos[2] = "01:21:15";
        tiempos[3] = "00:42:12";

        posiciones[0] = "122";
        posiciones[1] = "2";
        posiciones[2] = "12";
        posiciones[3] = "35";

        // Initialize the started ui elements
        Button actualizar = (Button) findViewById(R.id.button);
        final TextView total_races = (TextView) findViewById(R.id.textview68);
        final TextView total_podiums = (TextView) findViewById(R.id.textView6);
        lvList = (ListView) findViewById(R.id.listvieww);

        // Call list view adapter constructor
        adapter = new ListViewAdapter(Searchforarunnerpage.this, carreras, tiempos, posiciones);
        // Assign Above Array Adapter to ListView
        lvList.setAdapter(adapter);
        // Create ListView Item click listener
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), carreras[position], Toast.LENGTH_LONG).show();
                }
            });

        SearchView simpleSearchView = (SearchView) findViewById(R.id.searcher);
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // There is only a user call Francisco Martinez
                if (query.equals("Francisco Martinez")) {
                    Intent intent = new Intent(getApplicationContext(), Searchforarunnerpage.class);
                    startActivity(intent);
                    // If other user is introduced as a query
                } else {
                    Toast.makeText(getApplicationContext(), "Not a registered user! Try it again!", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Do something when text changes
                return false;
            }
        });

        // Add OnClick Listener to the button Actualizar.
        actualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {

                    @Override
                    public void run() {
                        // HTTP request to our server in IBM CLOUD
                        URL dataserver = null;
                        try {
                            dataserver = new URL("https://servidordatos.eu-gb.mybluemix.net/newRaceInfo");
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                        try {
                            HttpsURLConnection myConnection = (HttpsURLConnection) dataserver.openConnection();
                            int responseCode = myConnection.getResponseCode();

                            // If the conection is OK!
                            if (myConnection.getResponseCode() == 200) {
                                InputStream responseBody = myConnection.getInputStream();
                                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                                JsonReader jsonReader = new JsonReader(responseBodyReader);

                                BufferedReader in = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
                                String inputLine;
                                StringBuffer response = new StringBuffer();

                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                    System.out.println(inputLine);
                                }
                                // Create a JSON object with the response.
                                JSONObject obj = new JSONObject(response.toString());

                                // Extract the data from the JSON
                                race = obj.getString("race");
                                time = obj.getDouble("time");
                                rank = obj.getInt("rank");

                                // Only for debug in console
                                System.out.println("RACE: " + race);
                                System.out.println("TIME: " + time);
                                System.out.println("RANK: " + rank);

                                // Close the conection
                                in.close();

                                // For make changes in the ui thread
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {

                                        // Update the database
                                        carreras[totalraces] = race;
                                        // If the simulated data is a half marathon we change the format because it has to be in hours.
                                        if (race.contains("Half Marathon")){
                                            tiempos[totalraces] = "01:" + String.valueOf(time);
                                        }else{
                                            tiempos[totalraces] = "00:" + String.valueOf(time);
                                        }

                                        posiciones[totalraces] = String.valueOf(rank);
                                        // Notify the changes
                                        adapter.notifyDataSetChanged();
                                        // Update the visual elements in the screen
                                        totalraces++;
                                        total_races.setText(String.valueOf(totalraces));
                                        // If the rank of this race is less than 3 we add a podium to the count
                                        if(rank <= 3){
                                            podiums++;
                                            total_podiums.setText(String.valueOf(podiums));
                                        }
                                    }
                                });

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    // To go to the previous page
    @Override
    public void onBackPressed() {
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_searchforarunnerpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, as long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        Intent intentSettings = new Intent(this, SettingsActivity.class);
        startActivity(intentSettings);
        return true;
    }

    return super.onOptionsItemSelected(item);
    }

}

