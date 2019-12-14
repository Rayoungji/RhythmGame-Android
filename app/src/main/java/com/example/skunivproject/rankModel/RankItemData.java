package com.example.skunivproject.rankModel;

public class RankItemData {
    private int Score;
    private String PlayerId;


    public String getPlayerId(){
        return this.PlayerId;
    }

    public int getScore(){
        return this.Score;
    }

    public void setPlayerId(String playerId){
        this.PlayerId=playerId;
    }

    public void setScore(int score){
        this.Score=score;
    }

}