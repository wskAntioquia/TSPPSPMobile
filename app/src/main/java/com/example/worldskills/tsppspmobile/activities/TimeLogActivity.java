package com.example.worldskills.tsppspmobile.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.data.Constantes;
import com.example.worldskills.tsppspmobile.data.Datos;
import com.example.worldskills.tsppspmobile.models.TimeLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TimeLogActivity extends AppCompatActivity {

    TextView txtStart,txt_stop,txt_delta;
    Spinner spinner;
    Button btnStart,btnStop,btnGuardar;
    TextInputEditText interruoption;
    EditText descripcion;
    ArrayAdapter<String>adapter;
    Date dateStart,dateStop;
    Datos datos;
    SimpleDateFormat dateFormat;
    long diferencia;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializarElementos();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateStart=new Date();
                dateFormat=new SimpleDateFormat("dd/MM/yy hh:mm");
                String fechaStart=dateFormat.format(dateStart);
                txtStart.setText(fechaStart);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateStop=new Date();
                dateFormat=new SimpleDateFormat("dd/MM/yy hh:mm");
                String fechaStop=dateFormat.format(dateStop);
                txt_stop.setText(fechaStop);
                hacerCalculoFechas(dateStop,dateStart);
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()){
                    TimeLog timeLog=new TimeLog();
                    if (spinner.getSelectedItemId()==Constantes.PLAN){
                        timeLog.setPhase("PLAN");
                    }else if (spinner.getSelectedItemId()==Constantes.DLD){
                        timeLog.setPhase("DLD");
                    }else if (spinner.getSelectedItemId()==Constantes.CODE){
                        timeLog.setPhase("CODE");
                    }else if (spinner.getSelectedItemId()==Constantes.COMPILE){
                        timeLog.setPhase("COMPILE");
                    }else if (spinner.getSelectedItemId()==Constantes.UT){
                        timeLog.setPhase("UT");
                    }else if (spinner.getSelectedItemId()==Constantes.PM){
                        timeLog.setPhase("PM");
                    }
                    timeLog.setStart(txtStart.getText().toString());
                    timeLog.setStop(txt_stop.getText().toString());
                    timeLog.setStop(txt_stop.getText().toString());
                    timeLog.setId_project(id);
                    timeLog.setDelta(Integer.parseInt(txt_delta.getText().toString()));
                    if (datos.guardarNuevoTimeLog(timeLog)){
                        Toast.makeText(getApplicationContext(), "phase Guardada", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                    }else {
                        Toast.makeText(getApplicationContext(), "no se pudo guardar la phase", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                    }


                }
            }
        });

    }

    //para limpiar los campos del furmulacio
    private void limpiarCampos() {
        txtStart.setText("");
        txt_stop.setText("");
        interruoption.getText().clear();
        txt_delta.setText("");
        descripcion.getText().clear();

    }

    //validar que los campo no esten vacios
    private boolean validarCampos() {
        if (spinner.getSelectedItemId()==0){
            Toast.makeText(this, "debe seleccionar una phase", Toast.LENGTH_SHORT).show();
            return false;
        }else if (txtStart.getText().toString().isEmpty()){
            Toast.makeText(this, "debe asignar una tiempo de inicio", Toast.LENGTH_SHORT).show();
            return false;
        }else if (txt_stop.getText().toString().isEmpty()){
            Toast.makeText(this, "debe asignar una tiempo de fin", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //calcilar las fechas de los botones que lo necesitan
    private void hacerCalculoFechas(Date dateStop, Date dateStart) {
        if (interruoption.getText().toString().isEmpty()  || interruoption.getText().toString().equals("0")){
            diferencia=(dateStop.getTime()-dateStart.getTime());
            long segundos=1000;
            long minutos=segundos*60;
            int delta= (int) (diferencia/minutos);
            txt_delta.setText(delta+"");
        }else {
            diferencia=(dateStop.getTime()-dateStart.getTime());
            int dif= (int) diferencia;
            int interrupcion= Integer.parseInt(interruoption.getText().toString());
            int del=(dif-interrupcion);
            long segundos=1000;
            long minutos=segundos*60;
            int delta= (int) (del/minutos);
            txt_delta.setText(delta+"");
        }
    }

    //inicializar los elementos de la interfaz grafica
    private void inicializarElementos() {
        datos=new Datos(this);
         txtStart=findViewById(R.id.txt_start);
         txt_stop=findViewById(R.id.txt_stop);
         txt_delta=findViewById(R.id.txt_delta);
        spinner=findViewById(R.id.spinner_time_log);
        btnStart=findViewById(R.id.btn_start);
        btnStop=findViewById(R.id.btn_stop);
        btnGuardar=findViewById(R.id.btn_guardar_phase);
        interruoption=findViewById(R.id.txt_interrupion);
        descripcion=findViewById(R.id.txt_description);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Constantes.PHASES);
        spinner.setAdapter(adapter);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            id=bundle.getInt("id");
            txtStart.setText(id+"");
        }
    }
}
