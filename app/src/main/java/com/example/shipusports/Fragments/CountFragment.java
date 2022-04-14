package com.example.shipusports.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shipusports.Collectors.ActivitiesCollector;
import com.example.shipusports.R;
import com.example.shipusports.activities.LoginActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountFragment extends Fragment {

    private TextView countName;
    private Button exitButton;
    private Button loginButton;
    NavigationView navigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View countView = inflater.inflate(R.layout.count_layout, container, false);
        exitButton = (Button) countView.findViewById(R.id.nav_exit);
        loginButton = (Button) countView.findViewById(R.id.nav_login);
        countName = (TextView) countView.findViewById(R.id.count_name);
        navigationView = (NavigationView) countView .findViewById(R.id.nav_design);

        countName.setText("请登录您的账号");
        exitButton.setOnClickListener((v)->{
            ActivitiesCollector.finishAllActivities();
        });

        loginButton.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_edit:
                        Toast.makeText(getContext(), "!!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_history:
                        Toast.makeText(getContext(), "!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_article:
                        Toast.makeText(getContext(), "@#!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getContext(), "ASD", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        return countView;
    }
}
