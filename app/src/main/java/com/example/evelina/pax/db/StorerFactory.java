package com.example.evelina.pax.db;

import android.util.Log;

// Fetches singleton instance of db to be used.
public class StorerFactory {

    private static final String LOG_TAG = StorerFactory.class.getSimpleName();

    public static Storer getInstance(){
        Log.d(LOG_TAG, "getInstance()");
        return HardcodedStorer.getInstance();
    }
}