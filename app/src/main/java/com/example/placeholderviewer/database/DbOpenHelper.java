package com.example.placeholderviewer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.placeholderviewer.PlaceHolderViewerApplication;
import com.example.placeholderviewer.database.contracts.AdressContract;
import com.example.placeholderviewer.database.contracts.CommentContract;
import com.example.placeholderviewer.database.contracts.CompagnyContract;
import com.example.placeholderviewer.database.contracts.GeoContract;
import com.example.placeholderviewer.database.contracts.PostContract;
import com.example.placeholderviewer.database.contracts.UserContract;

import java.util.List;

public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "placeholderviewer.db";
    private static final int DB_VERSION = 1;

    private static DbOpenHelper instance;

    private DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    public static synchronized DbOpenHelper getInstance() {
        if (instance == null) {
            instance = new DbOpenHelper(PlaceHolderViewerApplication.getAppContext());
        }
        return instance;
    }

    private static SQLiteDatabase db;



    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserContract.DROP_TABLE);
        db.execSQL(CommentContract.DROP_TABLE);
        db.execSQL(CompagnyContract.DROP_TABLE);
        db.execSQL(GeoContract.DROP_TABLE);
        db.execSQL(PostContract.DROP_TABLE);
        db.execSQL(AdressContract.DROP_TABLE);

        onCreate(db);
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            db = this.getWritableDatabase();
        }
        return db;

    }
}
