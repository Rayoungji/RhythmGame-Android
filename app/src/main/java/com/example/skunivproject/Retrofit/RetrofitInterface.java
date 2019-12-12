package com.example.skunivproject.Retrofit;

import com.example.skunivproject.Domain.Dto.SignupDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//http api 인터페이스 구현
public interface RetrofitInterface {

    @POST("/User/SignUp")
    Call<Void> signup(@Body SignupDto signupDto);

}
