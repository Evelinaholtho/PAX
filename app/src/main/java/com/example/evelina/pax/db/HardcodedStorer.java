package com.example.evelina.pax.db;

import android.util.Log;

import com.example.evelina.pax.domain.Building;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.Room;
import com.example.evelina.pax.util.TimeMaker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// Hardcoded, non-persistent DB for paxes, rooms and buildings.
public class HardcodedStorer implements Storer {

    private static final String LOG_TAG = HardcodedStorer.class.getSimpleName();
    private static final int START_PAX_HOUR = 8;
    private static final int END_PAX_HOUR = 17;

    private static final HardcodedStorer ourInstance = new HardcodedStorer();

    protected static HardcodedStorer getInstance() {
        Log.d(LOG_TAG, "getInstance()");
        return ourInstance;
    }

    // Initializes lists of all initial paxes, rooms and buildings.
    private static List<Pax> paxList;
    private static List<Room> roomList;
    private static List<Building> buildingList;

    private HardcodedStorer(){
        Log.d(LOG_TAG, "HardcodedStorer()");
    }

    public void initLists(){
        Log.d(LOG_TAG, "initLists()");

        // Populate db with data.
        populateBuildingList();
        populateRoomList();
        populatePaxList();
    }

    @Override
    public boolean isPaxedNow(int roomID) {
        Log.d(LOG_TAG, "isPaxedNow()");

        boolean isPaxedNow = false;

        for(Pax p : paxList){
            if(p.getRoomID() == roomID
                    && p.getStartDate().before(TimeMaker.getCalendar())
                    && p.getEndDate().after((TimeMaker.getCalendar()))){
                isPaxedNow = true;
            }
        }
        return isPaxedNow;
    }

    // Populate list of pax
    private void populatePaxList() {
        Log.d(LOG_TAG, "populatePaxList()");

        paxList = new ArrayList<>();

        Calendar c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 8);
        //paxList.add(Pax.getInstance(1, 1, c));
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 9);
        //paxList.add(Pax.getInstance(1, 1, c));
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 14);
        //paxList.add(Pax.getInstance(1, 2, c));
        Pax.getInstance(1, 2, c);
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
        Log.d(LOG_TAG, "populateBuildingList()");

        buildingList = new ArrayList<>();
        buildingList.add(new Building(1, "Patricia"));
        buildingList.add(new Building(2, "Kuggen"));
    }

    @Override
    public List<Pax> getAllPax() {
        Log.d(LOG_TAG, "getAllPax()");
        return paxList;
    }

    @Override
    public List<Pax> getPaxOfDay(Calendar date, int roomID) throws NullPointerException {

        Log.d(LOG_TAG, "getPaxOfDay()");

        List<Pax> dayList = new ArrayList<>();
        for(Pax p : paxList) {
            if (p.getStartDate().get(Calendar.HOUR_OF_DAY) == date.get(Calendar.HOUR_OF_DAY)
                    && p.getRoomID() == roomID){
                dayList.add(p);
                Log.d(LOG_TAG, p.getStartDate() + " added!");
            }
        }
        return dayList;
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

    @Override
    public List<Room> getBuildingRooms(String buildingName) throws NullPointerException {
        Log.d(LOG_TAG, "getBuildingRooms()");
        int i = 1;
        for(Building b : buildingList){
            if(b.getBuildingName().equalsIgnoreCase(buildingName))
                i = b.getBuildingID();
        }

        return getBuildingRooms(i);
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
        Log.d(LOG_TAG, "mergeAdjacent()");

        //return mergePrevious(mergeNext(pax));
        //return mergeNext(pax);
        return pax;
    }

    private Pax mergeNext(Pax pax){
        Log.d(LOG_TAG, "mergeNext()");

        Pax paxToReturn = pax;

        for(Pax p : paxList){
            if(p.getStartDate().get(Calendar.HOUR_OF_DAY) == pax.getEndDate().get(Calendar.HOUR_OF_DAY)
                    && (p.getEndDate().get(Calendar.HOUR_OF_DAY) <= END_PAX_HOUR)
                    && (p.getUserID() == pax.getUserID())
                    && (p.getRoomID() == pax.getRoomID())){
                Log.d(LOG_TAG, "Pass check: \n" + p.toString());
                p.setStartDate(pax.getStartDate());
                Log.d(LOG_TAG, "Changed pax: \n" + p.toString());
                paxToReturn = mergeNext(p);
            }
        }
        return paxToReturn;
    }

    private Pax mergePrevious(Pax pax){
        Log.d(LOG_TAG, "mergePrevious()");

        Pax paxToReturn = pax;

        for(Pax p : paxList){
            if(p.getEndDate().get(Calendar.HOUR_OF_DAY) == pax.getStartDate().get(Calendar.HOUR_OF_DAY)
                    && (p.getStartDate().get(Calendar.HOUR_OF_DAY) > START_PAX_HOUR)
                    && (p.getUserID() == pax.getUserID())
                    && (p.getRoomID() == pax.getRoomID())){
                Log.d(LOG_TAG, "Pass check: \n" + p.toString());
                p.setEndDate(pax.getEndDate());
                Log.d(LOG_TAG, "Changed pax: \n" + p.toString());
                paxToReturn = mergePrevious(p);
            }
        }
        return paxToReturn;
    }

    @Override
    public int getMaxPaxID() {
        Log.d(LOG_TAG, "getMaxPaxID()");

        int maxID = 0;

        if(!paxList.isEmpty())
            for (Pax p : paxList)
                if (p.getPaxID() > maxID)
                    maxID = p.getPaxID();
        return maxID + 1;
    }

    @Override
    public int getMaxRoomID() {
        Log.d(LOG_TAG, "getMaxRoomID()");

        int maxID = 0;

        if(!roomList.isEmpty())
            for(Room r : roomList)
                if(r.getRoomID() > maxID)
                    maxID = r.getRoomID();
        return maxID + 1;
    }
}