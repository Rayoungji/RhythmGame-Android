package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        Handler hand=new Handler();

        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent GameDone=new Intent(getApplicationContext(),GameDone.class);
                startActivity(GameDone);
                finish();
            }
        },3000);
    }
}
