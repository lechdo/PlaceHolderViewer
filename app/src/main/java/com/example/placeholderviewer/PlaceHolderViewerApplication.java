package com.example.placeholderviewer;

import android.app.Application;
import android.content.Context;

public class PlaceHolderViewerApplication extends Application {

    private static Context context;

    /**
     * permet de récupérer le contexte de l'application même, bonne pratique pour utiliser un contexte
     * en dehors d'une activité (daos), mais ne fonctionne pas forcément pour tout.
     *
     * pour l'utiliser le manifest doit contenir le nom de cette classe dans la balise application :
     * android:name=".PlaceHolderViewerApplication"
     */
    public PlaceHolderViewerApplication() {
        PlaceHolderViewerApplication.context = this;
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
