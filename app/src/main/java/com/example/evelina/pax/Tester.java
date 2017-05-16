package com.example.evelina.pax;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.util.TimeMaker;

import java.util.Calendar;

public class Tester {

    public static void populate(){

        StorerFactory.getInstance().initLists();


        // userID, roomID, date

        //Bara UserOne idag i Tetris
        Calendar c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 8);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 9);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 10);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 11);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 12);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 13);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 14);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 15);
        Pax.getInstance(1, 1, c);

        c = TimeMaker.getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 16);
        Pax.getInstance(1, 1, c);

        //Bara UserTwo idag i blixtlåset

        for (int i = 8; i < 17; i++){
            c = TimeMaker.getCalendar();
            c.set(Calendar.HOUR_OF_DAY, i);
            Pax.getInstance(2, StorerFactory.getInstance().getRoom("Blixtlåset").getRoomID(), c);
        }
    }
}