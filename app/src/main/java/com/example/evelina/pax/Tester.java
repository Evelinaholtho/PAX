package com.example.evelina.pax;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.util.TimeMaker;

public class Tester {

    public static void populate(){

        StorerFactory.getInstance().initLists();
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 1, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 3, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 10, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 11, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 12, TimeMaker.getCalendar()));
    }
}