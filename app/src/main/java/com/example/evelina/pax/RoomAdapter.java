package com.example.evelina.pax;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.evelina.pax.db.StorerFactory;
import com.example.evelina.pax.domain.Room;

import java.util.List;

public class RoomAdapter extends ArrayAdapter {

    // XML-file about how textView in list should look like.
    public static final int TEXT_VIEW_RES = R.layout.textview_pax;

    private static final String LOG_TAG = RoomAdapter.class.getSimpleName();

    List<Room> list;

    Context context;

    public RoomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        Log.d(LOG_TAG, "Pax()");
        this.context = context;
        list = objects;
    }

    @Nullable
    @Override
    public Room getItem(int position) {
        Log.d(LOG_TAG, "getItem()");
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(LOG_TAG, "getView()");

        int color0 = Color.RED;
        int color1 = Color.GREEN;
        int defaultColor = Color.GRAY;

        View view = null;


        if (convertView == null) {
            Log.d(LOG_TAG, "View is null!");
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(TEXT_VIEW_RES, null);
        } else {
            view = convertView;
        }

        /*
        if (convertView == null) {
            Log.d(LOG_TAG, "View is null!");
            view = new TextView(context);
        } else {
            view = convertView;
        }

        */

        Room r = getItem(position);

        TextView tv = (TextView)view;
        tv.setHeight(50);
        tv.setText(r.toString());

        boolean roomPaxed = StorerFactory.getInstance().isPaxedNow(r.getRoomID());

        switch (booleanToInt(roomPaxed)) {
            case 1:
                Log.d(LOG_TAG, "Room: " + r.getRoomName() + " is paxed!");
                view.setBackgroundColor(color0);
                break;
            case 0:
                Log.d(LOG_TAG, "Room: " + r.getRoomName() + " is available!");
                view.setBackgroundColor(color1);
                break;
            default:
                Log.d(LOG_TAG, "Room: " + r.getRoomName() + " is default.");
                view.setBackgroundColor(defaultColor);
        }
        return view;
    }

    private int booleanToInt(boolean b){
        Log.d(LOG_TAG, "booleanToInt()");
        if(b)
            return 1;
        else
            return 0;
    }
}