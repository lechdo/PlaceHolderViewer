package com.example.placeholderviewer.webservice.daos;

import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;

import com.example.placeholderviewer.data.database.contracts.PostContract;
import com.example.placeholderviewer.data.dtos.DbPostDTO;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.webservice.WebServiceOpenHelper;
import com.example.placeholderviewer.webservice.AccessNetworkRawData;
import com.example.placeholderviewer.webservice.jsonutils.JSONArrayCursor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PostNetworkDAO implements EntityNetworkDAO<Post> {
    private NetworkInfo networkInfo;
    private DbPostDTO dbPostDTO;

    public PostNetworkDAO() {
        dbPostDTO = new DbPostDTO();
    }

    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public List<Post> get(Context context) {
        List<Post> posts = new ArrayList<>();
        String result = null;
        networkInfo = WebServiceOpenHelper.getNetworkInfo(context);

        try {
            result = new AccessNetworkRawData().execute(POSTS_URL).get();

            final Cursor cursor = new JSONArrayCursor(new JSONArray(result));

            while (cursor.moveToNext()) {
                Post post = dbPostDTO.parseOut(cursor);
                post.setAuthor(new UserNetworkDAO().get(context, cursor.getLong(cursor.getColumnIndex(PostContract.COL_USER_ID))));
                posts.add(post);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return posts;
    }


    @Override
    public Post get(Context context, Long idItem) {
        Post post = null;
        String result = null;
        networkInfo = WebServiceOpenHelper.getNetworkInfo(context);

        try {
            result = new AccessNetworkRawData().execute(POSTS_URL + "/" + idItem.toString()).get();

            JSONArrayCursor jsonArrayCursor = new JSONArrayCursor(new JSONArray().put(new JSONObject(result)));
            Cursor cursor = jsonArrayCursor;
            if (cursor.moveToNext()) {
                post = dbPostDTO.parseOut(cursor);
                post.setAuthor(new UserNetworkDAO().get(context, cursor.getLong(cursor.getColumnIndex(PostContract.COL_USER_ID))));
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return post;
    }
}
