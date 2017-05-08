package com.example.evelina.pax.db;

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
    private static final int START_PAX_HOUR = 8;
    private static final int END_PAX_HOUR = 17;

    private static final HardcodedStorer ourInstance = new HardcodedStorer();

    public static HardcodedStorer getInstance() {
        return ourInstance;
    }

    // Initializes lists of all initial paxes, rooms and buildings.
    private static List<Pax> paxList;
    private static List<Room> roomList;
    private static List<Building> buildingList;

    public HardcodedStorer(){
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
        paxList.add(Pax.getInstance(1, 1, c));
        c.add(Calendar.HOUR,1);
        paxList.add(Pax.getInstance(1, 1, c));
        c.add(Calendar.HOUR,4);
        paxList.add(Pax.getInstance(1, 2, c));
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

    // Checks db for adjacent paxes, and merges these if there are.
    public void adjacencyCheck(){

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


    @Override
    public Pax mergeAdjacent(Pax pax) {

        return mergePrevious(mergeNext(pax));
    }

    private Pax mergeNext(Pax pax){

        while(pax.getStartDate().get(Calendar.HOUR) < END_PAX_HOUR){

            for(Pax p : paxList){
                if(p.getStartDate().equals(pax.getEndDate())){
                    if(p.getUserID() == pax.getUserID()){
                        if(p.getRoomID() == pax.getRoomID()){
                            p.setStartDate(pax.getStartDate());
                            return mergeNext(p);
                        }
                    }
                }
            }
        }
        return pax;
    }

    private Pax mergePrevious(Pax pax){

        while(pax.getStartDate().get(Calendar.HOUR) > START_PAX_HOUR){

            for(Pax p : paxList){
                if(pax.getStartDate().equals(p.getEndDate())){
                    if(p.getUserID() == pax.getUserID()){
                        if(p.getRoomID() == pax.getRoomID()){
                            p.setStartDate(pax.getStartDate());
                            return mergePrevious(p);
                        }
                    }
                }
            }
        }
        return pax;
    }

    @Override
    public int getMaxPaxID() {

        int maxID = 0;

        for(Pax p : paxList)
            if(p.getPaxID() > maxID)
                maxID = p.getPaxID();
        return maxID + 1;
    }

    @Override
    public int getMaxRoomID() {

        int maxID = 0;

        for(Room r : roomList)
            if(r.getRoomID() > maxID)
                maxID = r.getRoomID();
        return maxID + 1;
    }
}