package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.database.contracts.AdressContract;
import com.example.placeholderviewer.database.daos.GeoDAO;
import com.example.placeholderviewer.entities.Adress;
import com.example.placeholderviewer.entities.Geo;

import java.util.ArrayList;
import java.util.List;

public class DbAdressDTO implements DbEntityDTO<Adress> {


    @Override
    public Adress parseOut(Cursor cursor) {
        Adress adress = new Adress();

        adress.setId(cursor.getLong(cursor.getColumnIndex(AdressContract.COL_ID)));
        adress.setSuite(cursor.getString(cursor.getColumnIndex(AdressContract.COL_SUITE)));
        adress.setCity(cursor.getString(cursor.getColumnIndex(AdressContract.COL_CITY)));
        adress.setZipCode(cursor.getString(cursor.getColumnIndex(AdressContract.COL_ZIP_CODE)));
        adress.setStreet(cursor.getString(cursor.getColumnIndex(AdressContract.COL_STREET)));

        return adress;
    }

    @Override
    public ContentValues parseIn(Adress item) {
        return null;
    }

}
