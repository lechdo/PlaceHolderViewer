package com.example.placeholderviewer.data.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.data.database.contracts.AdressContract;
import com.example.placeholderviewer.data.database.contracts.GeoContract;

import com.example.placeholderviewer.entities.Adress;
import com.example.placeholderviewer.entities.Geo;

public class DbAdressDTO implements DbEntityDTO<Adress> {


    @Override
    public Adress parseOut(Cursor cursor) {
        Adress adress = new Adress();
        Geo geo = new Geo();

        adress.setId(cursor.getLong(cursor.getColumnIndex(AdressContract.COL_ID)));
        adress.setSuite(cursor.getString(cursor.getColumnIndex(AdressContract.COL_SUITE)));
        adress.setCity(cursor.getString(cursor.getColumnIndex(AdressContract.COL_CITY)));
        adress.setZipCode(cursor.getString(cursor.getColumnIndex(AdressContract.COL_ZIP_CODE)));
        adress.setStreet(cursor.getString(cursor.getColumnIndex(AdressContract.COL_STREET)));

        geo.setId(cursor.getLong(cursor.getColumnIndex(GeoContract.COL_ID)));
        adress.setGeo(geo);

        return adress;
    }

    @Override
    public ContentValues parseIn(Adress item) {
        ContentValues values = new ContentValues();

        values.put(AdressContract.COL_STREET, item.getStreet());
        values.put(AdressContract.COL_SUITE, item.getSuite());
        values.put(AdressContract.COL_CITY, item.getCity());
        values.put(AdressContract.COL_ZIP_CODE, item.getZipCode());
        values.put(AdressContract.COL_GEO_ID, item.getGeo().getId());

        return values;
    }

}
