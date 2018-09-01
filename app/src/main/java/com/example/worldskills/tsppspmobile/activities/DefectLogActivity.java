package com.example.worldskills.tsppspmobile.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;

import com.example.worldskills.tsppspmobile.R;

public class DefectLogActivity extends AppCompatActivity {

    Button tiempo,stop,start,reset;
    Spinner type,injected,removed;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializarElementos();

    }

    private void inicializarElementos() {
        tiempo,stop,start,reset;
        Spinner type,injected,removed;
        Chronometer chronometer;
    }
}
