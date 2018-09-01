package com.example.worldskills.tsppspmobile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.data.Datos;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeInPhaseFragment extends Fragment {


    TextView txtPlan;
    EditText tiempo;
    Button save_tiempo;
    Datos datos;
    public TimeInPhaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_time_in_phase, container, false);
            datos=new Datos(getContext());
            txtPlan=view.findViewById(R.id.txt_plan_total);
            save_tiempo=view.findViewById(R.id.btn_guardar_tiempo);
            tiempo=view.findViewById(R.id.txt_tiempo_project);
            save_tiempo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            txtPlan.setText(datos.sumaPlan()+"");
        return view;
    }

}
