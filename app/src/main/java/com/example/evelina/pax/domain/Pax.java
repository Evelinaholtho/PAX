package com.example.evelina.pax.domain;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Class for pax. Keeps all data related to a booking of a room.
public class Pax {

    private static final String LOG_TAG = Pax.class.getSimpleName();

    public static Pax getInstance(int userID, int roomID, Calendar startDate){
        // Sends new Pax to db to check if there are existent adjacent paxes. If so, merge these into one pax, and return.
        // Returns new pax if none adjacent.
        return StorerFactory.getInstance().mergeAdjacent(new Pax(userID, roomID, startDate));
    }

    private int paxID;
    private int userID;
    private int roomID;
    private Calendar startDate;
    private Calendar endDate;

    private Pax (int userID, int roomID, Calendar startDate){

        this.paxID = generatePaxID();
        this.userID = userID;
        this.roomID = roomID;
        this.startDate = startDate;

        endDate = (Calendar)startDate.clone();
        endDate.set(Calendar.HOUR, startDate.get(Calendar.HOUR) + 1);
    }

    private int generatePaxID(){

        return StorerFactory.getInstance().getMaxPaxID();
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

    public Calendar getStartDate(){
        return startDate;
    }

    public Calendar getEndDate(){
        return endDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getPaxID() {
        return paxID;
    }

    public void setPaxID(int paxID) {
        this.paxID = paxID;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public int getUserID(){
        return userID;
    }

    public int getRoomID(){
        return roomID;
    }
}
