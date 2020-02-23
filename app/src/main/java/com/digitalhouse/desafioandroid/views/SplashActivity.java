package com.digitalhouse.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.digitalhouse.desafioandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer = new Timer();
    public static final Integer secondsTimer = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerJumper();
            }
        },secondsTimer);
    }

    private void timerJumper (){
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
