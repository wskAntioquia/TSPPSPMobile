package com.example.worldskills.tsppspmobile.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.tsppspmobile.R;

public class DefectLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
