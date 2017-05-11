package com.example.evelina.pax.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeMaker {

    // "Europe/Stockholm"
    private static final String TIME_ZONE = "GMT";

    private static final String LOG_TAG = TimeMaker.class.getSimpleName();

    public static Calendar getCalendar(){
        Log.d(LOG_TAG, "getCalendar()");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone(TIME_ZONE));
        c.set(Calendar.MINUTE, 0);
        return c;
    }

    public static SimpleDateFormat getFormat(){
        Log.d(LOG_TAG, "getFormat()");
        return new SimpleDateFormat("EEEE d MMMM HH:mm");
    }
    public static SimpleDateFormat getFormat2(){
        Log.d(LOG_TAG, "getFormat()");
        return new SimpleDateFormat("EEEE d MMMM");
    }
}
