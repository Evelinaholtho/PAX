package com.example.evelina.pax;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evelina.pax.db.StoreException;
import com.example.evelina.pax.db.Storer;
import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.util.TimeMaker;

import java.util.Calendar;
import java.util.List;


public class CalendarDayview extends AppCompatActivity {

    private static final String LOG_TAG = CalendarDayview.class.getSimpleName();

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

        favoriteButton =(ImageButton) findViewById(R.id.favotiteButton);
        favoriteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button08 = (Button) findViewById(R.id.button08);
        colorPaxButton(button08, 8);
        button08.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(8);
            }
        });
        button09 = (Button) findViewById(R.id.button09);
        colorPaxButton(button09, 9);
        button09.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(9);
            }
        });
        button10 = (Button) findViewById(R.id.button10);
        colorPaxButton(button10, 10);
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(10);
            }
        });
        button11 = (Button) findViewById(R.id.button11);
        colorPaxButton(button11, 11);
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(11);
            }
        });
        button12 = (Button) findViewById(R.id.button12);
        colorPaxButton(button12, 12);
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(12);
            }
        });
        button13 = (Button) findViewById(R.id.button13);
        colorPaxButton(button13, 13);
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(13);
            }
        });
        button14 = (Button) findViewById(R.id.button14);
        colorPaxButton(button14, 14);
        button14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(14);
            }
        });
        button15 = (Button) findViewById(R.id.button15);
        colorPaxButton(button15, 15);
        button15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(15);
            }
        });
        button16 = (Button) findViewById(R.id.button16);
        colorPaxButton(button16, 16);
        button16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeAPax(16);
            }
        });
    }

    private void colorPaxButton(Button b, int hour) {
        Log.d(LOG_TAG, "colorPaxButton()" + paxList.toString());
        for(Pax p : paxList){
            Log.d(LOG_TAG, "Hour of day: " + p.getStartDate().get(Calendar.HOUR_OF_DAY));

            if(p.getStartDate().get(Calendar.HOUR_OF_DAY) == hour){
                Log.d(LOG_TAG, "Hour of day: " + p.getStartDate().get(Calendar.HOUR_OF_DAY) + " is equal to " + hour);
                if(p.getUserName().equals(LoginActivity.ACTIVE_USER)) {
                    Log.d(LOG_TAG, "Username: " + p.getUserName() + " is equal to " + LoginActivity.ACTIVE_USER);
                    b.setBackgroundColor(Color.BLUE);
                }
                else {
                    Log.d(LOG_TAG, "Username: " + p.getUserName() + " is NOT equal to " + LoginActivity.ACTIVE_USER);
                    b.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    //When clicking button in calendar
    private void makeAPax(int hour) {
        Calendar paxTime = ((Calendar) date.clone());
        paxTime.set(Calendar.HOUR_OF_DAY, hour);
        store.storePax(Pax.getInstance(LoginActivity.ACTIVE_USER_ID, store.getRoom(roomName).getRoomID(), paxTime));
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayToastMsg(View v) {
        toastMsg("Funktionen är under utveckling");
    }
}

