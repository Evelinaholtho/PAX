package com.example.evelina.pax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;



public class CalendarDayview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_dayview);


        final Button button = (Button) findViewById(R.id.button08);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }



    }

