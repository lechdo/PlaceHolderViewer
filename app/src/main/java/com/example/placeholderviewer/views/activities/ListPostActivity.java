package com.example.placeholderviewer.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.webservice.daos.PostNetworkDAO;
import com.example.placeholderviewer.views.fragments.ListedPostFragment;

import java.util.List;

public class ListPostActivity extends AppCompatActivity implements ListedPostFragment.OnListFragmentInteractionListener {

    private static final String TAG = "ListPostActivity";

    private List<Post> posts;

    @Override
    public List<Post> getListPosts() {
        return posts;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        posts = new PostNetworkDAO().get(this);
//        List<Comment> comments = new CommentNetworkDAO().get(this);
//        for (Post post: posts) {
//            for (Comment comment: comments) {
//                if (comment.getPost().getId() == post.getId()) {
//                    post.getComments().add(comment);
//                }
//            }
//        }

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
        int id = item.getItemId();

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
