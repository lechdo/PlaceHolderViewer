package com.example.placeholderviewer.webservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Permet d'ouvrir le service web de manière générique, peut etre utilisé avec
 *
 * mettre dans le manifest :
 * <uses-permission android:name="android.permission.INTERNET"/>
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *
 */
public class WebServiceOpenHelper {

    private static WebServiceOpenHelper INSTANCE = null;
    private Context context;
    private NetworkInfo networkInfo;


    //TODO rendre cette classe générique avec le itemApplication.
    private WebServiceOpenHelper(Context context) {
        this.context = context;
        this.networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return new WebServiceOpenHelper(context).getNetworkInfo();
    }

    private NetworkInfo getNetworkInfo() {

        if (networkInfo != null && networkInfo.isConnected()) {
            return networkInfo;
        } else {
            Toast.makeText(context,"Not connected to network",Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
