package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText ID,PW;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ID=(EditText)findViewById(R.id.ID);
        PW=(EditText)findViewById(R.id.PW);
        startBtn=(Button)findViewById(R.id.Login);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID.getText().toString();
                PW.getText().toString();

                //서버로 받은 아이디&비밀번호 넘겨주기
                //아이디 혹은 비밀번호가 틀렸을 경우 -> 오류메세지 넘겨주기
                //넘겨서 확인 후 리턴값 true&false로 받기

                //만약 리턴값이 true 일 때
                Intent SecondMain=new Intent(getApplicationContext(), SecondMain.class);
                startActivity(SecondMain);

            }
        });

    }
}
