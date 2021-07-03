package com.example.covid2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.covid2021.fragment.FragmentCase;
import com.example.covid2021.fragment.Fragment2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentCase());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.kasus_menu:
                loadFragment(new FragmentCase());
                break;

            case R.id.faskes_menu:
                loadFragment(new Fragment2());
                break;
        }
        return true;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container,selectedFragment)
                    .commit();
            return true;
        }
        else
        {
            return false;
        }

    }
}