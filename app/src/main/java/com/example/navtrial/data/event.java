package com.example.navtrial.data;

import androidx.annotation.NonNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "ads")

public class event {

    @PrimaryKey
    @NonNull

    @SerializedName("name")

    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("organizer")
    private String organizer;


    @SerializedName("image")
    private String image;

    @SerializedName("location")
    private String location;

    @SerializedName("eventDate")
    private String eventDate;
    @SerializedName("uploadDate")
    private String uploadDate;
    @SerializedName("category")
    private String category;

    public event(String name,String description,String organizer,String image,String location,String eventDate,String uploadDate,String category){

        this.name = name;
        this.image = image;
        this.description = description;
        this.organizer = organizer;
        this.location = location;
        this.eventDate = eventDate;
        this.uploadDate = uploadDate;
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
    public String getEventDate()
    {
        return this.eventDate;
    }
    public String getDescription(){
        return this.description;
    }

    public String getUploadDate() {
        return this.uploadDate;
    }

    public String getCategory(){
        return this.category;
    }



}
