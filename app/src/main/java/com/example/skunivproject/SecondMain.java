package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondMain extends AppCompatActivity {

    Button Start,Rank,Logout;
    Button practice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        Start=(Button)findViewById(R.id.Start);
        Rank=(Button)findViewById(R.id.Rank);
        Logout=(Button)findViewById(R.id.Logout);

        practice=(Button)findViewById(R.id.practice);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GamePage=new Intent(getApplicationContext(),GamePage.class);
                startActivity(GamePage);
            }
        });

        Rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rank=new Intent(getApplicationContext(),Rank.class);
                startActivity(Rank);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Logout=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Logout);
            }
        });

//        practice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent practice=new Intent(getApplicationContext(),practice.class);
//                startActivity(practice);
//            }
//        });
    }
}
