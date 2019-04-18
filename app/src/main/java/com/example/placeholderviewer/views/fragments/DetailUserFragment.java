package com.example.placeholderviewer.views.fragments;

import android.content.Context;;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.placeholderviewer.R;
import com.example.placeholderviewer.entities.User;

public class DetailUserFragment extends Fragment {
    private User user;

    private TextView nameUserName;
    private TextView adress;
    private TextView phone;
    private TextView website;
    private TextView compagny;
    private TextView email;

    private OnFragmentInteractionListener mListener;

    public DetailUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_user, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = mListener.onFragmentInteraction();

        nameUserName = getActivity().findViewById(R.id.detailUserFragmentNameTextview);
        phone = getActivity().findViewById(R.id.detailUserFragmentPhoneTextview);
        website = getActivity().findViewById(R.id.detailUserFragmentWebsiteextview);
        email = getActivity().findViewById(R.id.detailUserFragmentEmailTextview);

        nameUserName.setText(user.getUserName() + " " + user.getName());
        phone.setText(user.getPhone());
        website.setText(user.getWebsite());
        email.setText(user.getEmail());
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

    public interface OnFragmentInteractionListener {
        User onFragmentInteraction();
    }
}
