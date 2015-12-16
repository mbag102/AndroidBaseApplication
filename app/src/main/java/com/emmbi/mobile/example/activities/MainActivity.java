package com.emmbi.mobile.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.emmbi.R;
import com.emmbi.mobile.example.events.ActivityResultEvent;
import com.emmbi.mobile.example.fragments.MainContentFragment;
import com.emmbi.mobile.example.fragments.MainTabFragment;

import de.greenrobot.event.EventBus;


public class MainActivity extends BaseActivity {

    private MainContentFragment mainContentFragment;
    private MainTabFragment mainTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContentFragment = new MainContentFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_content, mainContentFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

        mainTabFragment = (MainTabFragment) getSupportFragmentManager().findFragmentById(R.id.main_listview);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        //Content
        if(fragment.equals(mainContentFragment)) {
            if(!getResources().getBoolean(R.bool.isTablet)) {
                mainContentFragment.replaceFragment(new MainTabFragment());
            }
        }
    }

    public void addFragment(Fragment fragment) {
        mainContentFragment.addFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        mainContentFragment.replaceFragment(fragment);
    }

    public void removeFragment(Fragment fragment) {
        mainContentFragment.removeFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        if (!mainContentFragment.getChildFragmentManager().popBackStackImmediate()) {
            finish();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        EventBus.getDefault().post(new ActivityResultEvent(requestCode, resultCode, data));
    }

}
