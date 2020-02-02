package com.example.navtrial;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int NumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {

        super(fm);
        this.NumOfTabs = NumOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                alltabfragment tab1 = new alltabfragment();
                return tab1;
            case 1:
                todaytabfragment tab2 = new todaytabfragment();
                return tab2;
            case 2:
                latesttabfragment tab3 = new latesttabfragment();
                return tab3;
            case 3:
                typetabfragment tab4 = new typetabfragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
