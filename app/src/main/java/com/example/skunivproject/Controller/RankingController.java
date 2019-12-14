package com.example.skunivproject.Controller;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankDto;
import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankListDto;
import com.example.skunivproject.Retrofit.BuildRetrofit;
import com.example.skunivproject.rankModel.RankItemData;

import java.util.ArrayList;
import java.util.List;

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

//    public void getRank(String song){
//        Call <List<RankListDto>> response=BuildRetrofit.getInstance().getRetrofitInterface().getRank(song);
//        response.enqueue(new Callback<List<RankListDto>>() {
//            @Override
//            public void onResponse(Call<List<RankListDto>> call, Response<List<RankListDto>> response) {
//                List<RankListDto> resource=response.body();  //리스폰스 받아오기
//                ArrayList<RankItemData> array=new ArrayList<>();
//                for(RankListDto re: resource){
//                    array.add(new RankItemData(re.getid(),re.getScore()));
//                }
//                ArrayAdapter<RankListDto> adapter=new ArrayAdapter<>()
//            }
//
//            @Override
//            public void onFailure(Call<List<RankListDto>> call, Throwable t) {
//
//            }
//        });
//    }
}
