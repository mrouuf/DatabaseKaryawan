package com.example.databasekaryawan;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

    private Context context = SplashScreenActivity.this;
    private static long SPLASH_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        context = this;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                showHome();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }

    private void showHome(){
        Bundle bundle = ActivityOptions.makeCustomAnimation(getBaseContext(),
                android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
        Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
        startActivity(intent, bundle);

        finish();
    }
}
