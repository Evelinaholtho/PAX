package com.example.evelina.pax.domain;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Class for pax. Keeps all data related to a booking of a room.
public class Pax {

    private static final String LOG_TAG = Pax.class.getSimpleName();

    private int paxID;
    private int userID;
    private int roomID;
    private Date date;
    private int timeIndex;

    public Pax (int userID, int roomID, Date date, int timeIndex){

        this.paxID = generatePaxID();
        this.userID = userID;
        this.roomID = roomID;
        this.date = date;
        this.timeIndex = timeIndex;
    }

    // Get key from db?
    private int generatePaxID(){

        return 1;
    }

    public String toString(){
        Log.d(LOG_TAG, "toString()");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d");
        return "Pax ID: " + paxID + ", " + dateFormat.format(date) + " " + timeIndex + ".00";
    }
}
