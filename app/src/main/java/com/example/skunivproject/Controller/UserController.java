package com.example.skunivproject.Controller;

import android.content.Context;

import com.example.skunivproject.Domain.Dto.SignupDto;
import com.example.skunivproject.Retrofit.BuildRetrofit;
import com.example.skunivproject.Retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class UserController {

    Context context;

    public UserController(Context context){
        this.context=context;
    }

    public void singup(SignupDto signupDto){
        Call<Void> response=BuildRetrofit.getInstance().getRetrofitInterface().signup(signupDto);
        response.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
