package com.example.evelina.pax;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by Evelina on 5/4/2017.
 */

public class ActivitySwitcher {


    private static final String LOG_TAG = ActivitySwitcher.class.getSimpleName();

    public static void switchActivity(Activity activity, MenuItem item) {

        Log.d(LOG_TAG, "Switching over: " + item);
    // init corresponding fragment
        switch (item.getItemId()) {
        case R.id.navigation_home:
            Intent intentHome = new Intent(activity, Home.class);
            activity.startActivity(intentHome);
            break;
        case R.id.navigation_search:
            break;

        case R.id.navigation_map:
            Intent intentMap = new Intent(activity, Map.class);
            activity.startActivity(intentMap);
            break;
        case R.id.navigation_group:
            break;

        case R.id.navigation_setting:
            break;
    }
    }


}
