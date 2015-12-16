package com.emmbi.mobile.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.LoginSignupFragment;


public class LoginSignupActivity extends BaseActivity {

    private LoginSignupFragment loginSignupFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        loginSignupFragment = LoginSignupFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_content, loginSignupFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

    }

    public void navigateSignupScreen(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_content, SignupFragment.newInstance());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void navigateLoginScreen(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_content, LoginFragment.newInstance());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void loginFacebook(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void login(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signup(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}