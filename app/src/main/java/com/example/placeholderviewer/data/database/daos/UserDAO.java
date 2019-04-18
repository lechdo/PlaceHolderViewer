package com.example.placeholderviewer.data.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.data.database.DbManager;
import com.example.placeholderviewer.data.database.DbOpenHelper;
import com.example.placeholderviewer.data.database.contracts.UserContract;
import com.example.placeholderviewer.data.dtos.DbUserDTO;
import com.example.placeholderviewer.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements BaseDAO<User> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;
    private DbUserDTO dbUserDTO;

    public UserDAO() {
        this.db = DbOpenHelper.getInstance().getDb();
        this.dbManager = new DbManager();
        this.dbUserDTO = new DbUserDTO();
    }

    @Override
    public User select(Long id) {
        User result = null;

        Cursor cursor = db.query(UserContract.TABLE_NAME,
                UserContract.ALL_SELECT,
                UserContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbUserDTO.parseOut(cursor);
            result.setAdress(dbManager.getAdressDAO().select(result.getAdress().getId()));
            result.setCompagny(dbManager.getCompagnyDAO().select(result.getCompagny().getId()));
        }
        return result;
    }

    @Override
    public List<User> select() {
        List<User> result = new ArrayList<>();
        User user;

        Cursor cursor = db.query(UserContract.TABLE_NAME,
                UserContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            user = dbUserDTO.parseOut(cursor);
            user.setAdress(dbManager.getAdressDAO().select(user.getAdress().getId()));
            user.setCompagny(dbManager.getCompagnyDAO().select(user.getCompagny().getId()));

            result.add(user);
        }
        return result;
    }

    @Override
    public User insert(User item) {
        ContentValues values = dbUserDTO.parseIn(item);
        item.setId(db.insert(UserContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(User item) {
        ContentValues values = dbUserDTO.parseIn(item);
        return db.update(UserContract.TABLE_NAME, values,UserContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public boolean delete(User item) {
        return db.delete(UserContract.TABLE_NAME, UserContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public List<User> selectByIdElement(Long idElement) {
        return null;
    }
}
