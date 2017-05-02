package com.example.evelina.pax.domain;

import java.util.List;

// Interface telling extending classes which methods to implement.
public interface Storer {

    List<Pax> getAllPax();
    void storePax (Pax p);
    void deletePax (Pax p);
    void getBuildingRooms(String buildingName);
    void getAllRooms();
    void getRoom(String roomName);
    void open() throws StoreException;
    void close() throws StoreException;
}