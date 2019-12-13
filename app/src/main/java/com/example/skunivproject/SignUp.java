package com.example.skunivproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.skunivproject.Controller.UserController;
import com.example.skunivproject.Domain.Dto.SignupDto;

public class SignUp extends AppCompatActivity {

    EditText Name,ID,PW;
    Button Login;
    private SignupDto signupDto;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name=(EditText)findViewById(R.id.SignUp_Name);
        ID=(EditText)findViewById(R.id.SignUp_ID);
        PW=(EditText)findViewById(R.id.SignUp_PW);
        Login=(Button)findViewById(R.id.SignUp);
        userController=new UserController(getApplicationContext());

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //아이디 중복인 경우 & 아이디가 있는 경우 & 셋중 하나라도 널값인 경우 ->각각 오류메세지 넘겨주기

                signupDto=new SignupDto(Name.getText().toString(),ID.getText().toString(),PW.getText().toString());
                userController.signup(signupDto);

                    AlertDialog.Builder Login=new AlertDialog.Builder(SignUp.this);

                    Login.setMessage("회원가입이 성공적으로 이루어졌습니다. 로그인을 위해 버튼을 클릭해주세요");
                    Login.setPositiveButton("로그인하기",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent Login=new Intent(getApplicationContext(),Login.class);
                                    startActivity(Login);
                                }
                            });
                    Login.show();
                }
        });
    }
}
