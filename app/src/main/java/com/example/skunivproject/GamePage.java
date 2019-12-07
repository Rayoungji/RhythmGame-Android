package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skunivproject.gameModel.Beat;
import com.example.skunivproject.gameModel.Judge;
import com.example.skunivproject.gameModel.RythmTimerTask;

import java.util.Timer;

public class GamePage extends AppCompatActivity {

    MediaPlayer mp;
    Button btn,start;
    ImageView note1,note2,note3,note4,note5,note6,note7,note8;
    ImageView touch1,touch2,touch3,touch4,judgeLine,judgeLine2;
    TextView text,scoretext;

    //이미지뷰 배열, 이미지 아이디 배열 선언
    ImageView[] img_array=new ImageView[8];
    int[] noteID={R.id.note1,R.id.note2,R.id.note3,R.id.note4,R.id.note5,R.id.note6,R.id.note7,R.id.note8};

    private Timer timer;

    int counter=0;
    int j=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        btn=(Button)findViewById(R.id.exit);
        start=(Button)findViewById(R.id.start);

        //노트들 선언하기
        note1=(ImageView)findViewById(R.id.note1);
        note2=(ImageView)findViewById(R.id.note2);
        note3=(ImageView)findViewById(R.id.note3);
        note4=(ImageView)findViewById(R.id.note4);
        note5=(ImageView)findViewById(R.id.note5);
        note6=(ImageView)findViewById(R.id.note6);
        note7=(ImageView)findViewById(R.id.note7);
        note8=(ImageView)findViewById(R.id.note8);
        touch1=(ImageView)findViewById(R.id.touch1);
        touch2=(ImageView)findViewById(R.id.touch2);
        touch3=(ImageView)findViewById(R.id.touch3);
        touch4=(ImageView)findViewById(R.id.touch4);

        text=(TextView)findViewById(R.id.text);
        judgeLine=(ImageView)findViewById(R.id.JugeLine);
        judgeLine2=(ImageView)findViewById(R.id.judgeLine2);

        //각 노트와 이미지뷰 연걸하고 배열에 저장
        for(int i=0; i<img_array.length; i++){
            //아이디 배열에 있는 이미지뷰 아이디 이미지뷰 배열에 넣고 노트 이미지 세팅
            img_array[i]=(ImageView)findViewById(noteID[i]);
            img_array[i].setImageResource(R.drawable.note);
        }

        //인텐트로 음악제목 가져오기
        Intent intent=getIntent();
        int img=intent.getIntExtra("img",1);
        final String imageName= intent.getStringExtra("imgTitle");
        final String a="wish you were gay",b="mine",c="paris";
        final String d="holiday";
        final String e="itzy";
        final String[] f = { "snapping" };


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start.setVisibility(View.GONE);


                // 가져온 제목에 맞는 음악 재생하기
                if (a.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(), R.raw.wishyouweregay);
                    mp.start();
                }

                if (b.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.mine);
                    mp.start();
                }

                if (c.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.paris);
                    mp.start();
                }

                if (d.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(), R.raw.holiday);
                    mp.start();
                }

                if (e.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.itzy);
                    mp.start();
                }

                if (f[0].equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.snapping);
                    mp.start();
                }

                //게임에서 재생될 비트 찍는 부분
                final Beat[] beats = {
                        new Beat(1000, 0),
                        new Beat(3000, 1),
                        new Beat(5000, 2),
                        new Beat(7000, 3),
                        new Beat(8000, 7),
                        new Beat(10000, 6),
                        new Beat(12000, 4),
                        new Beat(14000, 5)
                };

                //스레드 실행부분 타이머 클래스의 schedule 메소드를 이용하여 각 비트의 스레드를 실행 시킨다
                  for (int i = 0; i < beats.length; i++) {
                    timer = new Timer();
                    timer.schedule(new RythmTimerTask(i, img_array[beats[i].getNoteName()]), beats[i].getTime());

                    img_array[beats[i].getNoteName()].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int sc = new Judge().score(img_array[beats[j].getNoteName()]);
                            if (sc == 1) {
                                text.setText("good" + sc);
                            } else {
                                text.setText("bad:" + sc);
                            }

                            j++;
                        }
                    });
                }
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();

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