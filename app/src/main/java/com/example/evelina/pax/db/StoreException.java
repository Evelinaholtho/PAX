package com.example.evelina.pax.db;

import android.util.Log;

// Custom exception class.
public class StoreException extends Exception {

    private static final String LOG_TAG = StoreException.class.getSimpleName();

    public StoreException(Exception e){
        super(e);
        Log.d(LOG_TAG, "StoreException()");
    }
}