package com.example.evelina.pax.domain;

import android.util.Log;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.util.TimeMaker;

import java.util.Calendar;

// Class for pax. Keeps all data related to a booking of a room.
public class Pax {

    private static final String LOG_TAG = Pax.class.getSimpleName();

    public static Pax getInstance(int userID, int roomID, Calendar startDate){
        Log.d(LOG_TAG, "getInstance()");
        // Sends new Pax to db to check if there are existent adjacent paxes. If so, merge these into one pax, and return.
        // Returns new pax if none adjacent.

        //Pax newPax = StorerFactory.getInstance().mergeAdjacent(new Pax(userID, roomID, startDate));
        Pax newPax = new Pax(userID, roomID, startDate);
        StorerFactory.getInstance().storePax(newPax);
        //StorerFactory.getInstance().update();
        return newPax;
        //return new Pax(userID, roomID, startDate);
    }

    private int paxID;
    private int userID;
    private int roomID;
    private Calendar startDate;
    private Calendar endDate;

    private Pax (int userID, int roomID, Calendar startDate){
        Log.d(LOG_TAG, "Pax()");

        this.paxID = generatePaxID();
        this.userID = userID;
        this.roomID = roomID;
        this.startDate = startDate;
        endDate = (Calendar)startDate.clone();
        endDate.add(Calendar.HOUR_OF_DAY, 1);
    }

    private int generatePaxID(){
        Log.d(LOG_TAG, "generatePaxID()");
        return StorerFactory.getInstance().getMaxPaxID();
    }

    public String toString(){
        Log.d(LOG_TAG, "toString()");
        return "Room ID: " + roomID + ". " + TimeMaker.getFormat().format(startDate.getTime())
                + "-" + endDate.get(Calendar.HOUR_OF_DAY) + ":00";
    }

    public Calendar getStartDate(){
        Log.d(LOG_TAG, "getStartDate()");
        return startDate;
    }

    public Calendar getEndDate(){
        Log.d(LOG_TAG, "getEndDate()");
        return endDate;
    }

    public void setStartDate(Calendar startDate) {
        Log.d(LOG_TAG, "setStartDate()");
        this.startDate = startDate;
    }

    public int getPaxID() {
        Log.d(LOG_TAG, "getPaxID()");
        return paxID;
    }

    public void setPaxID(int paxID) {
        Log.d(LOG_TAG, "setPaxID()");
        this.paxID = paxID;
    }

    public void setEndDate(Calendar endDate) {
        Log.d(LOG_TAG, "setEndDate()");
        this.endDate = endDate;
    }

    public int getUserID(){
        Log.d(LOG_TAG, "getUserID()");
        return userID;
    }

    public int getRoomID(){
        Log.d(LOG_TAG, "getRoomID()");
        return roomID;
    }
}
