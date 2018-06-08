/********************************************************/
/*  ACTIVITY: Init                                      */
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

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

import es.uclm.daiu.datarunning.R;


public class RaceInfo extends AppCompatActivity {

    int index = 5;
    String genero = "";
    int tiempo = 0;
    int nhombres = 0;
    int nmujeres = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raceinfo);

        final TextView hombres = (TextView)findViewById(R.id.textView14);
        final TextView mujeres = (TextView)findViewById(R.id.textView15);
        final TextView total = (TextView)findViewById(R.id.total);


        SearchView simpleSearchView = (SearchView) findViewById(R.id.searcher);
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.equals("Francisco Martinez")){
                    Intent intent = new Intent(getApplicationContext(), Searchforarunnerpage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not a registered user! Try it again!", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // do something when text changes
                return false;
            }

        });

        // Define the first graph
        GraphView graph = (GraphView) findViewById(R.id.graph);

        // Initialize the series of points in the graph
        final LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{});
        // Set the series color
        series.setColor(Color.parseColor("#2aa3cc"));
        // And add the series to the first graph
        graph.addSeries(series);
        // Set the axis
        Viewport vp = graph.getViewport();
        vp.setXAxisBoundsManual(true);
        vp.setMinX(0);
        vp.setMaxX(20);

        // Custom label formatter to show minutes:seconds format
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // Show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // Show currency for y values
                    return super.formatLabel(value, isValueX) + ":00";
                }
            }
        });


        // Second graph
        GraphView graph2 = (GraphView) findViewById(R.id.graph2);

        // Create a PointsGraphSeries, not a line
        final PointsGraphSeries<DataPoint> newwoman = new PointsGraphSeries<>(new DataPoint[] {});
        graph2.addSeries(newwoman);
        // Set the TRIANGLE like the shape of the points
        newwoman.setShape(PointsGraphSeries.Shape.TRIANGLE);
        // Set the color
        newwoman.setColor(Color.parseColor("#ff8ad8"));

        // Another PointsGraphSeries
        final PointsGraphSeries<DataPoint> newman = new PointsGraphSeries<DataPoint>(new DataPoint[] {});
        graph2.addSeries(newman);
        newman.setShape(PointsGraphSeries.Shape.POINT);
        newman.setColor(Color.parseColor("#4a9fff"));

        Viewport vp2 = graph2.getViewport();
        vp2.setXAxisBoundsManual(true);
        vp2.setMinX(0);
        vp2.setMaxX(20);

        // Custom label formatter to show minutes:seconds format
        graph2.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + ":00";
                }
            }
        });


        // Create a CountDownTimer with 10 ticks
        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {

                        // Create HTTP request to the server in IBMCLOUD
                        URL dataserver = null;
                        try {
                            dataserver = new URL("https://servidordatos.eu-gb.mybluemix.net/datosDataRunning");
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                        try {
                            HttpsURLConnection myConnection = (HttpsURLConnection) dataserver.openConnection();
                            int responseCode = myConnection.getResponseCode();

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

                                // Create the JSON object
                                JSONObject obj = new JSONObject(response.toString());

                                // Obtain the data from the JSON
                                genero = obj.getString("genero");
                                tiempo = obj.getInt("tiempo");

                                // Close the document
                                in.close();

                                // Append data to the graph
                                series.appendData(new DataPoint(index, tiempo), true, 40);

                                // Increment the index
                                index++;

                                // In order to upload the ui elements
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // If the simulated runner is a man we add this to the men series.
                                        if(genero.equals("masculino")){
                                            newman.appendData(new DataPoint(index, tiempo), true, 40);
                                            nhombres++;
                                            hombres.setText(String.valueOf(nhombres));
                                        }else{
                                            newwoman.appendData(new DataPoint(index, tiempo), true, 40);
                                            nmujeres++;
                                            mujeres.setText(String.valueOf(nmujeres));
                                        }
                                        // Increase the total runners
                                        total.setText(String.valueOf(nmujeres+nhombres));
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

            @Override
            public void onFinish() {
                // When the countdown finish, it will be restarted.
                start();

            }

        }.start();;

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_init, menu);
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

