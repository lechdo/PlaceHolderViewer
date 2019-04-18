package com.example.placeholderviewer.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.database.DbManager;
import com.example.placeholderviewer.database.DbOpenHelper;
import com.example.placeholderviewer.database.contracts.CommentContract;
import com.example.placeholderviewer.database.dtos.DbCommentDTO;
import com.example.placeholderviewer.entities.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements BaseDAO<Comment> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;
    private DbCommentDTO dbCommentDTO;

    public CommentDAO() {
        this.db = DbOpenHelper.getInstance().getDb();
        this.dbManager = new DbManager();
        this.dbCommentDTO = new DbCommentDTO();
    }

    @Override
    public Comment select(Long id) {
        Comment result = null;

        Cursor cursor = db.query(CommentContract.TABLE_NAME,
                CommentContract.ALL_SELECT,
                CommentContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbCommentDTO.parseOut(cursor);
            result.setPost(dbManager.getPostDAO().select(result.getPost().getId()));

        }
        return result;
    }

    @Override
    public List<Comment> selectByIdElement(Long idElement) {
        List<Comment> result = new ArrayList<>();
        Comment comment = null;

        Cursor cursor = db.query(CommentContract.TABLE_NAME,
                CommentContract.ALL_SELECT,
                CommentContract.COL_POST_ID + "=?",new String[]{idElement.toString()},null, null, null);
        while (cursor.moveToNext()) {
            comment = dbCommentDTO.parseOut(cursor);
            comment.setPost(dbManager.getPostDAO().select(comment.getPost().getId()));

            result.add(comment);
        }
        return result;
    }

    @Override
    public List<Comment> select() {
        List<Comment> result = new ArrayList<>();
        Comment comment = null;

        Cursor cursor = db.query(CommentContract.TABLE_NAME,
                CommentContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            comment = dbCommentDTO.parseOut(cursor);

            result.add(comment);
        }
        return result;
    }

    @Override
    public Comment insert(Comment item) {
        ContentValues values = dbCommentDTO.parseIn(item);
        item.setId(db.insert(CommentContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(Comment item) {
        ContentValues values = dbCommentDTO.parseIn(item);
        return db.update(CommentContract.TABLE_NAME, values,CommentContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public boolean delete(Comment item) {
        return db.delete(CommentContract.TABLE_NAME, CommentContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }
}
