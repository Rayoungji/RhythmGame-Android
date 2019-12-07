package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondMain extends AppCompatActivity {

    Button Start,Rank,Logout,practice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        Start=(Button)findViewById(R.id.Start);
        Rank=(Button)findViewById(R.id.Rank);
        Logout=(Button)findViewById(R.id.Logout);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GamePage=new Intent(getApplicationContext(), MusicSelect.class);
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
    }
}
