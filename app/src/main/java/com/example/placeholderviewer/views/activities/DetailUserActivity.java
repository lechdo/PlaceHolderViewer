package com.example.placeholderviewer.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.entities.User;
import com.example.placeholderviewer.views.fragments.DetailUserFragment;

public class DetailUserActivity extends AppCompatActivity implements DetailUserFragment.OnFragmentInteractionListener{
    Post post;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        Intent intent = getIntent();
        post = intent.getParcelableExtra("post");
        user = post.getAuthor();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailUserFragment detailUserFragment = new DetailUserFragment();
        fragmentTransaction.add(R.id.detailUserActivityDetailUserFragmentContainer, detailUserFragment).commit();
    }

    @Override
    public User onFragmentInteraction() {
        return user;
    }
}
