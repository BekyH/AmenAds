package com.example.navtrial.webService;

import com.example.navtrial.data.church;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetChurchService {
    @GET("churches")
    Call<List<church>> getChurches();
}
