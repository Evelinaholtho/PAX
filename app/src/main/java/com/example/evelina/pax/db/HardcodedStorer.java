package com.example.evelina.pax.db;

import android.content.Context;
import android.util.Log;

import com.example.evelina.pax.domain.Building;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.Room;
import com.example.evelina.pax.domain.StoreException;
import com.example.evelina.pax.domain.Storer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Hardcoded, non-persistent DB for paxes, rooms and buildings.
public class HardcodedStorer implements Storer {

    private static final String LOG_TAG = HardcodedStorer.class.getSimpleName();

    // Initializes lists of all initial paxes, rooms and buildings.
    private static List<Pax> paxList;
    private static List<Room> roomList;
    private static List<Building> buildingList;

    public HardcodedStorer(Context context){
        Log.d(LOG_TAG, "HardcodedStorer()");

        // Populate db with data.
        populateBuildingList();
        populateRoomList();
        populatePaxList();
    }

    // Populate list of pax
    private void populatePaxList() {
        Log.d(LOG_TAG, "populatePaxList()");

        paxList = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 8);
        c.set(Calendar.MINUTE, 0);
        paxList.add(new Pax(1, 1, c.getTime()));
        c.add(Calendar.HOUR,1);
        paxList.add(new Pax(1, 1, c.getTime()));
        c.add(Calendar.HOUR,4);
        paxList.add(new Pax(2, 2, c.getTime()));
    }

    // Populate list of rooms
    private void populateRoomList() {
        Log.d(LOG_TAG, "populateRoomList()");

        roomList = new ArrayList<>();
        roomList.add(new Room(1, "Tetris"));
        roomList.add(new Room(1, "Zelda"));
        roomList.add(new Room(1, "Donkey Kong"));
        roomList.add(new Room(1, "USB"));
        roomList.add(new Room(1, "Vax"));
        roomList.add(new Room(1, "PDP"));
        roomList.add(new Room(1, "Cray"));
        roomList.add(new Room(1, "Dbase"));
        roomList.add(new Room(1, "ERNA"));
        roomList.add(new Room(1, "Kermit"));
        roomList.add(new Room(2, "Blixtlåset"));
        roomList.add(new Room(2, "Kullagret"));
        roomList.add(new Room(2, "Skiftnyckeln"));
        roomList.add(new Room(2, "Trepunktsbältet"));
    }

    // Populate list of buildings
    private void populateBuildingList() {
        Log.d(LOG_TAG, "populateRoomList()");

        buildingList = new ArrayList<>();
        buildingList.add(new Building(1, "Patricia"));
        buildingList.add(new Building(2, "Kuggen"));
    }

    @Override
    public List<Pax> getAllPax() {
        Log.d(LOG_TAG, "getAllPax()");
        return paxList;
    }

    // Get list of all rooms in building of specified building ID.
    @Override
    public List<Room> getBuildingRooms(int buildingID) {
        Log.d(LOG_TAG, "getBuildingRooms()");
        List<Room> buildingRoomList = new ArrayList<>();
        for(Room r : roomList)
            if(r.getBuildingID() == buildingID)
                buildingRoomList.add(r);
        return buildingRoomList;
    }

    // Get list of all rooms.
    @Override
    public List<Room> getAllRooms() {
        Log.d(LOG_TAG, "getAllRooms()");
        return roomList;
    }

    // Get room object of specified name.
    @Override
    public Room getRoom(String roomName) {
        Log.d(LOG_TAG, "getRoom()");
        for(Room r : roomList)
            if(r.getRoomName().equalsIgnoreCase(roomName))
                return r;
        return null;
    }

    @Override
    public Room getRoom(int roomID) throws NullPointerException {
        Log.d(LOG_TAG, "getRoom()");
        for(Room r : roomList)
            if(r.getRoomID() == roomID)
                return r;
        return null;
    }

    // Store pax in paxlist.
    @Override
    public void storePax(Pax p) {
        Log.d(LOG_TAG, "storePax()");
        paxList.add(p);
    }

    @Override
    public void deletePax(Pax p) {
        Log.d(LOG_TAG, "deletePax()");
        paxList.remove(p);
    }

    @Override
    public void open() throws StoreException {
        Log.d(LOG_TAG, "open()");

    }

    @Override
    public void close() throws StoreException {
        Log.d(LOG_TAG, "close()");

    }
}
