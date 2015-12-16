package com.emmbi.mobile.example.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.base.BaseActionBarFragment;


public class LoginFragment extends BaseActionBarFragment {


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_login,
                container, false);

        initialize(getString(R.string.login_title));

        return view;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

    }

    public void signup(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
    }

    public void login(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
    }

    public void loginFacebook(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
    }

}