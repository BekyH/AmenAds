package com.example.navtrial;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public List<String> getmFragmentTitleList() {
        mFragmentTitleList.add("TODAY");
        mFragmentTitleList.add("LATEST");
        mFragmentTitleList.add("TYPE");

        return mFragmentTitleList;
    }

    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                latestfragment lf = new latestfragment();
                return lf;
            case 1:
                todayfragment tf = new todayfragment();
                return tf;
            case 2:
                typesFragment tyf = new typesFragment();
                return tyf;
            default:
                return null;
        }
    }
    public void addFrag(String title) {

        mFragmentTitleList.add(title);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return getmFragmentTitleList().get(position);
    }
}
