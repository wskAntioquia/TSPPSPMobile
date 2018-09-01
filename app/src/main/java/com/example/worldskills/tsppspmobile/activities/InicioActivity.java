package com.example.worldskills.tsppspmobile.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.data.Constantes;
import com.example.worldskills.tsppspmobile.data.Datos;
import com.example.worldskills.tsppspmobile.models.Projecto;

public class InicioActivity extends AppCompatActivity {

    ListView lista;
    Button guardar;
    TextInputEditText project;
    Datos datos;
    Projecto projecto=new Projecto();
    SimpleCursorAdapter adapter;
    String camposBD[]={Constantes._ID,Constantes.NOMBRE};
    int camposUI[]={R.id.content_id,R.id.content_nombre};
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        inicializarElementos();
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (project.getText().toString().isEmpty()){
                    Toast.makeText(InicioActivity.this, "debe ingresar el nombre del projecto", Toast.LENGTH_SHORT).show();
                }else {
                    projecto.setNombre(project.getText().toString());
                    projecto.setTiempo(0);
                    if (datos.guardarNuevoProjecto(projecto)){
                        Toast.makeText(InicioActivity.this, "Projecto guardado", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(InicioActivity.this, "Projecto no guardado", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
                int codig=cursor.getInt(cursor.getColumnIndex(Constantes._ID));
                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("codigo",codig);
                startActivity(intent);
            }
        });




    }

//inicializar los elemento de la interfaz grafica
    private void inicializarElementos() {
        lista=findViewById(R.id.lista_projects);
        guardar=findViewById(R.id.btn_guardar_project);
        project=findViewById(R.id.name_project);
        datos=new Datos(this);
        cursor=datos.listarProjectos();
        adapter=new SimpleCursorAdapter(this,R.layout.content_item_list,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
}
