package com.example;

public class player {

    private static String name;
    private String gender;
    private String pictureThumbnail;

    public player(String name, String gender, String pictureThumbnail){
        this.name = name;
        this.gender = gender;
        this.pictureThumbnail = pictureThumbnail;
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
        this.name = name;
    }

    public static String getPictureThumbnail() {
        return pictureThumbnail;
    }

    public void setPictureThumbnail(String pictureThumbnail) {
        this.pictureThumbnail = pictureThumbnail;
    }
}
