package com.example.evelina.pax;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evelina.pax.util.TimeMaker;


public class CalendarDayview extends AppCompatActivity {
ImageButton favoriteButton;
    private BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_dayview);
        getSupportActionBar().setTitle("Kalender");

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation_view);
        mBottomNav.getMenu().getItem(2).setChecked(true);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }


        });


        //Get data from the Map-activity on which building this activity should show.
        Bundle roomData = getIntent().getExtras();
        String roomName = roomData.getString("room");

        // Set name of room
        TextView roomNameText = (TextView)findViewById(R.id.room_name);
        roomNameText.setText(roomName);

        // Set date text
        TextView dateText = (TextView)findViewById(R.id.date);
        dateText.setText(TimeMaker.getFormat2().format(TimeMaker.getCalendar().getTime()));




        final Button button = (Button) findViewById(R.id.button08);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });


    }

    private void selectFragment(MenuItem item) {
        ActivitySwitcher.switchActivity(this, item);

    }
    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        toastMsg("Funktionen är under utveckling");
    }

    public void onBackPress(View v){
        this.finish();
    }
    }

