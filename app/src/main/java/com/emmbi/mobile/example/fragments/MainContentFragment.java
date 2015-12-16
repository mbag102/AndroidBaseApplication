package com.emmbi.mobile.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.base.BaseActionBarFragment;


public class MainContentFragment extends BaseActionBarFragment {

    public MainContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        return view;
    }

    public void addFragment(Fragment fragment) {

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.content, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
}
