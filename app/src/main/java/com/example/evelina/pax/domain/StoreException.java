package com.example.evelina.pax.domain;

// Custom exception class.
public class StoreException extends Exception {

    public StoreException(Exception e){
        super(e);
    }
}