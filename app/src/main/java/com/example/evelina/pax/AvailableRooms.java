package com.example.evelina.pax;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;

public class AvailableRooms extends AppCompatActivity {
    private BottomNavigationView mBottomNav;
    private ListView listView;
    private ListAdapter listAdapter;
    private Storer storer;
    private String buildingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rooms);
        getSupportActionBar().setTitle("Rum");

        //Get access to db.
        storer = StorerFactory.getInstance();

        //Get data from the Map-activity on which building this activity should show.
        Bundle buildingData = getIntent().getExtras();
        buildingName = buildingData.getString("building");

        // Set name of building
        TextView buildingNameText = (TextView)findViewById(R.id.idAtavailableRooms);
        buildingNameText.setText(buildingName);

        //Fill listview with rooms in specified building.
        listView = (ListView) findViewById(R.id.ListAvailableRooms);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AvailableRooms.this, CalendarDayview.class);
                intent.putExtra("room", listAdapter.getItem(position).toString());
                startActivity(intent);
            }
        });

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

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    private void updateData() {
        listAdapter = new RoomAdapter(this, android.R.layout.simple_list_item_1, storer.getBuildingRooms(buildingName));
        listView.setAdapter(listAdapter);
    }

    public void onBackPress(View v){
        this.finish();
    }

    private void selectFragment(MenuItem item) {
        ActivitySwitcher.switchActivity(this, item);
    }
}