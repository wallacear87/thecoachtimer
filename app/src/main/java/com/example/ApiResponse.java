package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public class ApiResponse {

    @SerializedName("results")
    @Expose
    private List<Player> results;

    public List<Player> getResults() {
        return results;
    }

    @NonNull
    @Override
    public String toString() {
        return results.toString();
    }
}
