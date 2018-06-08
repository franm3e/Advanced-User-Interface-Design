package es.uclm.daui.datarunning.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import es.uclm.daiu.datarunning.R;


public class ListViewAdapterBestRunners extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] nombres;
    private final String[] index;
    private final String[] categorias;
    private final String[] clubs;

    public ListViewAdapterBestRunners(Activity context, String[] index, String[] nombres, String[] categorias, String[] clubs) {
        super(context, R.layout.program_bestrunners, nombres);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.nombres = nombres;
        this.index = index;
        this.categorias = categorias;
        this.clubs = clubs;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.program_bestrunners, null, true);

        TextView namee = (TextView) rowView.findViewById(R.id.namee);
        TextView indexx = (TextView) rowView.findViewById(R.id.indexxx);
        TextView categoriass = (TextView) rowView.findViewById(R.id.categoryy);
        TextView clubss = (TextView) rowView.findViewById(R.id.clubb);

        namee.setText(nombres[position]);
        indexx.setText(index[position]);
        categoriass.setText(categorias[position]);
        clubss.setText(clubs[position]);

        return rowView;

    };
}