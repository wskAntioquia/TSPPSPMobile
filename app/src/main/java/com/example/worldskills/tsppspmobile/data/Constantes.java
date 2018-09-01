package com.example.worldskills.tsppspmobile.data;

import android.provider.BaseColumns;

import java.util.ArrayList;

public class Constantes implements BaseColumns {

    public final static String TBL_PROJECTS="projects";
    public final static String NOMBRE="nombre";
    public final static String TIEMPO="tiempo";


        public final static ArrayList<String> PHASES=new ArrayList<String>(){{
            add("Selecione una opcion");
            add("PLAN");
            add("DLD");
            add("CODE");
            add("COMPILE");
            add("UT");
            add("PM");
        }};


    public final static String TBL_TIME_LOG="time_log";
    public final static String PHASE="phase";
    public final static String START="start";
    public final static String STOP="stop";
    public final static String DELTA="delta";
    public final static String ID_PROJECT="id_project";
    public final static int PLAN=1;
    public final static int DLD=2;
    public final static int CODE=3;
    public final static int COMPILE=4;
    public final static int UT=5;
    public final static int PM=6;

}
