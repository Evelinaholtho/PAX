package com.example.evelina.pax.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.Room;

import java.util.Calendar;
import java.util.List;

// Stores pax in SQLite database
public class DBStorer implements Storer {

    private static final String LOG_TAG = DBStorer.class.getSimpleName();

    // Database fields
    private SQLiteDatabase database;
    private StoreHelper dbHelper;
    private String[] allColumns = { StoreHelper.COLUMN_PAX_ID,
            StoreHelper.COLUMN_PAX_NAME};

    public DBStorer(Context context){
        Log.d(LOG_TAG, "DBStorer()");
        dbHelper = new StoreHelper(context);
    }

    @Override
    public List<Room> getBuildingRooms(String buildingName) throws NullPointerException {
        return null;
    }

    @Override
    public void initLists() {

    }

    @Override
    public boolean isPaxedNow(int roomID) {
        return false;
    }

    @Override
    public List<Pax> getAllPax() throws NullPointerException {
        Log.d(LOG_TAG, "getAllPax()");
        return null;
    }

    @Override
    public List<Pax> getPaxOfDay(Calendar date, int roomID) throws NullPointerException {
        return null;
    }

    @Override
    public Pax getPaxNow(int roomID) {
        return null;
    }

    @Override
    public void storePax(Pax p) {
        Log.d(LOG_TAG, "storePax()");

    }

    @Override
    public void deletePax(Pax p) {
        Log.d(LOG_TAG, "deletePax()");

    }

    @Override
    public Room getRoom(int roomID) throws NullPointerException {
        Log.d(LOG_TAG, "getRoom()");
        return null;
    }

    @Override
    public List<Room> getBuildingRooms(int buildingID) throws NullPointerException {
        Log.d(LOG_TAG, "getBuildingRooms()");
        return null;
    }

    @Override
    public List<Room> getAllRooms() throws NullPointerException {
        Log.d(LOG_TAG, "getAllRooms()");
        return null;
    }

    @Override
    public Room getRoom(String roomName) throws NullPointerException {
        return null;
    }

    @Override
    public void open() throws StoreException {
        Log.d(LOG_TAG, "open()");
        try{
            database = dbHelper.getWritableDatabase();
        }catch(SQLException e){
            throw new StoreException(e);
        }
    }

    @Override
    public void close() throws StoreException {
        Log.d(LOG_TAG, "close()");
        dbHelper.close();
    }

    @Override
    public Pax mergeAdjacent(Pax p) {
        return null;
    }

    @Override
    public int getMaxPaxID() {
        return 0;
    }

    @Override
    public int getMaxRoomID() {
        return 0;
    }
}
