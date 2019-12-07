package com.example.skunivproject.gameModel;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;


import java.util.TimerTask;

public class RythmTimerTask extends TimerTask {
    int index;
    ImageView img;
    boolean proceed=true;

    public RythmTimerTask(int index, ImageView img){
        this.index=index;
        this.img = img;

    }

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
                    Message msg1 = new Message();
                    msg1.arg1 = index;
                    NoteHandler.sendMessage(msg1);
                    Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
