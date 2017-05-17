package com.example.evelina.pax;

import android.app.ActionBar;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;

import java.util.List;

public class Home extends AppCompatActivity {
    private static final String LOG_TAG = Home.class.getSimpleName();
    private BottomNavigationView mBottomNav;
    private ListView listView;
    private Storer storer;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate()");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("  Hem");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_home_black_24dp);



        // Get access to db.
        storer = StorerFactory.getInstance();

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

        listView = (ListView) findViewById(R.id.listView_myBookings);

        updateData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    public void updateData() {

        // Initialize lists with pax
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storer.getPaxOfUser(LoginActivity.ACTIVE_USER_ID));
        listView.setAdapter(listAdapter);
            }

    // Switches to activity that corresponds to the item on navigation bar.
    private void switchActivity(MenuItem item) {
        Log.d(LOG_TAG, "switchActivity()");
        ActivitySwitcher.switchActivity(this, item);
    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        toastMsg("Funktionen är under utveckling");

    }

}