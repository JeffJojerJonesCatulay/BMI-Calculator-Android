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
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sleep_music extends AppCompatActivity {
    private Button sleep_1, sleep_2, sleep_3, sleep_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_music);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo_white_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        bottomNavigation();

        sleep_1 = findViewById(R.id.sleep_1BTM);
        sleep_2 = findViewById(R.id.sleep_2BTM);
        sleep_3 = findViewById(R.id.sleep_3BTM);
        sleep_4 = findViewById(R.id.sleep_4BTM);

        showMessage("Did you know?", "That proper sleep will increase your health!.");
        selectedPlay();
    }

    private void selectedPlay(){
        String musicPath_1 = "android.resource://" + getPackageName() + "/" + R.raw.sleep_1;
        final MediaPlayer sleep_1_music = MediaPlayer.create(this, Uri.parse(musicPath_1));

        String musicPath_2 = "android.resource://" + getPackageName() + "/" + R.raw.sleep_2;
        final MediaPlayer sleep_2_music = MediaPlayer.create(this, Uri.parse(musicPath_2));

        String musicPath_3 = "android.resource://" + getPackageName() + "/" + R.raw.sleep_3;
        final MediaPlayer sleep_3_music = MediaPlayer.create(this, Uri.parse(musicPath_3));

        String musicPath_4 = "android.resource://" + getPackageName() + "/" + R.raw.sleep_4;
        final MediaPlayer sleep_4_music = MediaPlayer.create(this, Uri.parse(musicPath_4));

        sleep_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleep_1_music.isPlaying()){
                    sleep_1.setText("Play Music #1");
                    sleep_1_music.pause();
                }else {
                    sleep_1.setText("Pause Music #1");
                    sleep_1_music.start();
                }
            }
        });

        sleep_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleep_2_music.isPlaying()){
                    sleep_2.setText("Play Music #2");
                    sleep_2_music.pause();
                }else {
                    sleep_2.setText("Pause Music #2");
                    sleep_2_music.start();
                }
            }
        });

        sleep_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleep_3_music.isPlaying()){
                    sleep_3.setText("Play Music #3");
                    sleep_3_music.pause();
                }else {
                    sleep_3.setText("Pause Music #3");
                    sleep_3_music.start();
                }
            }
        });

        sleep_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleep_4_music.isPlaying()){
                    sleep_4.setText("Play Music #4");
                    sleep_4_music.pause();
                }else {
                    sleep_4.setText("Pause Music #4");
                    sleep_4_music.start();
                }
            }
        });
    }

    private void bottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_sleep);
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
                        startActivity(new Intent(getApplicationContext(),
                                health_tips.class));
                        finish();
                        return true;
                    case R.id.nav_sleep:
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

    //Image Source (No Copyright Images)
    /*
    https://www.pcclean.io/relaxing-wallpapers-for-desktop-backgrounds-photos-images-pictures/
https://wallpaperaccess.com/calming-relaxing
https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.ytimg.com%2Fvi%2FPLAJTuLNI7A%2Fmaxresdefault.jpg&imgrefurl=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DPLAJTuLNI7A&tbnid=NSSM8N1tpHzBxM&vet=12ahUKEwif-JLzjrftAhVMTZQKHZiXAG0QMygEegUIARDfAQ..i&docid=rvG_hf4ntGZaNM&w=1280&h=720&q=relaxing%20background%20images&ved=2ahUKEwif-JLzjrftAhVMTZQKHZiXAG0QMygEegUIARDfAQ
https://www.google.com/imgres?imgurl=https%3A%2F%2Fwallpaperaccess.com%2Ffull%2F276139.jpg&imgrefurl=https%3A%2F%2Fwallpaperaccess.com%2Fcalming-relaxing&tbnid=Vi5Hh8WefQ-oOM&vet=12ahUKEwif-JLzjrftAhVMTZQKHZiXAG0QMygBegUIARDZAQ..i&docid=9-UepQxN-NAc3M&w=1920&h=1200&q=relaxing%20background%20images&ved=2ahUKEwif-JLzjrftAhVMTZQKHZiXAG0QMygBegUIARDZAQ
     */

    //Audio Source (No Copyright Audios)
    /*
    https://www.youtube.com/watch?v=eAc4dTLvbRk&ab_channel=MoodVideos%E2%80%94CreativeBackgroundMusic
https://www.youtube.com/watch?v=j66TStQGvsI&ab_channel=PLUGNPLAYMUSIC
https://www.youtube.com/watch?v=UL6lS4ltZoQ&ab_channel=MusicforVideoLibrary
https://www.youtube.com/watch?v=SvWfZGhjwGs&ab_channel=NourishedbyMusic
     */
}