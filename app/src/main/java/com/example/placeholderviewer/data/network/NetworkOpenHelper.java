package com.example.placeholderviewer.data.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkOpenHelper {

    private static NetworkOpenHelper INSTANCE = null;
    private Context context;
    private NetworkInfo networkInfo;

    private NetworkOpenHelper(Context context) {
        this.context = context;
        this.networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return new NetworkOpenHelper(context).getNetworkInfo();
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
