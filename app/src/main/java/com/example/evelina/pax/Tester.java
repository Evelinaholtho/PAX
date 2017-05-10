package com.example.evelina.pax;

import com.example.evelina.pax.db.StorerFactory;

public class Tester {

    public static void populate(){

        StorerFactory.getInstance().initLists();
    }
}