package com.example.exer5catulayjeffjojerjones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class health_tips extends AppCompatActivity {
    private VideoView introVid;
    private ListView health_tips_list;
    ArrayList<String> health_tips = new ArrayList<>();
    ArrayList<String> sub_health_tips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        health_tips_list = findViewById(R.id.health_tips_list);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo_white_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        bottomNavigation();
        playVideoIntro();
        health_tips_list_show();
    }

    public void onBackPressed(){
        finish();
    }

    private void health_tips_list_show(){
        health_tips.add(getString(R.string.tip1));
        health_tips.add(getString(R.string.tip2));
        health_tips.add(getString(R.string.tip3));
        health_tips.add(getString(R.string.tip4));
        health_tips.add(getString(R.string.tip5));

        sub_health_tips.add(getString(R.string.bmi_UW));
        sub_health_tips.add(getString(R.string.bmi_NW));
        sub_health_tips.add(getString(R.string.bmi_OW));
        sub_health_tips.add(getString(R.string.bmi_O));
        sub_health_tips.add(getString(R.string.bmi_OW));

        try {
            List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();
            for (int x = 0; x < 5; x++){
                HashMap<String, String> hm = new HashMap<String,String>();
                hm.put("Tips", health_tips.get(x));
                hm.put("SubTip",sub_health_tips.get(x));
                aList.add(hm);
            }
            String[] from = {
                    "Tips","SubTip"
            };
            int[] to = {
                    R.id.tips,R.id.sub_tip
            };

            SimpleAdapter healths = new SimpleAdapter(getBaseContext(),aList, R.layout.listview,from,to);
            health_tips_list.setAdapter(healths);

        }catch (Exception exception){
            showMessage("Error", "Something is Wrong!");
        }


        health_tips_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent underweight_tips = new Intent(health_tips.this, bmi_underweight_health_tips.class);
                        startActivity(underweight_tips);
                        finish();
                        break;
                    case 1:
                        Intent normal_weight = new Intent(health_tips.this, bmi_normal_health_tips.class);
                        startActivity(normal_weight);
                        finish();
                        break;
                    case 2:
                        Intent overweight_tips = new Intent(health_tips.this, bmi_overweight_health_tips.class);
                        startActivity(overweight_tips);
                        finish();
                        break;
                    case  3:
                        Intent obesity_tips = new Intent(health_tips.this, bmi_obese_health_tips.class);
                        startActivity(obesity_tips);
                        finish();
                        break;
                    case 4:
                        Intent severe_obesity_tips = new Intent(health_tips.this, bmi_severeObesity_health_tips.class);
                        startActivity(severe_obesity_tips);
                        finish();
                        break;
                }
            }
        });
    }

    private void playVideoIntro(){
        //Video From: https://www.pinterest.ph/pin/726275877377189569/
        introVid = findViewById(R.id.vid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.health_tips;
        Uri uri = Uri.parse(videoPath);
        introVid.setVideoURI(uri);
        introVid.start();
        introVid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                introVid.start();
            }
        });
    }

    private void bottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_health_tips);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_bmi:
                        startActivity(new Intent(getApplicationContext(),
                                bmi.class));
                        finish();
                        return true;
                    case R.id.nav_health_tips:
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
}