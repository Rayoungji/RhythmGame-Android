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
                howto.setMessage("이 게임은 네개의 사각형으로 이루어진 블록들이 무작위로 나타나 바닥과 블록위에 떨어지며" +
                        "이러한 블록을 방향키를 이용하여 회전시켜 수평선의 빈틈을 채우는 게임입니다. \n 수평선이 만들어지게 되면 그 선은 " +
                        "없어지며, 사용자가 블록을 꼭대기까지 가득메워 블록이 더 들어갈 수 없게되면 게임이 끝나게 됩니다.");
                 //howto.setIcon();
                howto.setPositiveButton("돌아가기",null);
                howto.show();
            }
        });
    }
}
