

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
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

//게임 실행화면에 대한 메인 스레드
public class GamePage2 extends AppCompatActivity {

    MediaPlayer mp;
    ImageView note1,note2,note3,note4;
    Button btn;

    ImageView[] img_array=new ImageView[4];
    int[] imageID={R.id.image1,R.id.image2,R.id.image3,R.id.image4};

    final String TAG_ON="on";
    final String TAG_OFF = "off";
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page2);

        btn=(Button)findViewById(R.id.exit);
        note1=(ImageView)findViewById(R.id.image1);
        note2=(ImageView)findViewById(R.id.image2);
        note3=(ImageView)findViewById(R.id.image3);
        note4=(ImageView)findViewById(R.id.image4);

        for(int i=0; i<img_array.length; i++){
            img_array[i]=(ImageView)findViewById(imageID[i]);
            img_array[i].setImageResource(R.drawable.noteroutchange);
            img_array[i].setTag(TAG_OFF);

            img_array[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(((ImageView)v).getTag().toString().equals(TAG_ON)){
                        Toast.makeText(getApplicationContext()."good",Toast.LENGTH_LONG).show();
                        score++;
                        ((ImageView)v).setImageResource(R.drawable.noteroutchange);
                        v.setTag(TAG_OFF);
                    }else{
                        Toast.makeText(getApplicationContext(),"bad",Toast.LENGTH_LONG).show();
                        if(score<=0){
                            score=0;
                        }
                    }
                }
            });
        }

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

}




