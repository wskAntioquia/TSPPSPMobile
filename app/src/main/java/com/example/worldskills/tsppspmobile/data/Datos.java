package com.example.worldskills.tsppspmobile.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.tsppspmobile.models.Projecto;
import com.example.worldskills.tsppspmobile.models.TimeLog;

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

        String sql_time_log="CREATE TABLE " + Constantes.TBL_PROJECTS + "(" +
                Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Constantes.PHASE + " TEXT,"+
                Constantes.START + " TEXT,"+
                Constantes.STOP + " TEXT,"+
                Constantes.DELTA + " INTEGER,"+
                Constantes.ID_PROJECT + " INTEGER)";
        db.execSQL(sql_projects);
        db.execSQL(sql_time_log);

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

    public boolean guardarNuevoTimeLog(TimeLog timeLog){
        db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.PHASE,timeLog.getPhase());
        values.put(Constantes.START,timeLog.getStart());
        values.put(Constantes.STOP,timeLog.getStop());
        values.put(Constantes.DELTA,timeLog.getDelta());
        values.put(Constantes.ID_PROJECT,timeLog.getId_project());
        return db.insert(Constantes.TBL_TIME_LOG,null,values)>0;
    }

    public Cursor listarProjectos(){
        db=getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM " + Constantes.TBL_PROJECTS,null);
        if (cursor.moveToFirst()){
            return cursor;
        }else{
            return null;
        }

    }
}
