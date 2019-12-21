package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Login, SignUp,HowTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=(Button)findViewById(R.id.Login);
        SignUp=(Button)findViewById(R.id.SignUp);
        HowTo=(Button)findViewById(R.id.HowTo);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login=new Intent(getApplicationContext(), Login.class);
                startActivity(Login);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp=new Intent(getApplicationContext(),SignUp.class);
                startActivity(SignUp);
            }
        });

        HowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder howto= new AlertDialog.Builder(MainActivity.this);
                howto.setTitle(">>게임 소개<<");
                howto.setMessage(
                        "이 게임은 플레이어가 리듬에나 음악에 맞춰서 동작을 취하는 게임이다." +
                                "세갈래의 길이 있고 여러 노트들이 리듬에 맞춰 무작위로 떨어지며" +
                                "플레이어는 노트가 판정선 사이에 위치하였을 때 노트를 클릭하여 점수를 얻게된다."
                );
                 //howto.setIcon();
                howto.setPositiveButton("돌아가기",null);
                howto.show();
            }
        });
    }
}
