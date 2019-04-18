package com.example.placeholderviewer.data.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.data.database.DbManager;
import com.example.placeholderviewer.data.database.DbOpenHelper;
import com.example.placeholderviewer.data.database.contracts.GeoContract;
import com.example.placeholderviewer.data.dtos.DbGeoDTO;
import com.example.placeholderviewer.entities.Geo;

import java.util.ArrayList;
import java.util.List;

public class GeoDAO implements BaseDAO<Geo> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;
    private DbGeoDTO dbGeoDTO;

    public GeoDAO() {
        this.db = DbOpenHelper.getInstance().getDb();
        this.dbManager = new DbManager();
        this.dbGeoDTO = new DbGeoDTO();
    }

    @Override
    public Geo select(Long id) {
        Geo result = null;

        Cursor cursor = db.query(GeoContract.TABLE_NAME,
                GeoContract.ALL_SELECT,
                GeoContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbGeoDTO.parseOut(cursor);

        }
        return result;
    }

    @Override
    public List<Geo> select() {
        List<Geo> result = new ArrayList<>();
        Geo geo = null;

        Cursor cursor = db.query(GeoContract.TABLE_NAME,
                GeoContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            geo = dbGeoDTO.parseOut(cursor);
            result.add(geo);
        }
        return result;
    }

    @Override
    public Geo insert(Geo item) {
        ContentValues values = dbGeoDTO.parseIn(item);
        item.setId(db.insert(GeoContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(Geo item) {
        ContentValues values = dbGeoDTO.parseIn(item);
        return db.update(GeoContract.TABLE_NAME, values,GeoContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public List<Geo> selectByIdElement(Long idElement) {
        return null;
    }

    @Override
    public boolean delete(Geo item) {
        return db.delete(GeoContract.TABLE_NAME, GeoContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }
}
