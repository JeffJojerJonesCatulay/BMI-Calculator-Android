package com.example.exer5catulayjeffjojerjones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class bmi extends AppCompatActivity {
    private EditText height, weight;
    private Button computation;
    private Spinner weight_measurement_val, height_measurement_val;

    ArrayList<String> weight_measurement = new ArrayList<>();
    ArrayList<String> height_measurement = new ArrayList<>();

    double weight_converted;
    double height_converted;
    double bmi_result;

    int tips_selection_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo_white_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        bottomNavigation();

        height = findViewById(R.id.height_Val);
        weight = findViewById(R.id.weight_Val);
        computation = findViewById(R.id.compute_Value);

        weight_measurement_val = findViewById(R.id.weight_measurement_selection);
        height_measurement_val = findViewById(R.id.height_measurement_selection);

        spinnerChoices_weight_measurement();
        spinnerChoices_height_measurement();

        compute_converted();

    }

    private void play_result(int choice){
        String uwPath = "android.resource://" + getPackageName() + "/" + R.raw.uw;
        String nwPath = "android.resource://" + getPackageName() + "/" + R.raw.nw;
        String owPath = "android.resource://" + getPackageName() + "/" + R.raw.ow;
        String oPath = "android.resource://" + getPackageName() + "/" + R.raw.o;
        String soPath = "android.resource://" + getPackageName() + "/" + R.raw.so;

        switch (choice){
            case 0:
                final MediaPlayer uw = MediaPlayer.create(this, Uri.parse(uwPath));
                uw.start();
                break;
            case 1:
                final MediaPlayer nw = MediaPlayer.create(this, Uri.parse(nwPath));
                nw.start();
                break;
            case 2:
                final MediaPlayer ow = MediaPlayer.create(this, Uri.parse(owPath));
                ow.start();
                break;
            case 3:
                final MediaPlayer o = MediaPlayer.create(this, Uri.parse(oPath));
                o.start();
                break;
            case 4:
                final MediaPlayer so = MediaPlayer.create(this, Uri.parse(soPath));
                so.start();
                break;
        }
    }

    private void compute_converted(){
        computation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double weight_notConverted = Double.parseDouble(weight.getText().toString());
                    double height_notConverted = Double.parseDouble(height.getText().toString());

                    if (weight_measurement_val.getSelectedItemId() == 0){
                        weight_converted = weight_notConverted;
                    }
                    else if (weight_measurement_val.getSelectedItemId() == 1){
                        //lbs to kilo
                        weight_converted =  weight_notConverted * 0.45359237;
                    }

                    if (height_measurement_val.getSelectedItemId() == 0){
                        height_converted = height_notConverted;
                    }
                    else if (height_measurement_val.getSelectedItemId() == 1){
                        //inch to m
                        height_converted = height_notConverted * 0.0254;
                    }
                    bmi_computation_evaluation(weight_converted, height_converted);
                }catch (Exception e){
                    showMessage("Error", "Something is Wrong!");
                }
            }
        });
    }


    private void spinnerChoices_weight_measurement(){
        weight_measurement.add(getString(R.string.kg));
        weight_measurement.add(getString(R.string.lbs));

        ArrayAdapter<String> categoryList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weight_measurement );
        categoryList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weight_measurement_val.setAdapter(categoryList);

        weight_measurement_val.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weight.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void spinnerChoices_height_measurement(){
        height_measurement.add(getString(R.string.m));
        height_measurement.add(getString(R.string.inch));

        ArrayAdapter<String> categoryList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, height_measurement );
        categoryList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        height_measurement_val.setAdapter(categoryList);

        height_measurement_val.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                height.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void bmi_computation_evaluation(double weight, double height){
        try {
            bmi_result = weight / (height * height);
            if (bmi_result < 18.5){
                tips_selection_page = 0;
                play_result(0);
                showMessage("Result", getString(R.string.underweight) + " " + String.format( "%.2f", bmi_result));
                showOption("The result indicates Underweight. Do you want to see some health tips?");
            }
            else if ((bmi_result >= 18.5) && (bmi_result <= 24.9)){
                tips_selection_page = 1;
                play_result(1);
                showMessage("Result", getString(R.string.normal) + " " + String.format( "%.2f", bmi_result));
                showOption("The result indicates Normal but do you want to see some health tips?");
            }
            else if ((bmi_result >= 25) && (bmi_result <= 29.9)){
                tips_selection_page = 2;
                play_result(2);
                showMessage("Result", getString(R.string.overweight) + " " + String.format( "%.2f", bmi_result));
                showOption("The result indicates Overweight. Do you want to see some health tips?");
            }
            else if ((bmi_result >= 30) && (bmi_result <= 35)){
                tips_selection_page = 3;
                play_result(3);
                showMessage("Result", getString(R.string.obesity) + " " + String.format( "%.2f", bmi_result));
                showOption("The result indicates Obesity. Do you want to see some health tips?");
            }
            else if (bmi_result >= 35){
                tips_selection_page = 4;
                play_result(4);
                showMessage("Result", getString(R.string.severe) + " " + String.format( "%.2f", bmi_result));
                showOption("The result indicates Sever Obesity. Do you want to see some health tips?");
            }
        }catch (Exception e){
            showMessage("Error", "Something is Wrong!" + " " + String.format( "%.2f", bmi_result));
        }
    }

    private void bottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_bmi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_bmi:
                        return true;
                    case R.id.nav_health_tips:
                        startActivity(new Intent(getApplicationContext(),
                                health_tips.class));
                        finish();
                        return true;
                    case R.id.nav_sleep:
                        startActivity(new Intent(getApplicationContext(),
                                sleep_music.class));
                        finish();
                        return true;
                }
                finish();
                return false;
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void showOption(String msg){
        try {
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    messageDisplay(msg);
                }
            }, 3000);
        }catch (Exception e){
            showMessage("Error", "Something is Wrong!");
        }
    }

    public void messageDisplay(String title){
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(title)
                    .setPositiveButton("Yes, take me there!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (tips_selection_page == 1){
                                Intent underweight_tips = new Intent(bmi.this, bmi_underweight_health_tips.class);
                                startActivity(underweight_tips);
                            }
                            else if (tips_selection_page == 0){
                                Intent normal_weight = new Intent(bmi.this, bmi_normal_health_tips.class);
                                startActivity(normal_weight);
                            }
                            else if (tips_selection_page == 2){
                                Intent overweight_tips = new Intent(bmi.this, bmi_overweight_health_tips.class);
                                startActivity(overweight_tips);
                            }
                            else if (tips_selection_page == 3){
                                Intent obesity_tips = new Intent(bmi.this, bmi_obese_health_tips.class);
                                startActivity(obesity_tips);
                            }
                            else if (tips_selection_page == 4){
                                Intent severe_obesity_tips = new Intent(bmi.this, bmi_severeObesity_health_tips.class);
                                startActivity(severe_obesity_tips);
                            }
                        }
                    })
                    .setNegativeButton("No, stay on this page", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            builder.show();
        }catch (Exception e){
            showMessage("Error", "Something is Wrong!");
        }
    }

    //ICON (BMI)
    /*
    https://www.similarplay.com/artlixon/bmi_calculator_body_mass_index_bmi/apps/com.artlixon.arti.bmi
    */

}