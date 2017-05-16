package com.example.evelina.pax.db;

import com.example.evelina.pax.LoginActivity;
import com.example.evelina.pax.domain.Pax;
import com.example.evelina.pax.domain.Room;

import java.util.Calendar;
import java.util.List;

// Interface telling extending classes which methods to implement.
public interface Storer {

    List<Pax> getAllPax() throws NullPointerException;
    List<Pax> getPaxOfDay(Calendar date, int roomID) throws NullPointerException;
    Pax getPaxNow(int roomID);
    List<Pax> getPaxOfUser(int userID);
    void storePax (Pax p);
    void deletePax (Pax p);
    void deletePax(int userID, int roomID, Calendar date);
    List<Room> getBuildingRooms(int buildingID) throws NullPointerException;
    List<Room> getBuildingRooms(String buildingName) throws NullPointerException;
    List<Room> getAllRooms() throws NullPointerException;
    Room getRoom(String roomName) throws NullPointerException;
    Room getRoom(int roomID) throws NullPointerException;
    void open() throws StoreException;
    void close() throws StoreException;

    Pax mergeAdjacent(Pax p);

    int getMaxPaxID();

    int getMaxRoomID();

    void initLists();

    boolean isPaxedNow(int roomID);


}