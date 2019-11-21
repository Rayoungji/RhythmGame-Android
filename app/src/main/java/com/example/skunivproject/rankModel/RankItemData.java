package com.example.skunivproject.rankModel;

public class RankItemData {
    private int RankNum,Score;
    private String PlayerId;

    public RankItemData(int RankNum, String PlayerId, int Score){
        this.RankNum=RankNum;
        this.PlayerId=PlayerId;
        this.Score=Score;
    }

    public int getRankNum(){
        return this.RankNum;
    }

    public String getPlayerId(){
        return this.PlayerId;
    }

    public int getScore(){
        return this.Score;
    }

}
