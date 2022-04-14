package com.example.shipusports.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.shipusports.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends BasicalActivity{

    private EditText userName;
    private EditText passwd;
    private Button loginBtn;
    private Button enrollBtn;
    private ImageButton qqBtn;
    private ImageButton wxBtn;
    private ImageButton phoneBtn;
    private CircleImageView txImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initAll();
        hideBar();

    }

    private void initAll(){
        userName = (EditText) findViewById(R.id.login_user);
        passwd = (EditText) findViewById(R.id.login_psw);
        loginBtn = (Button) findViewById(R.id.login_log);
        enrollBtn = (Button) findViewById(R.id.login_enroll);
        qqBtn = (ImageButton) findViewById(R.id.login_qq);
        wxBtn = (ImageButton) findViewById(R.id.login_wx);
        phoneBtn = (ImageButton) findViewById(R.id.login_phone);
        txImg = (CircleImageView) findViewById(R.id.login_tx);
    }

    private void hideBar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }

}
