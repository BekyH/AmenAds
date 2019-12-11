package com.example.navtrial.viewDataModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.navtrial.Repository.AdsRepository;
import com.example.navtrial.data.event;

import java.util.List;

public class adsViewmodel extends AndroidViewModel {

    private AdsRepository adsRepository;
    private LiveData<List<event>> mAllAds;

    public adsViewmodel(Application application){
        super(application);

        adsRepository = new AdsRepository(application);
        mAllAds = adsRepository.getAllAds();


    }

    public LiveData<List<event>> getmAllAds(){
        return mAllAds;
    }
    public void insert(event e){
        adsRepository.insert(e);
    }

}
