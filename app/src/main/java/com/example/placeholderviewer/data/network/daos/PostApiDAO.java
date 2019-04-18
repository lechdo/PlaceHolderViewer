package com.example.placeholderviewer.data.network.daos;

import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;

import com.example.placeholderviewer.data.database.contracts.PostContract;
import com.example.placeholderviewer.data.dtos.DbPostDTO;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.data.network.NetworkOpenHelper;
import com.example.placeholderviewer.data.network.AccessData;
import com.example.placeholderviewer.data.network.JSONArrayCursor;
import com.example.placeholderviewer.entities.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PostApiDAO implements EntityApiDAO<Post> {
    private NetworkInfo networkInfo;
    private DbPostDTO dbPostDTO;

    public PostApiDAO() {
        dbPostDTO = new DbPostDTO();
    }

    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public List<Post> get(Context context) {
        List<Post> posts = new ArrayList<>();
        String result = null;
        networkInfo = NetworkOpenHelper.getNetworkInfo(context);

        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                result = new AccessData().execute(POSTS_URL).get();

                final Cursor cursor = new JSONArrayCursor(new JSONArray(result));

                while (cursor.moveToNext()) {
                    Post post = dbPostDTO.parseOut(cursor);
                    post.setAuthor(new UserApiDAO().get(context, cursor.getLong(cursor.getColumnIndex(PostContract.COL_USER_ID))));
                    posts.add(post);
                }

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return posts;
    }


    @Override
    public Post get(Context context, Long idItem) {
        Post post = null;
        String result = null;
        networkInfo = NetworkOpenHelper.getNetworkInfo(context);

        try {
            result = new AccessData().execute(POSTS_URL + "/" + idItem.toString()).get();

            JSONArrayCursor jsonArrayCursor = new JSONArrayCursor(new JSONArray().put(new JSONObject(result)));
            Cursor cursor = jsonArrayCursor;
            if (cursor.moveToNext()) {
                post = dbPostDTO.parseOut(cursor);
                post.setAuthor(new UserApiDAO().get(context, cursor.getLong(cursor.getColumnIndex(PostContract.COL_USER_ID))));
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
