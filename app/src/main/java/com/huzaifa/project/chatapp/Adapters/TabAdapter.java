package com.huzaifa.project.chatapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Muhammad Huzaifa on 2/19/2018.
 */

public class TabAdapter extends FragmentPagerAdapter{
    int FRAG_COUNT;
    ArrayList<Fragment> fragments;
    ArrayList<String> title;
    public TabAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.FRAG_COUNT = fragments.size();
        this.fragments = fragments;
        title = new ArrayList<>();
        title.add("Home");
        title.add("Notifications");
        title.add("Messages");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return FRAG_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
