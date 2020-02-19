package com.example.navtrial;

public class Type {
    public String conference;
    public String worship;
    public String concert;
    public String training;
    public String art;

    public Type(String conference,String concert,String worship,String training,String art){
         this.conference = conference;
         this.concert = concert;
         this.worship = worship;
         this.training = training;
         this.art = art;
    }

    public String getConference() {
        return this.conference;
    }

    public String getConcert() {
        return this.concert;
    }

    public String getWorship() {
        return this.worship;
    }
    public String getTraining(){
        return this.training;
    }
    public String getArt(){
        return this.art;
    }

}
