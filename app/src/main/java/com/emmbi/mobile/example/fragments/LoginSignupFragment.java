package com.emmbi.mobile.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.base.BaseActionBarFragment;

public class LoginSignupFragment extends BaseActionBarFragment {


    public static LoginSignupFragment newInstance() {
        LoginSignupFragment fragment = new LoginSignupFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_login_signup,
                container, false);

        return view;
    }
}