package com.example.evelina.pax.domain;

import com.example.evelina.pax.db.HardcodedStorer;

public class StorerFactory {

    public static Storer getInstance(){
        return HardcodedStorer.getInstance();
    }
}