package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.database.contracts.AdressContract;
import com.example.placeholderviewer.database.contracts.CompagnyContract;
import com.example.placeholderviewer.database.contracts.UserContract;
import com.example.placeholderviewer.entities.Adress;
import com.example.placeholderviewer.entities.Compagny;
import com.example.placeholderviewer.entities.User;

public class DbUserDTO implements DbEntityDTO<User> {

    @Override
    public User parseOut(Cursor cursor) {
        User user = new User();
        Adress adress = new Adress();
        Compagny compagny = new Compagny();

        user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.COL_ID)));
        user.setName(cursor.getString(cursor.getColumnIndex(UserContract.COL_NAME)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(UserContract.COL_EMAIL)));
        user.setPhone(cursor.getString(cursor.getColumnIndex(UserContract.COL_PHONE)));
        user.setWebsite(cursor.getString(cursor.getColumnIndex(UserContract.COL_WEBSITE)));
        user.setUserName(cursor.getString(cursor.getColumnIndex(UserContract.COL_USERNAME)));

        adress.setId(cursor.getLong(cursor.getColumnIndex(AdressContract.COL_ID)));
        user.setAdress(adress);

        compagny.setId(cursor.getLong(cursor.getColumnIndex(CompagnyContract.COL_ID)));
        user.setCompagny(compagny);

        return user;
    }

    @Override
    public ContentValues parseIn(User item) {
        ContentValues values = new ContentValues();

        values.put(UserContract.COL_NAME, item.getName());
        values.put(UserContract.COL_USERNAME, item.getUserName());
        values.put(UserContract.COL_EMAIL, item.getEmail());
        values.put(UserContract.COL_ADRESS_ID, item.getAdress().getId());
        values.put(UserContract.COL_PHONE, item.getPhone());
        values.put(UserContract.COL_WEBSITE, item.getWebsite());
        values.put(UserContract.COL_COMPAGNY_ID, item.getCompagny().getId());

        return values;
    }
}
