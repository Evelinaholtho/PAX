package com.example.evelina.pax;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Settings extends AppCompatActivity {
    private BottomNavigationView mBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(4).setChecked(true);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }


        });
    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        toastMsg("Funktionen är under utveckling");

    }
    private void selectFragment(MenuItem item) {
        ActivitySwitcher.switchActivity(this, item);

    }


}
