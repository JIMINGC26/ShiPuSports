package com.example.shipusports.activities;


import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.shipusports.Fragments.CountFragment;
import com.example.shipusports.Fragments.GroupFragment;
import com.example.shipusports.Fragments.MsgFragment;
import com.example.shipusports.R;
import com.example.shipusports.activities.BasicalActivity;

public class MainActivity extends BasicalActivity implements View.OnClickListener {

    private MsgFragment msgFragment;
    private GroupFragment groupFragment;
    private CountFragment countFragment;

    private View msglayout;
    private View grouplayout;
    private View countLayout;

    private ImageView msgImg;
    private ImageView groupImg;
    private ImageView countImg;
    private TextView msgText;
    private TextView groupText;
    private TextView countText;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        manager = getSupportFragmentManager();
        setTabSelect(0);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

    }

    private void initView(){
        msglayout = findViewById(R.id.msg_layout);
        grouplayout = findViewById(R.id.group_layout);
        countLayout = findViewById(R.id.count_layout);
        msgImg = (ImageView) findViewById(R.id.msg_img);
        groupImg = (ImageView) findViewById(R.id.group_img);
        countImg = (ImageView) findViewById(R.id.count_img);
        msgText = (TextView) findViewById(R.id.msg_text);
        groupText = (TextView) findViewById(R.id.group_text);
        countText = (TextView) findViewById(R.id.count_text);
        msglayout.setOnClickListener(this);
        grouplayout.setOnClickListener(this);
        countLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msg_layout:
                setTabSelect(0);break;
            case R.id.group_layout:
                setTabSelect(1);break;
            case R.id.count_layout:
                setTabSelect(2);break;
            default:break;
        }
    }

    private void setTabSelect(int index){
        clearSelection();

        FragmentTransaction transaction = manager.beginTransaction();

        hideFragment(transaction);

        switch (index){
            case 0:
                msgImg.setImageResource(R.drawable.msg_select);
                msgText.setTextColor(Color.RED);
                if(msgFragment == null){
                    msgFragment = new MsgFragment();
                    transaction.add(R.id.content, msgFragment);
                }else {
                    transaction.show(msgFragment);
                }
                break;
            case 1:
                groupImg.setImageResource(R.drawable.group_select);
                groupText.setTextColor(Color.RED);
                if(groupFragment == null){
                    groupFragment = new GroupFragment();
                    transaction.add(R.id.content, groupFragment);
                }else {
                    transaction.show(groupFragment);
                }
                break;
            default:
                countImg.setImageResource(R.drawable.user_select);
                countText.setTextColor(Color.RED);
                if(countFragment == null){
                    countFragment = new CountFragment();
                    transaction.add(R.id.content, countFragment);
                }else {
                    transaction.show(countFragment);
                }
                break;

        }
        transaction.commit();
    }


    private void clearSelection(){
        msgImg.setImageResource(R.drawable.msg_unselect);
        msgText.setTextColor(Color.parseColor("#99dedede"));
        groupImg.setImageResource(R.drawable.group_unselect);
        groupText.setTextColor(Color.parseColor("#99dedede"));
        countImg.setImageResource(R.drawable.user_unselect);
        countText.setTextColor(Color.parseColor("#99dedede"));
    }

    private void hideFragment(FragmentTransaction transaction){
        if(msgFragment != null){
            transaction.hide(msgFragment);
        }
        if(groupFragment != null){
            transaction.hide(groupFragment);
        }
        if(countFragment != null){
            transaction.hide(countFragment);
        }
    }

}