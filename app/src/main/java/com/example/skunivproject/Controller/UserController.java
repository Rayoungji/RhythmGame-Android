package com.example.skunivproject.Controller;

import android.content.Context;
import android.util.Log;

import com.example.skunivproject.Domain.Dto.LoginDto;
import com.example.skunivproject.Domain.Dto.LoginResponseDto;
import com.example.skunivproject.Domain.Dto.SignupDto;
import com.example.skunivproject.Retrofit.BuildRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.skunivproject.Login.loginCheck;

public class UserController {

    Context context;

    public UserController(Context context){
        this.context=context;
    }

    public void signup(SignupDto signupDto){
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

    public void login(LoginDto loginDto){
        Call <LoginResponseDto> response= BuildRetrofit.getInstance().getRetrofitInterface().login(loginDto);
        response.enqueue(new Callback<LoginResponseDto>() {
            @Override
            public void onResponse(Call<LoginResponseDto> call, Response<LoginResponseDto> response) {
                if(response.isSuccessful()){
                    loginCheck=response.body().getMsg();
                    Log.d("Login check Message: ", loginCheck);
                }else{
                    loginCheck="login fail";
                    Log.d("Login Check Message: ",loginCheck);
                }
            }

            @Override
            public void onFailure(Call<LoginResponseDto> call, Throwable t) {

            }
        });
    }
}
