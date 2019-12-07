package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameDone extends AppCompatActivity {

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_done);

        score=(TextView)findViewById(R.id.score);

        Intent intent=getIntent();
        int count=intent.getIntExtra("score",1);

        score.setText(""+count);

    }
}
