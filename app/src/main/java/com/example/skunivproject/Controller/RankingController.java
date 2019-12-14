package com.example.skunivproject.Controller;

import android.content.Context;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankDto;
import com.example.skunivproject.Retrofit.BuildRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingController {

    Context context; //어떤 클래스에서 실행될것인지 정의해주는 부분

    public RankingController(Context context){
        this.context=context;
    }

    public void recordScore(RankDto rankDto){
        Call<Void> response= BuildRetrofit.getInstance().getRetrofitInterface().recordScore(rankDto);
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
