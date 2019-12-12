package com.example.skunivproject.Domain.Entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("mno")
    private Long mno;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @SerializedName("password")
    private String password;

}
