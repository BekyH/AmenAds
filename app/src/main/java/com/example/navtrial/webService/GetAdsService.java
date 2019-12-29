package com.example.navtrial.webService;

import androidx.lifecycle.LiveData;

import com.example.navtrial.data.event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAdsService {
    @GET("ads")
    Call<List<event>> getAllAds();

}