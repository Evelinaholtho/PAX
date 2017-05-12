package com.example.evelina.pax;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.util.TimeMaker;

public class Tester {

    public static void populate(){

        StorerFactory.getInstance().initLists();
        StorerFactory.getInstance().storePax(Pax.getInstance(2, 1, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 3, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(2, 10, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(2, 11, TimeMaker.getCalendar()));
        StorerFactory.getInstance().storePax(Pax.getInstance(1, 12, TimeMaker.getCalendar()));
    }
}