package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    @Expose
    private static Playername Playername;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("pictureThumbnail")
    @Expose
    private static String pictureThumbnail;

    public Player(Playername name, String gender, String pictureThumbnail){
        Playername = name;
        this.gender = gender;
        Player.pictureThumbnail = pictureThumbnail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static Playername getName() {
        return Playername;
    }

    public void setName(Playername name) {
        Playername = name;
    }

    public static String getPictureThumbnail() {
        return pictureThumbnail;
    }

    public void setPictureThumbnail(String pictureThumbnail) {
        Player.pictureThumbnail = pictureThumbnail;
    }
}
