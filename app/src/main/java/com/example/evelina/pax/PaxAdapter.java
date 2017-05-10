package com.example.evelina.pax;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Room;

import java.util.List;

public class PaxAdapter extends ArrayAdapter {

    List<Room> roomList;

    Context context;


    public PaxAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        roomList = objects;
    }

    @NonNull
    @Override
    public Room getItem(int position) {
        return roomList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int color0 = Color.RED;
        int color1 = Color.GREEN;
        int defaultColor = Color.GRAY;

        if(convertView == null) {
            convertView = new TextView(context);
            convertView.setBackgroundColor(defaultColor);
        } else if (StorerFactory.getInstance().isPaxedNow(roomList.get(position).getRoomID()))
            convertView.setBackgroundColor(color0);
        else
            convertView.setBackgroundColor(color1);

        /*
        switch (StorerFactory.getInstance().isPaxedNow(roomList.get(position).getRoomID())) {
            case false:
                convertView.setBackgroundColor(color0);
                break;
            case true:
                convertView.setBackgroundColor(color1);
                break;
            default:
                convertView.setBackgroundColor(defaultColor);
        }
        */
        return convertView;
    }
}
