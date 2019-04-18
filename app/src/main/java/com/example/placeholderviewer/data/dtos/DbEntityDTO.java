package com.example.placeholderviewer.data.dtos;

import android.content.ContentValues;
import android.database.Cursor;

public interface DbEntityDTO<T> {

    T parseOut(Cursor cursor);

    ContentValues parseIn(T item);
}
