package com.example.evelina.pax.domain;

// Class for building. Keeps all data related to a building.
public class Building {

    private static final String LOG_TAG = Building.class.getSimpleName();

    private int buildingID;
    private String buildingName;

    public Building (int buildingID, String buildingName){

        this.buildingID = buildingID;
        this.buildingName = buildingName;
    }
}
