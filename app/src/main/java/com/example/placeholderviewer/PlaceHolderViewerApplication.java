package com.example.placeholderviewer;

import android.app.Application;
import android.content.Context;

public class PlaceHolderViewerApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        PlaceHolderViewerApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return PlaceHolderViewerApplication.context;
    }
}
