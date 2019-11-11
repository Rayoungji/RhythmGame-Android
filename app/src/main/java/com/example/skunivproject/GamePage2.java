package com.example.skunivproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



//게임 실행화면에 대한 메인 스레드
public class GamePage2 extends AppCompatActivity {

    MediaPlayer mp;
    ImageView note1,note2,note3,note4;
    Animation anim;

    ProgressHandler progressHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page2);

        Button btn=(Button)findViewById(R.id.exit);
        note1=(ImageView)findViewById(R.id.note1);
        note2=(ImageView)findViewById(R.id.note2);
        note3=(ImageView)findViewById(R.id.note3);
        note4=(ImageView)findViewById(R.id.note4);
        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);

        progressHandler=new ProgressHandler();
        Runnable runnable=new Runnable();
        Runnable1 runnable1=new Runnable1();
        Runnable2 runnable2=new Runnable2();
        Runnable3 runnable3=new Runnable3();
        //스레드 설정
        Thread thread=new Thread(runnable);
        thread.setDaemon(true);
        Thread thread1=new Thread(runnable1);
        thread1.setDaemon(true);
        Thread thread2=new Thread(runnable2);
        thread2.setDaemon(true);
        Thread thread3=new Thread(runnable3);
        thread3.setDaemon(true);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();


        //인텐트로 음악제목 가져오기
        Intent intent=getIntent();
        int img=intent.getIntExtra("img",1);
        String imageName= intent.getStringExtra("imgTitle");
        String a="wish you were gay",b="mine",c="paris";
        String d="holiday", e="itzy", f="snapping";

        //가져온 제목에 맞는 음악 재생하기
        if(a.equals(imageName)) {
            mp= MediaPlayer.create(
                getApplicationContext(), R.raw.wishyouweregay);
            mp.start();

        }

        if(b.equals(imageName))
        { mp= MediaPlayer.create(
                getApplicationContext(),
                R.raw.mine);
            mp.start();}

        if(c.equals(imageName))
        { mp= MediaPlayer.create(
                getApplicationContext(),
                R.raw.paris);
            mp.start();}

        if(d.equals(imageName)) {
            mp= MediaPlayer.create(
                    getApplicationContext(), R.raw.holiday);
            mp.start();
        }

        if(e.equals(imageName))
        { mp= MediaPlayer.create(
                getApplicationContext(),
                R.raw.itzy);
            mp.start();}

        if(f.equals(imageName))
        { mp= MediaPlayer.create(
                getApplicationContext(),
                R.raw.snapping);
            mp.start();}

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                AlertDialog.Builder exit=new AlertDialog.Builder(GamePage2.this);
                exit.setTitle(">>게임을 종료하시겠습니까?<<");
                exit.setMessage("게임을 종료하시면 지금까지의 기록은 사라지게됩니다");
                exit.setPositiveButton("종료하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent finish=new Intent(getApplicationContext(),SecondMain.class);
                        startActivity(finish);
                    }
                });
                exit.show();
            }
        });

    }
    class ProgressHandler extends Handler {

        //받은 메세지를 처리해주는 메소드
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 0:
                    note1.startAnimation(anim);


                case 1:
                    note2.startAnimation(anim);


                case 2:
                    note3.startAnimation(anim);


                case 3:
                    note4.startAnimation(anim);


            }
        }
    }

    class Runnable implements java.lang.Runnable{

        @Override
        public void run() {
            Looper.prepare(); //루퍼만들기

            while(true){
                //sendMessage와 같은 개념
                progressHandler.sendEmptyMessage(0);

                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Runnable1 implements java.lang.Runnable{

        @Override
        public void run() {
            Looper.prepare(); //루퍼만들기

            while(true){
                //sendMessage와 같은 개념
                progressHandler.sendEmptyMessage(1);

                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Runnable2 implements java.lang.Runnable{

        @Override
        public void run() {
            Looper.prepare(); //루퍼만들기

            while(true){
                //sendMessage와 같은 개념
                progressHandler.sendEmptyMessage(2);

                try{
                    Thread.sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Runnable3 implements java.lang.Runnable{

        @Override
        public void run() {
            Looper.prepare(); //루퍼만들기

            while(true){
                //sendMessage와 같은 개념
                progressHandler.sendEmptyMessage(3);

                try{
                    Thread.sleep(6000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}




