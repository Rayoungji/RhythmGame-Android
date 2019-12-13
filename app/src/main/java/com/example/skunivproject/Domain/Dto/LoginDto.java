package com.example.skunivproject.Domain.Dto;

public class LoginDto {

    private String id;
    private String password;

    public LoginDto(String id, String password){

        this.id=id;
        this.password=password;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

}
