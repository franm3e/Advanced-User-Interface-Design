package es.uclm.daui.datarunning.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import es.uclm.daiu.datarunning.R;


public class SecondFragment extends Fragment {

    String[] index = new String[]{
            "1",
            "2",
            "3",
            "4"
    };

    String[] names = new String[]{
            "Siro Lorenzo Martínez",
            "Sergio Canto Carrión",
            "Francisco Martínez Esteso",
            "Daniel Jimenez Holmes"
    };

    String[] categories = new String[]{
            "Male Veteran B ",
            "Male Veteran A",
            "Male Veteran G",
            "Male Junior"
    };

    String[] clubs = new String[]{
            "520",
            "413",
            "410",
            "410",
    };



    private ListView lvList;
    ListViewAdapterBestRunners adapter;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        lvList = (ListView) view.findViewById(R.id.listabest);
        // Call list view adapter constructor
        adapter = new ListViewAdapterBestRunners(SecondFragment.this.getActivity(), index, names, categories, clubs);
        // Assign Above Array Adapter to ListView
        lvList.setAdapter(adapter);

        // A new graph
        GraphView graph = (GraphView) view.findViewById(R.id.graph3);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 33.15),
                new DataPoint(1, 33.50),
                new DataPoint(2, 34.23),
                new DataPoint(3, 35.15),
                new DataPoint(4, 36.23)
        });
        series.setColor(Color.parseColor("#c84a3e"));
        graph.addSeries(series);
        Viewport vp = graph.getViewport();
        vp.setXAxisBoundsManual(true);
        vp.setMinX(0);
        vp.setMaxX(5);

        // Custom label formatter to show in format minutes:seconds
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
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

        // Create a PointsGraphSeries
        PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 33.15)
        });
        graph.addSeries(series1);
        series1.setShape(PointsGraphSeries.Shape.POINT);
        series1.setColor(Color.parseColor("#c84a3e"));

        // Another PointsGraphSeries
        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 33.50)
        });
        graph.addSeries(series2);
        series2.setShape(PointsGraphSeries.Shape.POINT);
        series2.setColor(Color.parseColor("#c84a3e"));

        // Another PointsGraphSeries
        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(2, 34.23)
        });
        graph.addSeries(series3);
        series3.setShape(PointsGraphSeries.Shape.POINT);
        series3.setColor(Color.parseColor("#c84a3e"));

        // Another PointsGraphSeries
        PointsGraphSeries<DataPoint> series4 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(3, 35.15)
        });
        graph.addSeries(series4);
        series4.setShape(PointsGraphSeries.Shape.POINT);
        series4.setColor(Color.parseColor("#c84a3e"));

        // Another PointsGraphSeries
        PointsGraphSeries<DataPoint> series5 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(4, 36.23)
        });
        graph.addSeries(series5);
        series5.setShape(PointsGraphSeries.Shape.POINT);
        series5.setColor(Color.parseColor("#c84a3e"));

        // I create 5 different PointsGraphSeries in order to create different labels when you click it.
        series1.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Sergio Canto Carrión \nRace: XX Popular Race of Montealegre", Toast.LENGTH_SHORT).show();
            }
        });

        series2.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Siro Lorenzo Alfaro \nRace: X Popular Race of Chinchilla", Toast.LENGTH_SHORT).show();
            }
        });

        series3.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Pedro Lopez de Haro \nRace: XVI Popular Race of El Salobral", Toast.LENGTH_SHORT).show();
            }
        });

        series4.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Alvaro de Gracia Romero \n Race: II Popular Race of Casasimarro", Toast.LENGTH_SHORT).show();
            }
        });

        series5.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Sergio Alfaro Lopez \nRace: XX Popular Race of Montealegre", Toast.LENGTH_SHORT).show();
            }
        });

        // The same graph with the Half Marathon data
        GraphView graph4 = (GraphView) view.findViewById(R.id.graph4);
        LineGraphSeries<DataPoint> series40 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 02.03),
                new DataPoint(1, 04.04),
                new DataPoint(2, 09.08),
                new DataPoint(3, 10.12),
                new DataPoint(4, 20.17)
        });
        series40.setColor(Color.parseColor("#b9dcd6"));
        graph4.addSeries(series40);
        Viewport vp2 = graph4.getViewport();
        vp2.setXAxisBoundsManual(true);
        vp2.setMinX(0);
        vp2.setMaxX(5);

        // Custom label formatter to show format hours:minutes:seconds
        graph4.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return "01:" + super.formatLabel(value, isValueX);
                }
            }
        });

        // I repeat again the process of creating the PointsGraphSeries and its ClickListener
        PointsGraphSeries<DataPoint> series41 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 02.03)
        });
        graph4.addSeries(series41);
        series41.setShape(PointsGraphSeries.Shape.POINT);
        series41.setColor(Color.parseColor("#b9dcd6"));

        PointsGraphSeries<DataPoint> series42 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 04.04)
        });
        graph4.addSeries(series42);
        series42.setShape(PointsGraphSeries.Shape.POINT);
        series42.setColor(Color.parseColor("#b9dcd6"));

        PointsGraphSeries<DataPoint> series43 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(2, 09.08)
        });
        graph4.addSeries(series43);
        series43.setShape(PointsGraphSeries.Shape.POINT);
        series43.setColor(Color.parseColor("#b9dcd6"));

        PointsGraphSeries<DataPoint> series44 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(3, 10.12)
        });
        graph4.addSeries(series44);
        series44.setShape(PointsGraphSeries.Shape.POINT);
        series44.setColor(Color.parseColor("#b9dcd6"));

        PointsGraphSeries<DataPoint> series45 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(4, 20.17)
        });
        graph4.addSeries(series45);
        series45.setShape(PointsGraphSeries.Shape.POINT);
        series45.setColor(Color.parseColor("#b9dcd6"));


        series41.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Sergio Canto Carrión \nRace: XX Half Marathon of Albacete", Toast.LENGTH_SHORT).show();
            }
        });

        series42.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Siro Lorenzo Alfaro \nRace: XX Half Marathon of Albacete", Toast.LENGTH_SHORT).show();
            }
        });

        series43.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Pedro Lopez de Haro \nRace: XX Half Marathon of Albacete", Toast.LENGTH_SHORT).show();
            }
        });

        series44.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Alvaro de Gracia Romero \n Race: XX Half Marathon of Albacete", Toast.LENGTH_SHORT).show();
            }
        });

        series45.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Runner: Sergio Alfaro Lopez \nRace: XX Half Marathon of Albacete", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
