package com.example.navtrial;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class fetchadsdata {
    public  List<event> AllAds;
    ArrayList<event> allad;
    public List<event> getAllAdsFromApi(){

        GetAdsService ads_service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = ads_service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {


                if (response.isSuccessful()) {
                    //  Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                    AllAds = new ArrayList<>();
                    AllAds = response.body();


                } else {

                }

            }

            @Override
            public void onFailure(Call<List<event>> call, Throwable t) {

                if (t instanceof IOException) {


                } else {


                }
            }
        });
        return this.getAllAdsFromApi();
    }


}
