package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.skunivproject.gameModel.Beat;
import com.example.skunivproject.gameModel.RythmTimerTask;

import java.util.Timer;

public class GamePage extends AppCompatActivity {

    MediaPlayer mp;
    Button btn,start;
    ImageView note1,note2,note3,note4,note5,note6,note7,note8;

    //이미지뷰 배열 선언 후 값 넣어주기 ->여러 함수들에서 사용해야 하므로 전역 변수로 선언하기
    ImageView[] img_array=new ImageView[8];
    int[] noteID={R.id.note1,R.id.note2,R.id.note3,R.id.note4,R.id.note5,R.id.note6,R.id.note7,R.id.note8};

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        btn=(Button)findViewById(R.id.exit);
        start=(Button)findViewById(R.id.start);
        note1=(ImageView)findViewById(R.id.note1);
        note2=(ImageView)findViewById(R.id.note2);
        note3=(ImageView)findViewById(R.id.note3);
        note4=(ImageView)findViewById(R.id.note4);
        note5=(ImageView)findViewById(R.id.note5);
        note6=(ImageView)findViewById(R.id.note6);
        note7=(ImageView)findViewById(R.id.note7);
        note8=(ImageView)findViewById(R.id.note8);



        //각 노트에 이미지를 넣어준다
        for(int i=0; i<img_array.length; i++){
            //이미지뷰배열안에 여덟개의 이미지 뷰가 들어있고 각 이미지뷰에 아이디를 연동시켜준다!!(xml에서 선언한 뷰)
            img_array[i]=(ImageView)findViewById(noteID[i]);
            img_array[i].setImageResource(R.drawable.note);
        }

        //인텐트로 음악제목 가져오기
        Intent intent=getIntent();
        int img=intent.getIntExtra("img",1);
        final String imageName= intent.getStringExtra("imgTitle");
        final String a="wish you were gay",b="mine",c="paris";
        final String d="holiday", e="itzy", f="snapping";

        //final Music hi = new Music("name",true);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start.setVisibility(View.GONE);


               // 가져온 제목에 맞는 음악 재생하기
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

                Beat[] beats = {
                        new Beat(1000, 0),
                        new Beat(3000, 1),
                        new Beat(5000, 2),
                        new Beat(7000, 3),
                        new Beat(8000, 7),
                        new Beat(10000, 6),
                        new Beat(12000, 4),
                        new Beat(14000, 5)
                };
               // hi.start();

                for(int i = 0 ; i < beats.length ; i++){
                    timer = new Timer();
                    timer.schedule(new RythmTimerTask(i, img_array[beats[i].getNoteName()]), beats[i].getTime());
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                //hi.close();

                if(timer != null){
                    timer.purge();
                }
                AlertDialog.Builder exit=new AlertDialog.Builder(GamePage.this);
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