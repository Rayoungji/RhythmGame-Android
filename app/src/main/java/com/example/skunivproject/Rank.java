package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.skunivproject.rankModel.RankAdapter;
import com.example.skunivproject.rankModel.RankItemData;

import java.util.ArrayList;

public class Rank extends AppCompatActivity {

    ArrayList<RankItemData> RankList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        this.InitializeRankData();

        ListView RankView=(ListView)findViewById(R.id.Rank);
        final RankAdapter myAdapter=new RankAdapter(this,RankList);

        RankView.setAdapter(myAdapter);

    }


    public void InitializeRankData() {
        RankList = new ArrayList<RankItemData>();

        RankList.add(new RankItemData(1, "Rayoungji", 100));
        RankList.add(new RankItemData(2, "Shinngaun", 70));
        RankList.add(new RankItemData(3, "Hongyoungjun", 50));
    }
}