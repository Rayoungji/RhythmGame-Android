package com.example.skunivproject.gameModel;

import android.widget.ImageView;

public class Judge {

    private ImageView note;

    public int score(ImageView note){

        this.note=note;

        if(note.getY()>=800 && note.getY()<=1400){
            return 1;
        }
        else
            return 0;

    }

}

