package com.example.skunivproject;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.TimerTask;

public class RythmTimerTask extends TimerTask {
    int index; //노트 이름
    ImageView img;
    public RythmTimerTask(int index, ImageView img){
        this.index=index;
        this.img = img;
    }
    //그림을 갈색으로 바꿔라!!
    @SuppressLint("HandlerLeak")
    Handler NoteHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            img.setY(img.getY() + 7);
        }
    };
    @Override
    public void run() {
        while (true){
            try{
                Message msg1=new Message();
                msg1.arg1=index;
                NoteHandler.sendMessage(msg1);
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
