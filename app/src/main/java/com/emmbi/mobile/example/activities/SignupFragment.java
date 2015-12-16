package com.emmbi.mobile.example.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.base.BaseActionBarFragment;


public class SignupFragment extends BaseActionBarFragment {

    public static SignupFragment newInstance() {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_signup,
                container, false);

        initialize(getString(R.string.signup_title));

        return view;
    }
}