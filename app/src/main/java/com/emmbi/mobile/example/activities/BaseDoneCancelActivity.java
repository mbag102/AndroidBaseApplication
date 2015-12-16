package com.emmbi.mobile.example.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emmbi.R;

/**
 * Created by mbagliojr on 2/23/15.
 */
public abstract class BaseDoneCancelActivity extends BaseActionBarActivity {

    private TextView doneButtonText;
    private TextView cancelButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        final LayoutInflater inflater = (LayoutInflater)
                getSupportActionBar().getThemedContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(
                R.layout.action_bar_done_cancel, null);

        doneButtonText = (TextView) customActionBarView.findViewById(R.id.done_button_text);
        cancelButtonText = (TextView) customActionBarView.findViewById(R.id.cancel_button_text);

        doneButtonText.setText(getDoneText());
        cancelButtonText.setText(getCancelText());

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                        ActionBar.DISPLAY_SHOW_HOME |
                        ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setCustomView(customActionBarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        customActionBarView.findViewById(R.id.actionbar_done)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onDone();
                    }
                });
        customActionBarView.findViewById(R.id.actionbar_cancel)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onCancel();
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                doBackAction();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void doBackAction() {
        Intent intent = getBackButtonIntent();
        if(intent != null) {
            setFlagsAndExtrasOnBackButton(intent);
            NavUtils.navigateUpTo(this, intent);
        } else {
            NavUtils.navigateUpFromSameTask(this);
            Intent upIntent = NavUtils.getParentActivityIntent(this);
            setFlagsAndExtrasOnBackButton(upIntent);
            if (upIntent == null) {
                throw new IllegalArgumentException("Activity " +
                        this.getClass().getSimpleName() +
                        " does not have a parent activity name specified." +
                        " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " +
                        " element in your manifest?)");
            }

            NavUtils.navigateUpTo(this, upIntent);
        }
    }

    @Override
    public void onBackPressed() {
        doBackAction();
    }

    // Before 2.0
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            doBackAction();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * If this is not implemented, the back arrow will navigate to the previous screen
     * @return
     */
    public abstract Intent getBackButtonIntent();

    public abstract void setFlagsAndExtrasOnBackButton(Intent intent);

    public abstract void onDone();
    public void onCancel() {
        onBackPressed();
    }

    public String getDoneText() {
        return getString(R.string.save_str);
    }

    public String getCancelText() {
        return getString(R.string.cancel);
    }
}
