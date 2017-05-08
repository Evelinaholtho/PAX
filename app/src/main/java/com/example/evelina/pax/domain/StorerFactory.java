package com.example.evelina.pax.domain;

import com.example.evelina.pax.db.HardcodedStorer;

// Fetches singleton instance of db to be used.
public class StorerFactory {

    public static Storer getInstance(){
        return HardcodedStorer.getInstance();
    }
}