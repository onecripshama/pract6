package com.example.pract6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Home");
            BottomNavigationView bottomNavigationView =
                    findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.home) {
                    actionBar.setTitle("Home");
                    HouseFragment houseFragment = new HouseFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container2, houseFragment)
                            .commit();
                    return true;
                }
                else if (item.getItemId() == R.id.notification) {
                    actionBar.setTitle("Notifications");
                    BellFragment bellFragment = new BellFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container2, bellFragment)
                            .commit();
                    return true;
                }
                else if (item.getItemId() == R.id.settings) {
                    actionBar.setTitle("Settings");
                    GearFragment gearFragment = new GearFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container2, gearFragment)
                            .commit();
                    return true;
                }
                return false;
            });
        }

    }
}