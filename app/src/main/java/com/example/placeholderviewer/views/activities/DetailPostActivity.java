package com.example.placeholderviewer.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.preferences.UtilPreferences;
import com.example.placeholderviewer.views.fragments.CommentFragment;
import com.example.placeholderviewer.views.fragments.DetailPostFragment;

public class DetailPostActivity extends AppCompatActivity implements DetailPostFragment.OnFragmentInteractionListener, CommentFragment.OnFragmentInteractionListener{
    Post post;
    Comment comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        Intent intent = getIntent();
        post = intent.getParcelableExtra("post");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailPostFragment detailPostFragment = new DetailPostFragment();
        fragmentTransaction.add(R.id.detailPostActivityDetailPostFragmentContainer, detailPostFragment);

        //UtilPreferences.resetCommentSide();
        //int side = Gravity.LEFT;
        for (Comment comment: post.getComments()) {
            LinearLayout layout = findViewById(R.id.detailPostActivityDetailCommentsFragmentContainer);
            this.comment = comment;
            //CommentFragment commentFragment = new CommentFragment();
            //fragmentTransaction.add(R.id.detailPostActivityDetailCommentsFragmentContainer, commentFragment);


            TextView textView = new TextView(this);
            TextView textView2 = new TextView(this);
            textView.setText(comment.getName());
            textView2.setText(comment.getBody());

            layout.addView(textView);
            layout.addView(textView2);
        }
        fragmentTransaction.commit();
    }

    @Override
    public Post onFragmentInteraction() {
        return post;
    }

    @Override
    public Comment getComment() {
        return comment;
    }
}
