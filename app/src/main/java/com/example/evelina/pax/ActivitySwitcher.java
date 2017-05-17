package com.example.evelina.pax;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

public class ActivitySwitcher {

    private static final String LOG_TAG = ActivitySwitcher.class.getSimpleName();

    public static void switchActivity(Activity activity, MenuItem item) {
        Log.d(LOG_TAG, "Switching to activity: " + item);

        switch (item.getItemId()) {
            
        case R.id.navigation_home:
            Intent intentHome = new Intent(activity, Home.class);
            activity.startActivity(intentHome);
            break;

            case R.id.navigation_search:
                Intent intentSearch = new Intent(activity, Search.class);
                activity.startActivity(intentSearch);
            break;

        case R.id.navigation_map:
            Intent intentMap = new Intent(activity, Map.class);
            activity.startActivity(intentMap);
            
            break;
        case R.id.navigation_group:
            Intent intentGroup = new Intent(activity, Group.class);
            activity.startActivity(intentGroup);
            break;

        case R.id.navigation_setting:
            Intent intentSettings = new Intent(activity, Settings.class);
            activity.startActivity(intentSettings);
            break;
        }
        activity.finish();
    }
}