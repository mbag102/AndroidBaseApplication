package com.emmbi.mobile.example.fragments.base;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.emmbi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbagliojr on 2/23/15.
 */
public abstract class BaseDoneCancelFragment extends BaseActionBarFragment implements View.OnClickListener {

    @Override
    protected void initialize() {
        initialize(null);
    }

    @Override
    protected void initialize(String title) {
        toolbarFragment = getChildFragmentManager().findFragmentById(R.id.app_bar);

        List<Integer> buttons = new ArrayList<Integer>();
        buttons.add(R.id.actionbar_cancel);
        buttons.add(R.id.actionbar_done);
        ((TextView) toolbarFragment.getView().findViewById(R.id.cancel_button_text)).setTextColor(getTextColor());
        ((TextView) toolbarFragment.getView().findViewById(R.id.cancel_button_logo)).setTextColor(getTextColor());
        ((TextView) toolbarFragment.getView().findViewById(R.id.cancel_button_text)).setText(getCancelText());
        ((TextView) toolbarFragment.getView().findViewById(R.id.done_button_text)).setTextColor(getTextColor());
        ((TextView) toolbarFragment.getView().findViewById(R.id.done_button_logo)).setTextColor(getTextColor());
        ((TextView) toolbarFragment.getView().findViewById(R.id.done_button_text)).setText(getDoneText());
        super.initialize(buttons, this);
    }

    public int getTextColor() {
        return Color.parseColor("#ffffff");
    }

    public String getDoneText() {
        return getString(R.string.save_str);
    }

    public String getCancelText() {
        return getString(R.string.cancel);
    }

    public abstract void onDone();
    public void onCancel() {
        getActivity().onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_done:
                onDone();
                break;
            case R.id.actionbar_cancel:
                onCancel();
                break;
        }
    }
}
