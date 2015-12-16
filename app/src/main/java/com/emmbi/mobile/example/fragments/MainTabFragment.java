package com.emmbi.mobile.example.fragments;

/**
 * Created by mbagliojr on 8/21/15.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emmbi.mobile.example.AppRater;
import com.emmbi.mobile.example.Constants;
import com.emmbi.R;
import com.emmbi.mobile.example.enums.Tab;
import com.emmbi.mobile.example.fragments.base.BaseFragment;


public class MainTabFragment extends BaseFragment {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    public static String INITIAL_TAB = "initialTab";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.main_tab_view,
                container, false);

        view.findViewById(R.id.settings_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingsFragment settingsFragment = SettingsFragment.newInstance();
                addFragment(settingsFragment);
            }
        });

        view.findViewById(R.id.create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateJobFragment createJobFragment = CreateJobFragment.newInstance();
                addFragment(createJobFragment);
            }
        });

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_job));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_map));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_specials));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_messages));

        //mPager = (ViewPager) findViewById(R.id.pager);
        //mPager.setAdapter(mAdapter);
        //mTabLayout.setTabsFromPagerAdapter(mAdapter);
        //mTabLayout.setupWithViewPager(mPager);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;

                if(tab.getPosition() == 0) {
                    fragment = new JobsTab();
                } else if(tab.getPosition() == 1) {
                    fragment = new MapsTab();
                } else if(tab.getPosition() == 2) {
                    fragment = new SpecialsTab();
                } else {
                    fragment = new MessagesTab();
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.tabcontent, fragment).commit();

                int i = tab.getPosition();
                Tab selectedTab = Tab.fromTabNum(i);

//                getIntent().putExtra(MainTabFragment.INITIAL_TAB, selectedTab.getName());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // Iterate over all tabs and set the custom view
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }

        mTabLayout.getTabAt(1).select();

        boolean launchRateDialog = getActivity().getIntent().getBooleanExtra(Constants.LAUNCH_RATE_DIALOG, false);
        if(launchRateDialog) {
            AppRater.showRateDialog(getActivity());
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_tab_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
//            case R.id.action_compose:
//                composeMessage();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    } */

    private View getTabView(int position) {

        String text;

        if(position == 0) {
            text = getString(R.string.tab_job);
        } else if(position == 1) {
            text = getString(R.string.tab_map);;
        } else if(position == 2) {
            text = getString(R.string.tab_specials);;
        } else {
            text = getString(R.string.tab_messages);;
        }

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tabs_main,
                null);
        TextView tv = (TextView) view.findViewById(R.id.tabsText);
        tv.setText(text);

        TextView notificationCountField = (TextView)view.findViewById(R.id.notification_count);
        notificationCountField.setVisibility(View.GONE);

        return view;
    }

}

