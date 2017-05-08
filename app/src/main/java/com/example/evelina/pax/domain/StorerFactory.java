package com.example.evelina.pax.domain;

import android.util.Log;

import com.example.evelina.pax.db.HardcodedStorer;

// Fetches singleton instance of db to be used.
public class StorerFactory {

    private static final String LOG_TAG = StorerFactory.class.getSimpleName();

    public static Storer getInstance(){
        Log.d(LOG_TAG, "getInstance()");
        return HardcodedStorer.getInstance();
    }
}