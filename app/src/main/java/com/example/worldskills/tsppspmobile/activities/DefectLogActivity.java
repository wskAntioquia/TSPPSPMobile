package com.example.worldskills.tsppspmobile.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.data.Constantes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefectLogActivity extends AppCompatActivity {

    Button btntiempo,stop,start,restart;
    Spinner type,injected,removed;
    TextView tiempo;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializarElementos();
        btntiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date=new Date();
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yy hh:mm");
                String fechaStart=dateFormat.format(date);
                tiempo.setText(fechaStart);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });

    }

    private void inicializarElementos() {
    tiempo=findViewById(R.id.txt_timpo_defect_log);
    stop=findViewById(R.id.button_stop);
    start=findViewById(R.id.button_play);
    restart=findViewById(R.id.button_restart);
    type=findViewById(R.id.spinner_type);
    injected=findViewById(R.id.spinner_injected);
    btntiempo=findViewById(R.id.btn_tiempo_defect_log);
    removed=findViewById(R.id.spinner_removed);
    chronometer=findViewById(R.id.cronometro);
    ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Constantes.PHASES);
    injected.setAdapter(adapter);
    removed.setAdapter(adapter);
    ArrayAdapter<String>adapter1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Constantes.TYPES);
    type.setAdapter(adapter1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        chronometer.stop();
    }
}
