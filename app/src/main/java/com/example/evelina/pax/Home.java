package com.example.evelina.pax;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home extends AppCompatActivity {
    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });


    }

    private void selectFragment(MenuItem item) {



        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent intentHome = new Intent(this, Home.class);
                startActivity(intentHome);

                break;
            case R.id.navigation_search:
                break;

            case R.id.navigation_map:
                Intent intentMap = new Intent(this, Map.class);
                startActivity(intentMap);
                break;

            case R.id.navigation_group:
                break;

            case R.id.navigation_setting:
                break;
        }
        mSelectedItem = item.getItemId();
        for (int i = 0; i < mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i < mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

    }
}
