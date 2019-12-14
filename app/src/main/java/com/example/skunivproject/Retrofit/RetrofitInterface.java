package com.example.skunivproject.Retrofit;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankDto;
import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankListDto;
import com.example.skunivproject.Domain.Dto.Dto.User.LoginDto;
import com.example.skunivproject.Domain.Dto.Dto.User.LoginResponseDto;
import com.example.skunivproject.Domain.Dto.Dto.User.SignupDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//http api 인터페이스 구현
public interface RetrofitInterface {

    @POST("/User/SignUp")
    Call<Void> signup(@Body SignupDto signupDto);

    @POST("/User/Login")
    Call<LoginResponseDto> login(@Body LoginDto loginDto);

    @POST("/Ranking/record")
    Call<Void> recordScore(@Body RankDto rankDto);

    @GET("/Ranking/{song}")
    Call<List<RankListDto>> getRank(@Path("song") String song);

}
