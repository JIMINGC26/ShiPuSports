package com.example.shipusports.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.shipusports.R;

import java.util.Timer;
import java.util.TimerTask;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

public class StartActivity extends BasicalActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ActionBar bar = getSupportActionBar();
        if (bar != null){
            bar.hide();
        }
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 1000 * 2);

    }
}
