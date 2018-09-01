package com.example.worldskills.tsppspmobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.tsppspmobile.R;

public class MenuActivity extends AppCompatActivity {

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
             id=bundle.getInt("codigo");
        }

    }
//para ir a la proxima activity
    public void next(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn_time_log:
                intent=new Intent(this,TimeLogActivity.class);
                break;
            case R.id.btn_defect_log:
                intent=new Intent(this,DefectLogActivity.class);
                break;
            case R.id.btn_sumary:
                intent=new Intent(this,ProjectPlanSummaryActivity.class);
                break;

        }
        intent.putExtra("id",id);
        startActivity(intent);
        finish();
    }
}
