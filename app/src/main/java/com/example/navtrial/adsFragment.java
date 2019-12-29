package com.example.navtrial;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.navtrial.Repository.AdsRepository;
import com.example.navtrial.data.event;
//import com.example.navtrial.viewModel.adsViewmodel;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;


public class adsFragment extends Fragment    {
    ProgressDialog progressDialog;


    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;
<<<<<<< HEAD
    Toolbar toolbar;
    SmartTabLayout tabLayout;
    public adsFragment() {

    }
=======

>>>>>>> 3b53776d1a4a0839bcca7b3b23e580e84d955e70


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment, container, false);
        tabLayout =  view.findViewById(R.id.ads_tab1);


<<<<<<< HEAD
        final ViewPager viewPager =(ViewPager)view.findViewById(R.id.ads_pager);
        setupViewPager(viewPager);

//




//        progressDialog = new ProgressDialog(getContext());
//        progressDialog.setMessage("Loading....");
//        progressDialog.show();
//        GetAdsService service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
//        Call<List<event>> call = service.getAllAds();
//        call.enqueue(new Callback<List<event>>() {
//            @Override
//            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
//                progressDialog.dismiss();
//
//                if(response.isSuccessful()){
//                    generateDatalist(response.body());
//                }
//                else {
//                    Toast.makeText(getContext(),"response is not successfull",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<event>> call, Throwable t) {
//                progressDialog.dismiss();
//                if (t instanceof IOException) {
//
//                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    // logging probably not necessary
//                }
//                else {
//                    Toast.makeText(getContext(), "conversion issue! big problems", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
=======

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService ads_service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = ads_service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()){
                  //  Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                    generateAdslist(response.body());
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
>>>>>>> 3b53776d1a4a0839bcca7b3b23e580e84d955e70



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



    public void generateAdslist(List<event> eventList){

        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
        adsRecyclerAdapter = new adsAdapter(getContext(), eventList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adsRecyclerView.setAdapter(adsRecyclerAdapter);


    }



}









