package com.example.evelina.pax.domain;

import android.util.Log;
import java.util.Calendar;

// Class for pax. Keeps all data related to a booking of a room.
public class Pax {

    private static final String LOG_TAG = Pax.class.getSimpleName();

    private int paxID;
    private int userID;
    private int roomID;
    private Calendar date;
    private int timeIndex;

    public Pax (int userID, int roomID, Calendar date, int timeIndex){

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
        return "/nPax ID: " + paxID
                + "/nUser ID: " + userID
                + "/nRoomID: " + roomID
                + "/nDate: " + date
                + "/nTime: " + timeIndex + ".00-" + timeIndex + 1 + ".00";
    }
}
