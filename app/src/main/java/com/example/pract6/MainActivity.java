package com.example.pract6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Cars");
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, R.string.drawer_open,
                R.string.drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_vaz2114) {
                Vaz2114Fragment vaz2114Fragment = new Vaz2114Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, vaz2114Fragment)
                        .commit();
                return true;
            }
            else if (item.getItemId() == R.id.nav_bmw_m5_f90) {
                BmwFragment bmwFragment = new BmwFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, bmwFragment)
                        .commit();
            }
            else if (item.getItemId() == R.id.nav_mb_c63) {
                MercedesFragment mercedesFragment = new MercedesFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mercedesFragment)
                        .commit();
            }
            else if (item.getItemId() == R.id.nav_audi_rs6) {
                AudiFragment audiFragment = new AudiFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, audiFragment)
                        .commit();
            }
            else if (item.getItemId() == R.id.nav_skoda_octavia) {
                SkodaFragment skodaFragment = new SkodaFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, skodaFragment)
                        .commit();
            }
            else if (item.getItemId() == R.id.nav_next_activity) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}