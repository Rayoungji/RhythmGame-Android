package com.example.skunivproject.model;

public class Beat {
    private int time;
    private int noteName;

    public Beat(int time,int noteName){
        this.time=time;
        this.noteName=noteName;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time=time;
    }
    public int getNoteName(){
        return noteName;
    }
    public void setNoteName(int noteName){
        this.noteName=noteName;
    }
}
