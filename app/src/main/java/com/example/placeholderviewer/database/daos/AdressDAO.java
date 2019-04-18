package com.example.placeholderviewer.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.database.DbManager;
import com.example.placeholderviewer.database.DbOpenHelper;
import com.example.placeholderviewer.database.contracts.AdressContract;
import com.example.placeholderviewer.database.dtos.DbAdressDTO;
import com.example.placeholderviewer.entities.Adress;

import java.util.ArrayList;
import java.util.List;

public class AdressDAO implements BaseDAO<Adress> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;

    @Override
    public List<Adress> selectByIdElement(Long idElement) {
        return null;
    }

    private DbAdressDTO dbAdressDTO;

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
            result.setGeo(dbManager.getGeoDAO().select(result.getGeo().getId()));
        }
        return result;
    }

    @Override
    public List<Adress> select() {

        List<Adress> result = new ArrayList<>();
        Adress adress = null;
        Long idGeo;

        Cursor cursor = db.query(AdressContract.TABLE_NAME,
                AdressContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            adress = dbAdressDTO.parseOut(cursor);
            adress.setGeo(dbManager.getGeoDAO().select(adress.getGeo().getId()));

            result.add(adress);
        }
        return result;
    }

    @Override
    public Adress insert(Adress item) {
        ContentValues values = dbAdressDTO.parseIn(item);
        item.setId(db.insert(AdressContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(Adress item) {
        ContentValues values = dbAdressDTO.parseIn(item);
        return db.update(AdressContract.TABLE_NAME, values,AdressContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public boolean delete(Adress item) {
        return db.delete(AdressContract.TABLE_NAME, AdressContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }
}
