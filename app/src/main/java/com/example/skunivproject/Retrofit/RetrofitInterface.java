package com.example.skunivproject.Retrofit;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankDto;
import com.example.skunivproject.Domain.Dto.Dto.User.LoginDto;
import com.example.skunivproject.Domain.Dto.Dto.User.LoginResponseDto;
import com.example.skunivproject.Domain.Dto.Dto.User.SignupDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//http api 인터페이스 구현
public interface RetrofitInterface {

    @POST("/User/SignUp")
    Call<Void> signup(@Body SignupDto signupDto);

    @POST("/User/Login")
    Call<LoginResponseDto> login(@Body LoginDto loginDto);

    @POST("/Ranking/record")
    Call<Void> recordScore(@Body RankDto rankDto);

}
