package com.example.navtrial.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "ads")

public class event {

    @PrimaryKey
    @NonNull

    @SerializedName("name")

    private String name;

    @SerializedName("organizer")
    private String organizer;
    @SerializedName("image")
    private String image;

    @SerializedName("location")
    private String location;

    @SerializedName("date")
    private String date;

    @SerializedName("category")
    private String category;

    public event(String name,String organizer,String image,String location,String date,String category){

        this.name = name;
        this.image = image;
        this.organizer = organizer;
        this.location = location;
        this.date = date;
        this.category = category;

    }
    public String getImage(){
        return this.image;
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
