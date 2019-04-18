package com.example.placeholderviewer.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.placeholderviewer.database.DbManager;
import com.example.placeholderviewer.database.DbOpenHelper;
import com.example.placeholderviewer.database.contracts.PostContract;
import com.example.placeholderviewer.database.dtos.DbPostDTO;
import com.example.placeholderviewer.entities.Post;

import java.util.ArrayList;
import java.util.List;

public class PostDAO implements BaseDAO<Post> {
    private SQLiteDatabase db = null;
    private DbManager dbManager;
    private DbPostDTO dbPostDTO;

    public PostDAO() {
        this.db = DbOpenHelper.getInstance().getDb();
        this.dbManager = new DbManager();
        this.dbPostDTO = new DbPostDTO();
    }

    @Override
    public List<Post> selectByIdElement(Long idElement) {
        return null;
    }

    @Override
    public Post select(Long id) {
        Post result = null;

        Cursor cursor = db.query(PostContract.TABLE_NAME,
                PostContract.ALL_SELECT,
                PostContract.COL_ID + "=?",
                new String[]{id.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            result = dbPostDTO.parseOut(cursor);
            result.setAuthor(dbManager.getUserDAO().select(result.getAuthor().getId()));
            result.setComments(dbManager.getCommentDAO().selectByIdElement(result.getId()));

        }
        return result;
    }

    @Override
    public List<Post> select() {
        List<Post> result = new ArrayList<>();
        Post post = null;

        Cursor cursor = db.query(PostContract.TABLE_NAME,
                PostContract.ALL_SELECT,
                null,null,null, null, null);
        while (cursor.moveToNext()) {
            post = dbPostDTO.parseOut(cursor);
            post.setAuthor(dbManager.getUserDAO().select(post.getAuthor().getId()));

            result.add(post);
        }
        return result;
    }

    @Override
    public Post insert(Post item) {
        ContentValues values = dbPostDTO.parseIn(item);
        item.setId(db.insert(PostContract.TABLE_NAME, null, values));
        return item;
    }

    @Override
    public boolean update(Post item) {
        ContentValues values = dbPostDTO.parseIn(item);
        return db.update(PostContract.TABLE_NAME, values,PostContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }

    @Override
    public boolean delete(Post item) {
        return db.delete(PostContract.TABLE_NAME, PostContract.COL_ID + "=?",
                new String[]{item.getId().toString()}) == 1;
    }
}
