package com.emmbi.mobile.example.fragments.toolbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmbi.R;

/**
 * Created by mbagliojr on 2/23/15.
 */
public class DoneCancelToolbarFragment extends Fragment {

    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.done_cancel_toolbar,
                container, false);

        return view;
    }

}
