package com.example.evelina.pax.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Class for creating and setting up SQL DB.
public class StoreHelper extends SQLiteOpenHelper {

    public static final String TABLE_PAX = "pax";
    public static final String COLUMN_PAX_ID = "pax_id";
    public static final String COLUMN_PAX_NAME = "pax_name";

    public static final String TABLE_ROOM = "room";
    public static final String COLUMN_ROOM_ID = "room_id";
    public static final String COLUMN_ROOM_NAME = "room_name";

    public static final String TABLE_BUILDING = "building";
    public static final String COLUMN_BUILDING_ID = "building_id";
    public static final String COLUMN_BUILDING_NAME = "building_name";

    private static final String DATABASE_NAME = "pax.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table "
            + TABLE_PAX + "( " + COLUMN_PAX_ID
            + " integer primary key autoincrement, " + COLUMN_PAX_NAME
            + " text not null);"
            + "create table "
            + TABLE_ROOM + "( " + COLUMN_ROOM_ID
            + " integer primary key autoincrement, " + COLUMN_ROOM_NAME
            + " text not null);" +
            "create table "
            + TABLE_BUILDING + "( " + COLUMN_BUILDING_ID
            + " integer primary key autoincrement, " + COLUMN_BUILDING_NAME
            + " text not null);";

    private static final String LOG_TAG = StoreHelper.class.getSimpleName();

    public StoreHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "StoreHelper()");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "onCreate()");
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}