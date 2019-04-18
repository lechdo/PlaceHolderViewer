package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;


import com.example.placeholderviewer.database.contracts.CompagnyContract;
import com.example.placeholderviewer.entities.Compagny;

public class DbCompagnyDTO implements DbEntityDTO<Compagny> {


    @Override
    public Compagny parseOut(Cursor cursor) {
        Compagny compagny = new Compagny();

        compagny.setId(cursor.getLong(cursor.getColumnIndex(CompagnyContract.COL_ID)));
        compagny.setName(cursor.getString(cursor.getColumnIndex(CompagnyContract.COL_NAME)));
        compagny.setCatchPhrase(cursor.getString(cursor.getColumnIndex(CompagnyContract.COL_CATCH_PHRASE)));
        compagny.setBs(cursor.getString(cursor.getColumnIndex(CompagnyContract.COL_BS)));

        return compagny;
    }

    @Override
    public ContentValues parseIn(Compagny item) {
        ContentValues values = new ContentValues();

        values.put(CompagnyContract.COL_NAME, item.getName());
        values.put(CompagnyContract.COL_CATCH_PHRASE, item.getCatchPhrase());
        values.put(CompagnyContract.COL_BS, item.getBs());

        return values;
    }
}
