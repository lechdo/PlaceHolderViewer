package com.example.placeholderviewer.database.daos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.database.DbManager;
import com.example.placeholderviewer.database.DbOpenHelper;
import com.example.placeholderviewer.database.contracts.AdressContract;
import com.example.placeholderviewer.database.contracts.GeoContract;
import com.example.placeholderviewer.database.dtos.DbAdressDTO;
import com.example.placeholderviewer.entities.Adress;

import java.util.List;

public class AdressDAO implements BaseDAO<Adress> {
    private SQLiteDatabase db = null;
    DbManager dbManager;
    DbAdressDTO dbAdressDTO;

    public AdressDAO() {
        db = DbOpenHelper.getInstance().getDb();
        dbManager = new DbManager();
        dbAdressDTO = new DbAdressDTO();
    }

    @Override
    public Adress select(Long id) {
        Adress result = null;
        Long idGeo;

        Cursor cursor = db.query(AdressContract.TABLE_NAME,
                AdressContract.ALL_SELECT,
                AdressContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbAdressDTO.parseOut(cursor);
            result.setGeo(dbManager.getGeoDAO().select(cursor.getLong(
                    cursor.getColumnIndex(AdressContract.COL_GEO_ID))));
        }
        return result;
    }

    @Override
    public List<Adress> select() {
        return null;
    }

    @Override
    public Adress insert(Adress item) {
        return null;
    }

    @Override
    public boolean update(Adress item) {
        return false;
    }

    @Override
    public boolean delete(Adress item) {
        return false;
    }
}
