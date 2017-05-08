package com.example.evelina.pax;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;

public class Home extends AppCompatActivity {

    private static final String LOG_TAG = Home.class.getSimpleName();

    private BottomNavigationView mBottomNav;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get access to db.
        Storer storer = StorerFactory.getInstance();
        // Fill db with data.
        storer.initLists();

        // Initialize navigation bar
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(0).setChecked(true); // Index decides which menu item is chosen.
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switchActivity(item);
                return true;
            }
        });

        // Initialize lists with pax
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storer.getAllPax());
        listView = (ListView) findViewById(R.id.listView_myBookings);
        listView.setAdapter(listAdapter);
    }

    // Switches to activity that corresponds to the item on navigation bar.
    private void switchActivity(MenuItem item) {
        Log.d(LOG_TAG, "switchActivity()");
        ActivitySwitcher.switchActivity(this, item);
    }
}