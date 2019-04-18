package com.example.placeholderviewer.views.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.api.AccessData;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.views.fragments.ListedPostFragment;

import java.util.concurrent.ExecutionException;

public class ListPostActivity extends AppCompatActivity implements ListedPostFragment.OnListFragmentInteractionListener {

    private static final String TAG = "ListPostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null && ni.isConnected()){
            /* API load */
            String url = "https://jsonplaceholder.typicode.com/users";

            String result = null;
            try {

                result = new AccessData().execute(url).get();
                Log.d(TAG, result);

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //this.populateView2(new JSONObject(result));
        }else{
            Toast.makeText(this,"Not connected to network",Toast.LENGTH_LONG).show();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ListedPostFragment listedPostFragment = new ListedPostFragment();
        fragmentTransaction.add(R.id.listPostActivityListedFragmentContainer, listedPostFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Post onShortClickListener(Post item) {
        Intent intent = new Intent(this, DetailPostActivity.class);
        intent.putExtra("post", (Parcelable) item);
        startActivity(intent);

        return item;
    }

    @Override
    public Post onLongClickListener(Post item) {
        Intent intent = new Intent(this, DetailUserActivity.class);
        intent.putExtra("post", (Parcelable) item);
        startActivity(intent);

        return item;
    }
}
