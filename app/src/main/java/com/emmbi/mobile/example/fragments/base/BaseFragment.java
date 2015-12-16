package com.emmbi.mobile.example.fragments.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.emmbi.mobile.example.ApplicationController;
import com.emmbi.mobile.example.activities.MainActivity;
import com.emmbi.mobile.example.events.ActivityResultEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by mbagliojr on 5/29/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fragment at top of stack gets highest priority
        EventBus.getDefault().register(this, ApplicationController.getInstance().getActionBarFragmentPriority());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(ActivityResultEvent event) {
        //EventBus.getDefault().cancelEventDelivery(event);
    }

    public void addFragment(Fragment fragment) {
        ((MainActivity) getActivity()).addFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        ((MainActivity) getActivity()).replaceFragment(fragment);
    }

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    public void finish() {
        getMainActivity().removeFragment(this);
    }
}
