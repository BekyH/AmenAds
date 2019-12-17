package com.example.navtrial.webService;

import com.example.navtrial.data.event;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetAdsService {
    @GET("ads")
    Call<List<event>> getAllAds();

}