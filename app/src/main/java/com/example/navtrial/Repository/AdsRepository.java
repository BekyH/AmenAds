package com.example.navtrial.Repository;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

//public class AdsRepository {
//    public ArrayList<event> nevents;
//    public LiveData<List<event>> eventdata;
//    public  List<event> ee;
//    public static AdsRepository instance;
//    public static AdsRepository getInstance(){
//            if(instance==null){
//                instance = new AdsRepository();
//            }
//            return instance;
//    }
//    public LiveData<List<event>> getmAds(){
//
//
//
////        progressDialog = new ProgressDialog(context);
////        progressDialog.setMessage("Loading....");
////        progressDialog.show();
//
//        GetAdsService service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
//      //  Call<LiveData<List<event>>> call = service.getAllAds();
//        call.enqueue(new Callback<LiveData<List<event>>>() {
//            @Override
//            public void onResponse(Call<LiveData<List<event>>> call, retrofit2.Response<LiveData<List<event>>> response) {
//              //  progressDialog.dismiss();
//
//                if(response.isSuccessful()){
//
//                eventdata = response.body();
//               // ee = response.body();
//
//
//
//                }
//                else {
////                    Toast.makeText(context,"response is not successfull",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<LiveData<List<event>>> call, Throwable t) {
//
//            }
//
////            @Override
////            public void onFailure(Call<List<event>> call, Throwable t) {
////               // progressDialog.dismiss();
////                if (t instanceof IOException) {
////
//////                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
////                    // logging probably not necessary
////                }
////                else {
//////                    Toast.makeText(context, "conversion issue! big problems", Toast.LENGTH_SHORT).show();
////
////                }
////            }
//        });
////        Log.d("aa",nevents.toString());
//        return eventdata;
//
//    }
//}
