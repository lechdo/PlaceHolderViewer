package com.example.placeholderviewer.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.Post;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailPostFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailPostFragment extends Fragment {
    private Post post;
    TextView title;
    TextView body;
    TextView author;


    private OnFragmentInteractionListener mListener;

    public DetailPostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailPostFragment newInstance(String param1, String param2) {
        DetailPostFragment fragment = new DetailPostFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = getActivity().findViewById(R.id.detailPostFragmentTitleTextview);
        body = getActivity().findViewById(R.id.detailPostFragmentBodyTextview);
        author = getActivity().findViewById(R.id.detailPostFragmentAuthorTextview);

        post = mListener.onFragmentInteraction();

        title.setText(post.getTitle());
        body.setText(post.getBody());
        author.setText(post.getAuthor().getUserName() + " " + post.getAuthor().getName());
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        Post onFragmentInteraction();
    }
}
