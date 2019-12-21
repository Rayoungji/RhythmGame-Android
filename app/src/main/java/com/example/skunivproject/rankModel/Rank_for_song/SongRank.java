package com.example.skunivproject.rankModel.Rank_for_song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankListDto;
import com.example.skunivproject.R;
import com.example.skunivproject.Retrofit.BuildRetrofit;
import com.example.skunivproject.rankModel.RankListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongRank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_songrank);

        final RankListAdapter adapter=new RankListAdapter();

        final ListView listView=(ListView)findViewById(R.id.Rank_wishyouweregay);
        final TextView songTitle=(TextView)findViewById(R.id.songTitle);

        Intent intent=getIntent();
        final String title=intent.getStringExtra("songTitle");

        songTitle.setText(title);

                Call<List<RankListDto>> response= BuildRetrofit.getInstance().getRetrofitInterface().getRank(title);
                response.enqueue(new Callback<List<RankListDto>>() {
                    @Override
                    public void onResponse(Call<List<RankListDto>> call, Response<List<RankListDto>> response) {
                        List<RankListDto> resource=response.body();  //랭킹 리스트 가져오기
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
