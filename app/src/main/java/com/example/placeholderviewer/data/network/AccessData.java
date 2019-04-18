package com.example.placeholderviewer.data.network;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AccessData extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {

        String urlView = strings[0];

        HttpURLConnection httpURLConnection = null;

        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(urlView);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int charItem;

            while ((charItem = inputStreamReader.read()) != -1){
                stringBuffer.append((char)charItem);
            }

            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
