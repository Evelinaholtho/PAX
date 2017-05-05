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
    private Date startDate;
    private Date endDate;

    public Pax (int userID, int roomID, Date startDate){

        this.paxID = generatePaxID();
        this.userID = userID;
        this.roomID = roomID;
        this.startDate = startDate;

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.HOUR, 1);
        endDate = c.getTime();
    }

    // Get key from db?
    private int generatePaxID(){

        return 1;
    }

    public String toString(){
        Log.d(LOG_TAG, "toString()");
        SimpleDateFormat startDateFormat = new SimpleDateFormat("EEEE d MMMM HH:mm");
        SimpleDateFormat endDateFormat = new SimpleDateFormat(" - HH:mm");

        return new StringBuilder()
                .append("Room ID: ")
                .append(Integer.toString(roomID))
                .append(". ")
                .append(startDateFormat.format(startDate))
                .append(endDateFormat.format(endDate)).toString();
    }
}
