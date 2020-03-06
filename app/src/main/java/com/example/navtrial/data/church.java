package com.example.navtrial.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "churches")
public class church {
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    public String name;

    @SerializedName("phoneno")
    public String phoneno;

    @SerializedName("description")
    public String description;

    @SerializedName("mainchurch")
    public String mainchurch;

    @SerializedName("program")
    public String program;
    @SerializedName("location")
    public String location;
    @SerializedName("BankAccount")
    public String BankAccount;

    public church(String mainchurch,String program, String name,String phoneno,String description,String location,String BankAccount){
        this.name = name;
        this.location = location;
        this.BankAccount = BankAccount;
        this.phoneno = phoneno;
        this.mainchurch = mainchurch;
        this.description = description;
        this.program = program;
    }
    public String getChurchName(){
        return this.name;
    }
    public String getChurchPhoneno(){
        return this.phoneno;

    }
    public String getMainchurch(){
        return this.mainchurch;
    }
    public String getDescription(){
        return this.description;
    }
    public String getProgram(){
        return this.program;
    }
    public String getLocation(){
        return this.location;
    }
    public String getBankAccount(){
        return this.BankAccount;
    }
}
