package com.example.skunivproject;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;



//게임 실행화면에 대한 메인 스레드
public class practice extends AppCompatActivity {

    MediaPlayer mp;
    ImageView note1,note2, note3, note4;
    RelativeLayout layout;
    Handler handler = new Handler();
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        layout=(RelativeLayout)findViewById(R.id.RelativeLayout);
        note1=new ImageView(getApplicationContext());

        note1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        note1.setImageResource(R.drawable.note);
        note1.setX(95);
        note1.setY(27);
        note1.setScaleType(ImageView.ScaleType.MATRIX);
        layout.addView(note1);

        thread1 thread=new thread1(2);
        thread.start();

        thread1 thread2=new thread1(5);
        thread2.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            thread.threadStop(true);
            thread2.threadStop(true);
    }


    class thread1 extends Thread {
        float y;
        private boolean stop;

        public thread1(float y) {

            this.y = y;
            this.stop= false;

        }

        @Override
        public void run() {
            super.run();

            while(!stop){
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                        note1.startAnimation(anim);
                        //note1.setY(note1.getY()+y);
                    }
                }); }
        }

        public void threadStop(boolean stop){
            this.stop=stop;
        }
    }
}




