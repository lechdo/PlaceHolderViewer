package com.example.placeholderviewer.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.database.DbManager;
import com.example.placeholderviewer.database.DbOpenHelper;
import com.example.placeholderviewer.database.contracts.CompagnyContract;
import com.example.placeholderviewer.database.dtos.DbCompagnyDTO;
import com.example.placeholderviewer.entities.Compagny;

import java.util.ArrayList;
import java.util.List;

public class CompagnyDAO implements BaseDAO<Compagny> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;
    private DbCompagnyDTO dbCompagnyDTO;

    public CompagnyDAO() {
        this.db = DbOpenHelper.getInstance().getDb();
        this.dbManager = new DbManager();
        this.dbCompagnyDTO = new DbCompagnyDTO();
    }

    @Override
    public Compagny select(Long id) {
        Compagny result = null;

        Cursor cursor = db.query(CompagnyContract.TABLE_NAME,
                CompagnyContract.ALL_SELECT,
                CompagnyContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbCompagnyDTO.parseOut(cursor);

        }
        return result;
    }

    @Override
    public List<Compagny> select() {
        List<Compagny> result = new ArrayList<>();
        Compagny compagny = null;

        Cursor cursor = db.query(CompagnyContract.TABLE_NAME,
                CompagnyContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            compagny = dbCompagnyDTO.parseOut(cursor);
            result.add(compagny);
        }
        return result;
    }

    @Override
    public Compagny insert(Compagny item) {
        ContentValues values = dbCompagnyDTO.parseIn(item);
        item.setId(db.insert(CompagnyContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(Compagny item) {
        ContentValues values = dbCompagnyDTO.parseIn(item);
        return db.update(CompagnyContract.TABLE_NAME, values,CompagnyContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public List<Compagny> selectByIdElement(Long idElement) {
        return null;
    }

    @Override
    public boolean delete(Compagny item) {
        return db.delete(CompagnyContract.TABLE_NAME, CompagnyContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }
}
