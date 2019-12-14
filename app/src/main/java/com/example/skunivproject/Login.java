package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.skunivproject.Controller.UserController;
import com.example.skunivproject.Domain.Dto.Dto.User.LoginDto;

public class Login extends AppCompatActivity {

    EditText ID,PW;
    Button startBtn;
    private UserController userController;
    private LoginDto loginDto;
    public static String loginCheck;
    private SharedPreferences userInfo;
    private SharedPreferences.Editor loginEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ID=(EditText)findViewById(R.id.ID);
        PW=(EditText)findViewById(R.id.PW);
        startBtn=(Button)findViewById(R.id.Login);
        userController = new UserController(getApplicationContext());
        //UserInformation 파일 만들기
        userInfo=getSharedPreferences("UserInforamtion", Activity.MODE_PRIVATE);
        loginEditor=userInfo.edit();


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginDto=new LoginDto(ID.getText().toString(),PW.getText().toString());
                userController.login(loginDto);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(loginCheck.equals("loging success")){

                            loginEditor.putString("loginid",ID.getText().toString());
                            loginEditor.commit();
                            AlertDialog.Builder Start=new AlertDialog.Builder(Login.this);
                            Start.setMessage("로그인에 성공하셨습니다. 게임 화면으로 이동을 위해 버튼을 클릭해주세요");
                            Start.setPositiveButton("게임 화면 이동하기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent SecondMain=new Intent(getApplicationContext(), SecondMain.class);
                                    startActivity(SecondMain);
                                }
                            });
                            Start.show();
                        }else{
                            Toast.makeText(Login.this,"로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                },2000);

            }
        });

    }
}
