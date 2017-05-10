package com.example.evelina.pax;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;

public class AvailableRooms extends AppCompatActivity {
    private BottomNavigationView mBottomNav;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rooms);

        //Get access to db.
        Storer storer = StorerFactory.getInstance();

        //Get data from the Map-activity on which building this activity should show.
        Bundle buildingData = getIntent().getExtras();
        String buildingName = buildingData.getString("building");

        //Fill listview with rooms in specified building.
        ListAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, storer.getBuildingRooms(buildingName));
        listView = (ListView) findViewById(R.id.ListAvailableRooms);
        listView.setAdapter(listAdapter);

        //((TextView) listAdapter.getItem(0)).setBackgroundColor(Color.GREEN);
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