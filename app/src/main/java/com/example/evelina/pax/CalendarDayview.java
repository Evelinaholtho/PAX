package com.example.evelina.pax;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.util.TimeMaker;

import java.util.Calendar;
import java.util.List;

public class CalendarDayview extends AppCompatActivity {

    private static final String LOG_TAG = CalendarDayview.class.getSimpleName();
    private BottomNavigationView mBottomNav;
    private static final String TEXT_PAXAT = "Paxat";
    private static final String TEXT_MITT_PAX = "Mitt pax";

    Calendar date;

    Storer store;
    List<Pax> paxList;

    String roomName;

    ImageButton favoriteButton;
    Button button08;
    Button button09;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_dayview);

        //Get data from the Map-activity on which building this activity should show.
        Bundle roomData = getIntent().getExtras();
        roomName = roomData.getString("room");
        date = TimeMaker.getCalendar();

        // Get all pax for this day
        store = StorerFactory.getInstance();
        paxList = store.getPaxOfDay(date, store.getRoom(roomName).getRoomID());

        // Set name of room
        TextView roomNameText = (TextView)findViewById(R.id.room_name);
        roomNameText.setText(roomName);

        // Set date text
        TextView dateText = (TextView)findViewById(R.id.date);
        dateText.setText(TimeMaker.getFormat2().format(TimeMaker.getCalendar().getTime()));

        favoriteButton =(ImageButton) findViewById(R.id.imageButton);
        favoriteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "favorite button pressed!");
            }
        });

        

        button08 = (Button) findViewById(R.id.button08);
        colorPaxButton(button08, 8);
        button08.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "button08 pressed!");
                if(button08.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button08.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(8);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(8);
                }
            }
        });

        button09 = (Button) findViewById(R.id.button09);
        colorPaxButton(button09, 9);
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "button09 pressed!");
                if(button09.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button09.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(9);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(9);
                }
            }
        });
        button10 = (Button) findViewById(R.id.button10);
        colorPaxButton(button10, 10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button10.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button10.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(10);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(10);
                }
            }
        });
        button11 = (Button) findViewById(R.id.button11);
        colorPaxButton(button11, 11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button11.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button11.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(11);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(11);
                }
            }
        });
        button12 = (Button) findViewById(R.id.button12);
        colorPaxButton(button12, 12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button12.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button12.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(12);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(12);
                }
            }
        });
        button13 = (Button) findViewById(R.id.button13);
        colorPaxButton(button13, 13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button13.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button13.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(13);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(13);
                }
            }
        });
        button14 = (Button) findViewById(R.id.button14);
        colorPaxButton(button14, 14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button14.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button14.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(14);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(14);
                }
            }
        });
        button15 = (Button) findViewById(R.id.button15);
        colorPaxButton(button15, 15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button15.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button15.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(15);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(15);
                }
            }
        });
        button16 = (Button) findViewById(R.id.button16);
        colorPaxButton(button16, 16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button16.getText().toString().equalsIgnoreCase(TEXT_PAXAT)) {
                    // Vad ska hända om rummet är paxat?
                    doIfPaxed();

                }
                else if(button16.getText().toString().equalsIgnoreCase(TEXT_MITT_PAX)){
                    // Vad ska hända om JAG paxat rummet den här tiden?
                    cancelPax(16);
                }
                else {
                    // vad ska hända om det är ledigt?
                    makeAPax(16);
                }
            }
        });

// För att kunna naviger med hjälp av menyrad
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

    private void cancelPax(int hour) {
        Log.d(LOG_TAG, "cancelPax() " + hour);
        Calendar paxTime = ((Calendar) date.clone());
        paxTime.set(Calendar.HOUR_OF_DAY, hour);
        store.deletePax(LoginActivity.ACTIVE_USER_ID, store.getRoom(roomName).getRoomID(), paxTime);
        recreate();
    }

    private void colorPaxButton(Button b, int hour) {
        Log.d(LOG_TAG, "colorPaxButton()");
        for(Pax p : paxList){
            if(p.getStartDate().get(Calendar.HOUR_OF_DAY) == hour){
                if(p.getUserName().equals(LoginActivity.ACTIVE_USER)) {
                    b.setText(TEXT_MITT_PAX);
                    b.setBackgroundColor(Color.BLUE);
                }
                else {
                    b.setText(TEXT_PAXAT);
                    b.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    //When clicking button in calendar
    private void makeAPax(int hour) {
        Log.d(LOG_TAG, "makeAPax() " + hour);
        Calendar paxTime = ((Calendar) date.clone());
        paxTime.set(Calendar.HOUR_OF_DAY, hour);
        Pax.getInstance(LoginActivity.ACTIVE_USER_ID, store.getRoom(roomName).getRoomID(), paxTime);
        recreate();
    }
// tillbakaknapp
    public void onBackPress(View v){
        this.finish();
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


    // Vad händer om jag klickar på en tid som redan är paxad av nån annan?
    private void doIfPaxed() {
        String msg = "Rummet är redan paxat vid denna tidpunk";
        toastMsg(msg);

    }
}

