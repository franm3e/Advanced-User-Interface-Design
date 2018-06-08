package es.uclm.daui.datarunning.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.uclm.daiu.datarunning.R;


public class ListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] carreras;
    private final String[] tiempos;
    private final String[] posiciones;

    public ListViewAdapter(Activity context, String[] carreras, String[] tiempos, String[] posiciones) {
        super(context, R.layout.program_list, carreras);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.carreras = carreras;
        this.tiempos = tiempos;
        this.posiciones = posiciones;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.program_list, null, true);

        TextView carrera = (TextView) rowView.findViewById(R.id.carrera);
        TextView tiempo = (TextView) rowView.findViewById(R.id.tiempo);
        TextView posicion = (TextView) rowView.findViewById(R.id.posicion);

        carrera.setText(carreras[position]);
        tiempo.setText(tiempos[position]);
        posicion.setText(posiciones[position]);

        return rowView;

    };
}