package com.example.evelina.pax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;


public class CalendarDayview extends AppCompatActivity {
ImageButton favoriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_dayview);

        favoriteButton =(ImageButton) findViewById(R.id.favotiteButton);
        favoriteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


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

