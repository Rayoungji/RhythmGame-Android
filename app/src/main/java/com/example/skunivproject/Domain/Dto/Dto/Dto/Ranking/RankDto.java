package com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking;

public class RankDto {

    private String song;
    private int score;
    private String id; //사용자 아이디

    public RankDto(String song, int counter, String loginId) {
        this.song=song;
        this.score=counter;
        this.id=loginId;
    }

    public String getSong(){
        return song;
    }
    public void Setsong(String song){
        this.song=song;
    }
    public int getScore(){
        return score;
    }
    public void SetScore(int score){
        this.score=score;
    }
    public String getId(){
        return id;
    }
    public void SetId(String id){
        this.id=id;
    }
}
