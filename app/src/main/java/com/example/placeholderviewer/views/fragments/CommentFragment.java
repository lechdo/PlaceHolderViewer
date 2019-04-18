package com.example.placeholderviewer.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.preferences.UtilPreferences;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CommentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CommentFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private Comment comment;

    private TextView name;
    private TextView body;

    public CommentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        comment =  mListener.getComment();

//        name = getActivity().findViewById(R.id.commentFragmentNameTextview);
//        body = getActivity().findViewById(R.id.commentFragmentBodyTextview);
        name = new TextView(view.getContext());
        body = new TextView(view.getContext());

        //int side = UtilPreferences.getNextCommentSide();
        //name.setGravity(side);
        //body.setGravity(side);

        name.setText(comment.getName());
        body.setText(comment.getBody());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        Comment getComment();
    }
}
