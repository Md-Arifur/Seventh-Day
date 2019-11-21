package com.bitm.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());
        init();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        /*bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_home:

                        *//*FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();*//*

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frameLayout,new HomeFragment());
                        ft.commit();
                        return true;

                    case R.id.nav_notification:
                        FragmentTransaction ftNot = getSupportFragmentManager().beginTransaction();
                        ftNot.replace(R.id.frameLayout,new NotificationFragment());
                        ftNot.commit();
                        return true;

                    case R.id.nav_more:
                        FragmentTransaction ftMor = getSupportFragmentManager().beginTransaction();
                        ftMor.replace(R.id.frameLayout, new MoreFragment());
                        ftMor.commit();
                        return true;
                }
                return false;
            }
        });*/
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavMenu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                replaceFragment(new HomeFragment());
                return true;

            case R.id.nav_notification:
                replaceFragment(new NotificationFragment());
                return true;

            case R.id.nav_more:
                replaceFragment(new MoreFragment());
                return true;
        }
        return false;
    }
    private void replaceFragment (Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
    }
}
