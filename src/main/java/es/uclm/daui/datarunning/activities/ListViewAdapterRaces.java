package es.uclm.daui.datarunning.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import es.uclm.daiu.datarunning.R;


public class ListViewAdapterRaces extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] carreras;
    private final String[] index;
    private final String[] niveles;


    public ListViewAdapterRaces(Activity context, String[] carreras, String[] index, String[] niveles) {
        super(context, R.layout.program_list, carreras);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.carreras = carreras;
        this.index = index;
        this.niveles = niveles;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        // I create a layout to make the design of the list rows
        View rowView = inflater.inflate(R.layout.program_races, null, true);

        // Put the initial data in the ListView layout
        TextView carrera = (TextView) rowView.findViewById(R.id.carreraa);
        TextView indexx = (TextView) rowView.findViewById(R.id.index);
        TextView niveless = (TextView) rowView.findViewById(R.id.niveless);

        carrera.setText(carreras[position]);
        indexx.setText(index[position]);
        niveless.setText(niveles[position]);

        return rowView;

    }
}