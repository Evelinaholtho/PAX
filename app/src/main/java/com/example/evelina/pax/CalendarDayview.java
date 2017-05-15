package com.example.evelina.pax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evelina.pax.util.TimeMaker;


public class CalendarDayview extends AppCompatActivity {
ImageButton favoriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_dayview);
        getSupportActionBar().setTitle("Kalender");



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
    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        toastMsg("Funktionen är under utveckling");

    }


    }

