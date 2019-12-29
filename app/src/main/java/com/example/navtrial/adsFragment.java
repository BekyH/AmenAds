package com.example.navtrial;

import android.app.ProgressDialog;
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
import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

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
    Toolbar toolbar;
    SmartTabLayout tabLayout;
    public adsFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment, container, false);
        tabLayout =  view.findViewById(R.id.ads_tab1);


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


    public void generateDatalist(List<event>eventList){
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
        adsRecyclerAdapter = new adsAdapter(getContext(), eventList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adsRecyclerView.setAdapter(adsRecyclerAdapter);


    }












}
