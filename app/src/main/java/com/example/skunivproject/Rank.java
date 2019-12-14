package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankListDto;
import com.example.skunivproject.Retrofit.BuildRetrofit;
import com.example.skunivproject.rankModel.RankListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        final ListView listView=(ListView)findViewById(R.id.Rank);
        final RankListAdapter adapter=new RankListAdapter();


        Call<List<RankListDto>> response=BuildRetrofit.getInstance().getRetrofitInterface().getRank("speechless");
        response.enqueue(new Callback<List<RankListDto>>() {
            @Override
            public void onResponse(Call<List<RankListDto>> call, Response<List<RankListDto>> response) {
                List<RankListDto> resource=response.body(); //리스폰스 받아오기

                for(RankListDto re : resource){
                    adapter.addItem(re.getid(),re.getScore());
                }

                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<RankListDto>> call, Throwable t) {

            }
        });

    }

}