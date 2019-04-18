package com.example.placeholderviewer.data.network.daos;

import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;

import com.example.placeholderviewer.data.dtos.DbPostDTO;
import com.example.placeholderviewer.data.dtos.DbUserDTO;
import com.example.placeholderviewer.data.network.AccessData;
import com.example.placeholderviewer.data.network.JSONArrayCursor;
import com.example.placeholderviewer.data.network.NetworkOpenHelper;
import com.example.placeholderviewer.entities.User;
import com.example.placeholderviewer.utils.Bouchon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserApiDAO implements EntityApiDAO<User> {
    private NetworkInfo networkInfo;
    private DbUserDTO dbUserDTO;

    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    public UserApiDAO() {
        dbUserDTO = new DbUserDTO();
    }

    @Override
    public List<User> get(Context context) {
        List<User> users = new ArrayList<>();
        String result = null;
        networkInfo = NetworkOpenHelper.getNetworkInfo(context);

        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                result = new AccessData().execute(USERS_URL).get();

                final Cursor cursor = new JSONArrayCursor(new JSONArray(result));

                while (cursor.moveToNext()) {
                    User user = dbUserDTO.parseOut(cursor);
                    users.add(user);
                }

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public User get(Context context, Long idItem) {
        User user = null;
        String result = null;
        networkInfo = NetworkOpenHelper.getNetworkInfo(context);

        try {
            result = new AccessData().execute(USERS_URL + "/" + idItem.toString()).get();

            JSONArrayCursor jsonArrayCursor = new JSONArrayCursor(new JSONArray().put(new JSONObject(result)));
            Cursor cursor = jsonArrayCursor;
            if (cursor.moveToNext()) {
                user = dbUserDTO.parseOut(cursor);

            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }
}
