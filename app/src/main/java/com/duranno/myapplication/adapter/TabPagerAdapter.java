package com.duranno.myapplication.adapter;

import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import com.duranno.myapplication.fragment.fragment1;
import com.duranno.myapplication.fragment.fragment2;
import com.duranno.myapplication.fragment.fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duranno on 2017. 8. 3..
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    private static final List<Fragment> listFragment = new ArrayList<>();
    private static final List<String> mFragmentTitles = new ArrayList<>();

    public TabPagerAdapter(FragmentManager fm){
        super(fm);

    }

    public void addFragment(String title, Fragment fragment){
        listFragment.add(fragment);
        mFragmentTitles.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
