package es.uclm.daui.datarunning.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import es.uclm.daiu.datarunning.R;


public class FirstFragment extends Fragment {

    // Data to include in the ListView
    String[] carreras = new String[]{
            "X Popular Race of Riopar",
            "XI Popular Race of Yeste",
            "IXX Popular Race of Elche de la Sierra",
            "X Popular Race of Villalgordo del Jucar",
            "XIV Popular Race of Molinicos",
            "IX Popular Race of Balazote",
            "XVIII Popular Race of Casas Ibáñez",
            "X Popular Race of Fuentealbilla",
            "XIX Ten Miles Madrigueras",
            "XIV Half Marathon of Villarrobledo",
            "VIII Popular Race of Minaya"
    };

    String[] tiempos = new String[]{
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11"
    };

    String[] niveles = new String[]{
            "A",
            "A",
            "A",
            "B",
            "A",
            "B",
            "B",
            "B",
            "B",
            "C",
            "B"
    };

    private ListView lvList;
    ListViewAdapterRaces adapter;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        lvList = (ListView) view.findViewById(R.id.listaraces);

        // Call list view adapter constructor
        adapter = new ListViewAdapterRaces(FirstFragment.this.getActivity(), carreras, tiempos, niveles);

        // Assign Above Array Adapter to ListView
        lvList.setAdapter(adapter);

        // Create ListView Item click listener
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // If the first position element is click, the app bring us the race selected screen.
                if(position==0){
                    Intent intent = new Intent(getActivity().getApplicationContext(), RaceInfo.class);
                    startActivity(intent);
                }
                // Else, the app doesn't have data
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Not data for " + carreras[position] + "! Try another one!", Toast.LENGTH_LONG).show();
            }
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

}