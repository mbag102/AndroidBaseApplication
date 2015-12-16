package com.emmbi.mobile.example.fragments.toolbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emmbi.R;

/**
 * Created by mbagliojr on 2/23/15.
 */
public class BasicToolbarFragment extends Fragment {

    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.base_back_button_toolbar,
                container, false);

        return view;
    }

    public void setTitle(String title) {
        ((TextView) view.findViewById(R.id.toolbar_title)).setText(title);
    }
}
