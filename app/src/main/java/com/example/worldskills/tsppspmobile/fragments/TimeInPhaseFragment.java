package com.example.worldskills.tsppspmobile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.data.Datos;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeInPhaseFragment extends Fragment {


    TextView txtPlan;
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
            txtPlan.setText(datos.sumaPlan()+"");
        return view;
    }

}
