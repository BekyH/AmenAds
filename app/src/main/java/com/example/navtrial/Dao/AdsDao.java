package com.example.navtrial.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.navtrial.data.event;

import java.util.List;

@Dao
public interface AdsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void inset(event e);

    @Query("SELECT * FROM ads")
    LiveData<List<event>> getEvents();
}
