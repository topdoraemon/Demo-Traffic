package com.aoyama.atc.traffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //sound Intro effect
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro_start_horse);
        mediaPlayer.start();

        // จับเวลา
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },9000);
        /// หน่วย milisecond

    } // Main Method

}// Main Class
