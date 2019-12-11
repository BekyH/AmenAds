package com.example.navtrial.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.navtrial.Dao.AdsDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {event.class}, version = 1, exportSchema = false)
public abstract class adsRoomDatabase extends RoomDatabase {

    public abstract AdsDao Adsdao();

    private static volatile adsRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static adsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (adsRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            adsRoomDatabase.class, "amenads_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block


            AdsDao dao = INSTANCE.Adsdao();


            event e = new event("denk stota", "mkc", "addis", "sunday", "concert");
            dao.inset(e);

            event ew = new event("denk stota", "mkc", "addis", "sunday", "concert");
            dao.inset(ew);

        }
    };






}
