package com.example.placeholderviewer.data.dtos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.placeholderviewer.data.database.contracts.PostContract;
import com.example.placeholderviewer.data.database.contracts.UserContract;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.entities.User;

import java.util.ArrayList;
import java.util.List;

public class DbPostDTO implements DbEntityDTO<Post> {

    @Override
    public Post parseOut(Cursor cursor) {
        Post post = new Post();
        User author = new User();
        List<Comment> comments = new ArrayList<>();

        post.setId(cursor.getLong(cursor.getColumnIndex(PostContract.COL_ID)));
        post.setTitle(cursor.getString(cursor.getColumnIndex(PostContract.COL_TITLE)));
        post.setBody(cursor.getString(cursor.getColumnIndex(PostContract.COL_BODY)));

        author.setId(cursor.getLong(cursor.getColumnIndex(UserContract.COL_ID)));
        post.setAuthor(author);
        post.setComments(comments);

        return post;
    }

    @Override
    public ContentValues parseIn(Post item) {
        ContentValues values = new ContentValues();

        values.put(PostContract.COL_USER_ID, item.getAuthor().getId());
        values.put(PostContract.COL_TITLE, item.getTitle());
        values.put(PostContract.COL_BODY, item.getBody());

        return values;
    }
}
