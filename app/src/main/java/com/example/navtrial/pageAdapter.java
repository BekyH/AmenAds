package com.example.navtrial;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

public class pageAdapter extends FragmentStatePagerAdapter {


    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                latestfragment lf = new latestfragment();
                return lf;
            case 1:
                todayfragment tf = new todayfragment();
                return tf;
            case 2:
                typefragment tyf = new typefragment();
                return tyf;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
