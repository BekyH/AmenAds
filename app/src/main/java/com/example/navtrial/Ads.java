package com.example.navtrial;

public class Ads {
    private String ads_name;
    private String ads_organizer;
    private String ads_date;
    private String ads_location;
    private String ads_category;
    public Ads(String ads_name,String ads_organizer,String ads_date,String ads_location, String ads_category){
        this.ads_name = ads_name;
        this.ads_organizer = ads_organizer;
        this.ads_date = ads_date;
        this.ads_location = ads_location;
        this.ads_category = ads_category;
    }
    public String getAds_name(){
        return ads_name;
    }
    public void setAds_name(String ads_name){
        this.ads_name = ads_name;


    }
    public String getAds_organizer(){
        return ads_organizer;
    }
    public void setAds_organizer(String ads_organizer){
        this.ads_organizer = ads_organizer;


    }
    public String getads_date(){
        return ads_date;
    }
    public void setAds_date(String ads_date){
        this.ads_date = ads_date;
    }
    public String getAds_location(){
        return ads_location;
    }
    public void setAds_location(String ads_location){
        this.ads_location = ads_location;
    }
}
