package com.example.worldskills.tsppspmobile.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.tsppspmobile.models.Projecto;

import java.util.ArrayList;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Cursor cursor;
    public Datos(Context context) {
        super(context, "tsp_1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_projects="CREATE TABLE " + Constantes.TBL_PROJECTS + "(" +
                Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Constantes.NOMBRE + " TEXT,"+
                Constantes.TIEMPO + " INTEGER)";
        db.execSQL(sql_projects);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean guardarNuevoProjecto(Projecto project){
        db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.NOMBRE,project.getNombre());
        values.put(Constantes.TIEMPO,project.getTiempo());
        return db.insert(Constantes.TBL_PROJECTS,null,values)>0;
    }

    public ArrayList<Projecto> listarProjectos(){
        db=getReadableDatabase();
        ArrayList<Projecto> projects=new ArrayList<>();
        Projecto project=null;
        cursor=db.rawQuery("SELECT * FROM " + Constantes.TBL_PROJECTS,null);
        if (cursor.moveToFirst()){
            do {
                project=new Projecto();
                project.setId(cursor.getInt(cursor.getColumnIndex(Constantes._ID)));
                project.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.NOMBRE)));
                projects.add(project);
            }while (cursor.moveToNext());
        }
        return projects;
    }
}
