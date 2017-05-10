package com.example.evelina.pax;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Search extends AppCompatActivity {
    private BottomNavigationView mBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(1).setChecked(true);
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
