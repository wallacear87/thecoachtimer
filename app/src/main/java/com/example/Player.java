package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    @Expose
    private static String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("pictureThumbnail")
    @Expose
    private static String pictureThumbnail;

    public Player(String name, String gender, String pictureThumbnail){
        Player.name = name;
        this.gender = gender;
        Player.pictureThumbnail = pictureThumbnail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        Player.name = name;
    }

    public static String getPictureThumbnail() {
        return pictureThumbnail;
    }

    public void setPictureThumbnail(String pictureThumbnail) {
        Player.pictureThumbnail = pictureThumbnail;
    }
}
