package com.example.skunivproject.Domain.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ranking implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("song")
    private String song;
    @SerializedName("score")
    private String score;
    @SerializedName("user")
    private User user;

}
