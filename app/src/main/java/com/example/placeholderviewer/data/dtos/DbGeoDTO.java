package com.example.placeholderviewer.data.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.data.database.contracts.GeoContract;
import com.example.placeholderviewer.entities.Geo;

public class DbGeoDTO implements DbEntityDTO<Geo> {

    @Override
    public Geo parseOut(Cursor cursor) {
        Geo geo = new Geo();

        geo.setId(cursor.getLong(cursor.getColumnIndex(GeoContract.COL_ID)));
        geo.setLat(cursor.getFloat(cursor.getColumnIndex(GeoContract.COL_LAT)));
        geo.setLon(cursor.getFloat(cursor.getColumnIndex(GeoContract.COL_LON)));
        return geo;
    }

    @Override
    public ContentValues parseIn(Geo item) {
        ContentValues values = new ContentValues();

        values.put(GeoContract.COL_LAT, item.getLat());
        values.put(GeoContract.COL_LON, item.getLon());

        return values;
    }
}
