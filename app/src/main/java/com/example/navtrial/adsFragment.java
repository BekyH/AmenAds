package com.example.navtrial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;
import com.example.navtrial.webService.TabsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;


public class adsFragment extends Fragment {
    ProgressDialog progressDialog;
    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;


    public adsFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.ads_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("ToDay"));
        tabLayout.addTab(tabLayout.newTab().setText("LATEST"));
        tabLayout.addTab(tabLayout.newTab().setText("TYPE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =(ViewPager)view.findViewById(R.id.ads_pager);
        TabsAdapter tabsAdapter = new TabsAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()){
                    generateDatalist(response.body());
                }
                else {
                    Toast.makeText(getContext(),"response is not successfull",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<event>> call, Throwable t) {
                progressDialog.dismiss();
                if (t instanceof IOException) {

                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(getContext(), "conversion issue! big problems", Toast.LENGTH_SHORT).show();

                }
            }
        });


        return view;
    }


    public void generateDatalist(List<event>eventList){
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
        adsRecyclerAdapter = new adsAdapter(getContext(), eventList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adsRecyclerView.setAdapter(adsRecyclerAdapter);


    }












}
