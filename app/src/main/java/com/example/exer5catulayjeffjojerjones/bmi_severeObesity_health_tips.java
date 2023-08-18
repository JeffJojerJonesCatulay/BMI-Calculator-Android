package com.example.exer5catulayjeffjojerjones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class bmi_severeObesity_health_tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_severe_obesity_health_tips);
    }

    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(bmi_severeObesity_health_tips.this, health_tips.class);
        startActivity(intent);
        finish();
    }
}