package com.example.navtrial.webService;

import com.example.navtrial.latestfragment;
import com.example.navtrial.todayfragment;
import com.example.navtrial.typesFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
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
                todayfragment td = new todayfragment();
                return td;
            case 1:
                latestfragment lt = new latestfragment();
                return lt;
            case 2:
                typesFragment tf = new typesFragment();
                return tf;

            default:
                return null;
        }
    }
}
