package com.example.evelina.pax.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.StoreException;
import com.example.evelina.pax.domain.Storer;

import java.util.List;

// Stores pax in SQLite database
public class DBStorer implements Storer {

    private static final String LOG_TAG = DBStorer.class.getSimpleName();

    // Database fields
    private SQLiteDatabase database;
    private StoreHelper dbHelper;
    private String[] allColumns = { StoreHelper.COLUMN_ID,
            StoreHelper.COLUMN_PAX_NAME};

    public DBStorer(Context context){
        Log.d(LOG_TAG, "DBStorer()");
        dbHelper = new StoreHelper(context);
    }

    @Override
    public List<Pax> getAllPax() {
        Log.d(LOG_TAG, "getAllPax()");
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
/*
    public Pax createPax(Pax pax) {
        Log.d(LOG_TAG, "createPax()");
        ContentValues values =  new ContentValues();
        values.put(PaxStoreHelper.COLUMN_PAX_NAME, pax.name());
    }
    */
}
