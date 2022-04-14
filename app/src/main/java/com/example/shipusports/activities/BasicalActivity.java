package com.example.shipusports.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.shipusports.Collectors.ActivitiesCollector;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BasicalActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivitiesCollector.removeActivity(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitiesCollector.addActivities(this);
        Log.d("BasicalActicity", getClass().getSimpleName());
    }
}
