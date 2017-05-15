package com.example.evelina.pax;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Map extends AppCompatActivity {

    private BottomNavigationView mBottomNav;
    ImageButton buttonPatricia;
    ImageButton buttonKuggen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().setTitle("  Rum i närheten");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_map_black_24dp);
        buttonPatricia=(ImageButton) findViewById(R.id.imageButtonPatricia);
        buttonKuggen=(ImageButton) findViewById(R.id.imageButtonKuggen);

        buttonPatricia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Map.this, AvailableRooms.class);
                intent.putExtra("building", "Patricia");
                startActivity(intent);
            }
        });

        buttonKuggen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Map.this, AvailableRooms.class);
                intent.putExtra("building", "Kuggen");
                startActivity(intent);
            }
        });

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(2).setChecked(true);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }


        });



    }

    private void selectFragment(MenuItem item) {
        ActivitySwitcher.switchActivity(this, item);

    }




}


