package com.example.evelina.pax;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;

public class AvailableRooms extends AppCompatActivity {

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
    }
}