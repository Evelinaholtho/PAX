package com.example.evelina.pax;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    private BottomNavigationView mBottomNav;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setTitle("  Sök rum");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_search_black_24dp);


        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(1).setChecked(true);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }

        });
        editText = (EditText) findViewById(R.id.editText);
        editText.setError("Under utveckling");

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
