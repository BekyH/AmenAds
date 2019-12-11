package com.example.navtrial.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.navtrial.Dao.AdsDao;
import com.example.navtrial.data.adsRoomDatabase;
import com.example.navtrial.data.event;

import java.util.List;

public class AdsRepository {
    private AdsDao adsDao;
    private LiveData<List<event>> allAds;

    public AdsRepository(Application application){
        adsRoomDatabase db = adsRoomDatabase.getDatabase(application);

        adsDao = db.Adsdao();
        allAds = adsDao.getEvents();


    }

   public LiveData<List<event>> getAllAds(){
        return allAds;
    }
   public void insert(event e) {
        adsDao.inset(e);

    }

}
