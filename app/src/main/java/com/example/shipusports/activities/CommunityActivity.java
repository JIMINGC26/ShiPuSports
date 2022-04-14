package com.example.shipusports.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shipusports.R;
import com.example.shipusports.activities.BasicalActivity;

import androidx.annotation.Nullable;

public class CommunityActivity extends BasicalActivity {

    TextView comName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_layout);

        comName = (TextView) findViewById(R.id.com_name_id_2);

        ActionBar actionBar = getActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        Intent intent = getIntent();
        String name = intent.getStringExtra("CName");
        comName.setText(name);

    }
}
