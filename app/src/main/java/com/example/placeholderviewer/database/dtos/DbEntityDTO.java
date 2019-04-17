package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

public interface DbEntityDTO<T> {

    T parseOut(Cursor cursor);

    ContentValues parseIn(T item);
}
