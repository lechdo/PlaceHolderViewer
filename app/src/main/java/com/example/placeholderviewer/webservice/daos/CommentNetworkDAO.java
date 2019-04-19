package com.example.placeholderviewer.webservice.daos;

import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;

import com.example.placeholderviewer.data.database.contracts.CommentContract;
import com.example.placeholderviewer.data.dtos.DbCommentDTO;
import com.example.placeholderviewer.webservice.AccessNetworkRawData;
import com.example.placeholderviewer.webservice.jsonutils.JSONArrayCursor;
import com.example.placeholderviewer.webservice.WebServiceOpenHelper;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CommentNetworkDAO implements EntityNetworkDAO<Comment> {
    private NetworkInfo networkInfo;
    private DbCommentDTO dbCommentDTO;

    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public List<Comment> get(Context context) {
        List<Comment> comments = new ArrayList<>();
        String result = null;
        networkInfo = WebServiceOpenHelper.getNetworkInfo(context);

        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                result = new AccessNetworkRawData().execute(COMMENTS_URL).get();

                final Cursor cursor = new JSONArrayCursor(new JSONArray(result));

                while (cursor.moveToNext()) {
                    Comment comment = dbCommentDTO.parseOut(cursor);
                    comment.setPost(new Post(){{
                        setId(cursor.getLong(cursor.getColumnIndex(CommentContract.COL_POST_ID)));
                    }});
                    comments.add(comment);
                }

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return comments;
    }

    @Override
    public Comment get(Context context, Long idItem) {
        Comment comment = null;
        String result = null;
        networkInfo = WebServiceOpenHelper.getNetworkInfo(context);

        try {
            result = new AccessNetworkRawData().execute(COMMENTS_URL + "/" + idItem.toString()).get();

            JSONArrayCursor jsonArrayCursor = new JSONArrayCursor(new JSONArray().put(new JSONObject(result)));
            Cursor cursor = jsonArrayCursor;
            if (cursor.moveToNext()) {
                comment = dbCommentDTO.parseOut(cursor);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return comment;
    }
}
