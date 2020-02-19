package com.example.navtrial.webService;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static Retrofit retrofit;

   // private static final String BASE_URL="http://10.0.2.2:3000/api/";
  private static final String BASE_URL="http://10.6.159.47:3000/api/";
    public static Retrofit getRetrofitInstance(){

        if(retrofit==null){

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();

        }
        return retrofit;
    }




}