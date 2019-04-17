package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.database.contracts.GeoContract;
import com.example.placeholderviewer.entities.Geo;

public class DbGeoDTO implements DbEntityDTO<Geo> {

    @Override
    public Geo parseOut(Cursor cursor) {
        Geo geo = null;

        geo.setId(cursor.getLong(cursor.getColumnIndex(GeoContract.COL_ID)));
        geo.setLat(cursor.getFloat(cursor.getColumnIndex(GeoContract.COL_LAT)));
        geo.setLon(cursor.getFloat(cursor.getColumnIndex(GeoContract.COL_LON)));
        return geo;
    }

    @Override
    public ContentValues parseIn(Geo item) {
        return null;
    }
}
