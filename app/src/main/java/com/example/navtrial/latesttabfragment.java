package com.example.navtrial;

import android.app.ProgressDialog;
import java.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

public class latesttabfragment extends Fragment {
    private RecyclerView latestadsRecyclerView;
    ProgressDialog progressDialog;
    private RecyclerView.Adapter latestadsRecyclerAdapter;
    ArrayList<event> latestads;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.latesttabfragment,container,false);
//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                getFragmentManager().popBackStack();
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService ads_service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = ads_service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()){
                    //  Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                    latesteventlist(response.body());

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
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void latesteventlist(List<event> eventList){
        final String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        latestads = new ArrayList<>();
        for(int i = 0;i<eventList.size();i++) {
//            if (!date.equals(eventList.get(i).getEventDate())) {
//                latestads.add(eventList.get(i));
//
//            }
            latestads.add(eventList.get(i));

        }
        Collections.sort(latestads, new Comparator<event>() {
            @Override
            public int compare(event o1, event o2) {
                return o1.getUploadDate().compareTo(date);

            }
        });
        Collections.reverse(latestads);

        latestadsRecyclerView = view.findViewById(R.id.latest_tab_recycler_view);
        latestadsRecyclerAdapter = new todayAdsAdapter(getContext(),latestads);
        latestadsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        latestadsRecyclerView.setAdapter(latestadsRecyclerAdapter);






    }
}
