package com.example.skunivproject.rankModel;

import android.graphics.drawable.Drawable;

/*랭킹에서 노래리스트데이터 가져오고 세팅하는 부분*/

public class PlayListItem {

    private Drawable songImage;
    private String title;

    public void setSongImage(Drawable songImage){
        this.songImage=songImage;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public Drawable getSongImage(){
        return this.songImage;
    }

    public String getTitle(){
        return this.title;
    }

}
