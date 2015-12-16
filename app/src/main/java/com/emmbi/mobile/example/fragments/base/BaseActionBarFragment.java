package com.emmbi.mobile.example.fragments.base;

import android.support.v4.app.Fragment;
import android.view.View;

import com.emmbi.R;
import com.emmbi.mobile.example.fragments.toolbar.BasicToolbarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbagliojr on 2/23/15.
 */
public abstract class BaseActionBarFragment extends BaseFragment {

    protected Fragment toolbarFragment;

    protected void initialize() {
        initialize(null);
    }

    protected void initialize(String title) {
        toolbarFragment = getChildFragmentManager().findFragmentById(R.id.app_bar);

        if(toolbarFragment instanceof BasicToolbarFragment) {

            initialize(R.id.back_button, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     toolBarViewClicked(view);
                }
            });
            setTitle(title);
        } else {
            initialize(null, null);
        }
    }

    protected void initialize(int buttonId, View.OnClickListener onClickListener) {
        List<Integer> buttonIds = new ArrayList<Integer>();
        buttonIds.add(buttonId);
        initialize(buttonIds, onClickListener);
    }

    protected void initialize(List<Integer> buttonIds, View.OnClickListener onClickListener) {

        if(toolbarFragment == null) {
            toolbarFragment = getChildFragmentManager().findFragmentById(R.id.app_bar);
        }

        if(buttonIds != null) {
            for(Integer id: buttonIds) {
                toolbarFragment.getView().findViewById(id).setOnClickListener(onClickListener);
            }

        }
    }

    private void setTitle(String title) {
        if(toolbarFragment instanceof BasicToolbarFragment) {
            ((BasicToolbarFragment) toolbarFragment).setTitle(title);
        }
    }

    public boolean toolBarViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                getActivity().onBackPressed();
                return true;
        }

        return false;
    }
}
