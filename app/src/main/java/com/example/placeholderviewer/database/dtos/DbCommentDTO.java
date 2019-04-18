package com.example.placeholderviewer.database.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.database.contracts.CommentContract;
import com.example.placeholderviewer.database.contracts.PostContract;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Post;

public class DbCommentDTO implements DbEntityDTO<Comment> {

    @Override
    public Comment parseOut(Cursor cursor) {
        Comment comment = new Comment();
        Post post = new Post();
        comment.setId(cursor.getLong(cursor.getColumnIndex(CommentContract.COL_ID)));
        comment.setBody(cursor.getString(cursor.getColumnIndex(CommentContract.COL_BODY)));
        comment.setName(cursor.getString(cursor.getColumnIndex(CommentContract.COL_NAME)));

        post.setId(cursor.getLong(cursor.getColumnIndex(PostContract.COL_ID)));

        return comment;
    }

    @Override
    public ContentValues parseIn(Comment item) {
        ContentValues values = new ContentValues();

        values.put(CommentContract.COL_POST_ID, item.getPost().getId());
        values.put(CommentContract.COL_NAME, item.getName());
        values.put(CommentContract.COL_BODY, item.getBody());

        return values;
    }
}
