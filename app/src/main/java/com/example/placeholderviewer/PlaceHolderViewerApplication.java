package com.example.placeholderviewer;

import android.app.Application;
import android.content.Context;

public class PlaceHolderViewerApplication extends Application {

    private static Context context;
    private static PlaceHolderViewerApplication instance;

    public PlaceHolderViewerApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        PlaceHolderViewerApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return PlaceHolderViewerApplication.context;
    }
}
