package com.example.navtrial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class ads1Fragment extends Fragment {

    private SmartTabLayout tabLayout;
   public ads1Fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ads_fragment,container,false);
        tabLayout = view.findViewById(R.id.ads_tab1);



        final ViewPager viewPager = view.findViewById(R.id.ads_pager);
        setupViewPager(viewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getFragmentManager(),3);
        adapter.addFrag( "TODAY");
        adapter.addFrag( "LATEST");
        adapter.addFrag( "TYPE");

        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }

}
