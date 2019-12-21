package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skunivproject.Controller.RankingController;
import com.example.skunivproject.Domain.Dto.Dto.Dto.Ranking.RankDto;
import com.example.skunivproject.gameModel.Beat;
import com.example.skunivproject.gameModel.Judge;
import com.example.skunivproject.gameModel.RythmTimerTask;
import com.example.skunivproject.rankModel.Rank_for_song.SongRank;

import java.util.Timer;

public class GamePage extends AppCompatActivity {

    MediaPlayer mp;
    Button exit,start,finish;
    ImageView note1,note2,note3,note4,note5,note6,note7,note8,note9,note10,note11,note12,note13,note14,note15,note16,note17,note18,note19,note20,note21;
    ImageView touch1,touch2,touch3,judgeLine,judgeLine2;
    TextView text;
    private SharedPreferences userInfo;
    private SharedPreferences.Editor loginEditor;
    private String loginId;
    private RankDto rankDto;
    private RankingController rankingController;

    //이미지뷰 배열, 이미지 아이디 배열 선언
    ImageView[] img_array=new ImageView[21];
    int[] noteID={R.id.note1,R.id.note2,R.id.note3,R.id.note4,R.id.note5,R.id.note6,R.id.note7,R.id.note8,R.id.note9,R.id.note10,
            R.id.note11,R.id.note12,R.id.note13,R.id.note14,R.id.note15,R.id.note16,R.id.note17,R.id.note18,R.id.note19,R.id.note20,R.id.note21};

    private Timer timer;

    int counter=0;  //점수확인용

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        exit=(Button)findViewById(R.id.exit);
        start=(Button)findViewById(R.id.start);
        finish=(Button)findViewById(R.id.finish);

        userInfo=getSharedPreferences("UserInforamtion", Activity.MODE_PRIVATE);
        loginEditor=userInfo.edit();
        rankingController=new RankingController(getApplicationContext());

        //노트들 선언하기
        note1=(ImageView)findViewById(R.id.note1);
        note2=(ImageView)findViewById(R.id.note2);
        note3=(ImageView)findViewById(R.id.note3);
        note4=(ImageView)findViewById(R.id.note4);
        note5=(ImageView)findViewById(R.id.note5);
        note6=(ImageView)findViewById(R.id.note6);
        note7=(ImageView)findViewById(R.id.note7);
        note8=(ImageView)findViewById(R.id.note8);
        note9=(ImageView)findViewById(R.id.note9);
        note10 =(ImageView)findViewById(R.id.note10);
        note11=(ImageView)findViewById(R.id.note11);
        note12=(ImageView)findViewById(R.id.note12);
        note13=(ImageView)findViewById(R.id.note13);
        note14=(ImageView)findViewById(R.id.note14);
        note15=(ImageView)findViewById(R.id.note15);
        note16=(ImageView)findViewById(R.id.note16);
        note17=(ImageView)findViewById(R.id.note17);
        note18=(ImageView)findViewById(R.id.note18);
        note19=(ImageView)findViewById(R.id.note19);
        note20=(ImageView)findViewById(R.id.note20);
        note21=(ImageView)findViewById(R.id.note21);
        touch1=(ImageView)findViewById(R.id.touch1);
        touch2=(ImageView)findViewById(R.id.touch2);
        touch3=(ImageView)findViewById(R.id.touch3);


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
        final String d="holiday", e="itzy",f = "snapping";
        final  String g="frozen", h="frozen2", yy="speechless";

        //userid 잘 가지고 있는지 확인!!
        loginId=userInfo.getString("loginid","");
        Log.d("login id: ", loginId);

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

                if (f.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.snapping);
                    mp.start();
                }

                if (g.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(), R.raw.frozen);
                    mp.start();
                }

                if (h.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.fronze2);
                    mp.start();
                }

                if (yy.equals(imageName)) {
                    mp = MediaPlayer.create(
                            getApplicationContext(),
                            R.raw.speechless);
                    mp.start();
                }

                //게임에서 재생될 비트 찍는 부분
                final Beat[] beats = {
                        new Beat(0000, 0),
                        new Beat(1200, 1),
                        new Beat(2200, 2),
                        new Beat(3200, 3),
                        new Beat(5500, 7),
                        new Beat(7800, 6),
                        new Beat(9800, 5),
                        new Beat(10800, 4),
                        new Beat(12000, 8),
                        new Beat(18000,9),
                        new Beat(13000, 10),
                        new Beat(15000, 11),
                        new Beat(20000, 12),
                        new Beat(21000, 15),
                        new Beat(25000, 13),
                        new Beat(23000, 14),
                        new Beat(23000, 18),
                        new Beat(27000, 17),
                        new Beat(30000, 16),
                        new Beat(31000, 19),
                        new Beat(32000, 20),

                };

                //스레드 실행부분 타이머 클래스의 schedule 메소드를 이용하여 각 비트의 스레드를 실행 시킨다
                for (int i = 0; i < beats.length; i++) {

                    timer = new Timer();
                    timer.schedule(new RythmTimerTask(i, img_array[beats[i].getNoteName()]), beats[i].getTime());

                    final int finalI = i;

                    img_array[beats[i].getNoteName()].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int sc = new Judge().score(img_array[beats[finalI].getNoteName()]);
                            if (sc == 1) {
                                counter++;
                                Toast toast = Toast.makeText(getApplicationContext(), "good!!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP | Gravity.LEFT, 400, 400);
                            toast.show();
                            Log.d("점수는??", "good" + counter);
                            }
                        }

                    });

                    }

                     }

        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();

                if(timer != null){
                    timer.purge();
                }
                rankDto=new RankDto(imageName,counter,loginId);
                rankingController.recordScore(rankDto);
                Log.d("로그인 id :",loginId);
                Log.d("노래제목: ", imageName);
                Log.d("점수 : ", ""+counter);
                AlertDialog.Builder exit=new AlertDialog.Builder(GamePage.this);
                exit.setTitle(">>게임을 끝내시겠습니까?<<");
                exit.setMessage("게임을 끝내시면 현재 스코어가 랭킹됩니다");
                exit.setPositiveButton("끝내고 랭킹 확인하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent done=new Intent(getApplicationContext(), SongRank.class);
                        done.putExtra("songTitle",imageName);
                        startActivity(done);

                    }
                });
                exit.show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
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