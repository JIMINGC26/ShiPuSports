package com.example.shipusports.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shipusports.R;
import com.example.shipusports.activities.BasicalActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

public class PostActivity extends BasicalActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        TextView titleView = (TextView) findViewById(R.id.title_sid);
        TextView contentView = (TextView) findViewById(R.id.content_sid);
        titleView.setText(title);
        contentView.setText(content);
    }
}
