package com.example.navtrial.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ads")

public class event {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "organizer")
    private String organizer;

    @ColumnInfo(name="location")
    private String location;

    @ColumnInfo(name="date")
    private String date;

    @ColumnInfo(name="category")
    private String category;

    public event(String name,String organizer,String location,String date,String category){
        this.name = name;
        this.organizer = organizer;
        this.location = location;
        this.date = date;
        this.category = category;

    }

    public String getName(){
        return this.name;
    }
    public String getOrganizer(){
        return this.organizer;
    }
    public String getLocation(){
        return this.location;

    }
    public String getDate(){
        return this.date;
    }
    public String getCategory(){
        return this.category;
    }



}
