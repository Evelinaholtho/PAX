package com.example.evelina.pax.db;

import android.content.Context;
import android.util.Log;

import com.example.evelina.pax.domain.Building;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.Room;
import com.example.evelina.pax.domain.StoreException;
import com.example.evelina.pax.domain.Storer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// Hardcoded, non-persistent DB for paxes, rooms and buildings.
public class HardcodedStorer implements Storer {

    private static final String LOG_TAG = HardcodedStorer.class.getSimpleName();

    // Initializes lists of all initial paxes, rooms and buildings.
    private static List<Pax> paxList;
    private static List<Room> roomList;
    private static List<Building> buildingList;

    static {
        // Populate list of pax
        paxList = new ArrayList<>();
        paxList.add(new Pax(1, 1, Calendar.getInstance(), 8));
        paxList.add(new Pax(1, 1, Calendar.getInstance(), 10));
        paxList.add(new Pax(2, 2, Calendar.getInstance(), 8));

        // Populate list of rooms
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

        // Populate list of buildings
        buildingList = new ArrayList<>();
        buildingList.add(new Building());
    }

    public HardcodedStorer(Context context){
        Log.d(LOG_TAG, "HardcodedStorer()");
    }

    @Override
    public List<Pax> getAllPax() {
        Log.d(LOG_TAG, "getAllPax()");
        return paxList;
    }

    @Override
    public void getBuildingRooms(String buildingName) {
        Log.d(LOG_TAG, "getBuildingRooms()");
    }

    @Override
    public void getAllRooms() {
        Log.d(LOG_TAG, "getAllRooms()");

    }

    @Override
    public void getRoom(String roomName) {
        Log.d(LOG_TAG, "getRoom()");

    }

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
