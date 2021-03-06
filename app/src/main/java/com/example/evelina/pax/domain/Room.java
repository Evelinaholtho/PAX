package com.example.evelina.pax.domain;

import android.util.Log;

import com.example.evelina.pax.db.StorerFactory;

// Class for room. Keeps all data related to a room.
public class Room {

    private static final String LOG_TAG = Room.class.getSimpleName();

    private int roomID;
    private int buildingID;
    private String roomName;

    public Room(int buildingID, String roomName){
        Log.d(LOG_TAG, "Room()");

        this.roomID = generateRoomID();
        this.buildingID = buildingID;
        this.roomName = roomName;
    }

    private int generateRoomID(){
        Log.d(LOG_TAG, "generateRoomID()");
        return StorerFactory.getInstance().getMaxRoomID();
    }

    public int getBuildingID(){
        Log.d(LOG_TAG, "getBuildingID()");
        return buildingID;
    }
    public String getRoomName(){
        Log.d(LOG_TAG, "getRoomName()");
        return roomName;
    }
    public int getRoomID(){
        Log.d(LOG_TAG, "getRoomID()");
        return roomID;
    }

    public String toString(){
        return roomName;
    }
}