package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GamePage2 extends AppCompatActivity {

    MediaPlayer mp;
    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page2);

        Button btn=(Button)findViewById(R.id.exit);
        SeekBar sb=(SeekBar)findViewById(R.id.sb);

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
