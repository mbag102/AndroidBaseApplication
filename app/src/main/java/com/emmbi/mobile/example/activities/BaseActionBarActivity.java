package com.emmbi.mobile.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.MenuItem;

/**
 * Created by mbagliojr on 2/23/15.
 */
public abstract class BaseActionBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        hideKeyboard();
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
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * If this is not implemented, the back arrow will navigate to the previous screen
     * @return
     */
    public abstract Intent getBackButtonIntent();

    public abstract void setFlagsAndExtrasOnBackButton(Intent intent);
}
