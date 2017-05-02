package com.example.evelina.pax.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Helper class for storing to SQL database.
public class StoreHelper extends SQLiteOpenHelper {

    public static final String TABLE_PAX = "pax";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PAX_NAME = "name";

    private static final String DATABASE_NAME = "pax.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_PAX + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_PAX_NAME
            + " text not null);";

    private static final String LOG_TAG = StoreHelper.class.getSimpleName();

    public StoreHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "PaxStoreHelper()");
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
