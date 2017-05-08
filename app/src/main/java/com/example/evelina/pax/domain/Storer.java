package com.example.evelina.pax.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Interface telling extending classes which methods to implement.
public interface Storer {

    List<Pax> getAllPax() throws NullPointerException;
    void storePax (Pax p);
    void deletePax (Pax p);
    List<Room> getBuildingRooms(int buildingID) throws NullPointerException;
    List<Room> getAllRooms() throws NullPointerException;
    Room getRoom(String roomName) throws NullPointerException;
    Room getRoom(int roomID) throws NullPointerException;
    void open() throws StoreException;
    void close() throws StoreException;

    Pax mergeAdjacent(Pax p);

    int getMaxPaxID();

    int getMaxRoomID();
}