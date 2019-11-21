package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Practice extends AppCompatActivity {
    Button start,stop;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        final Music a=new Music("music",true);

        start=(Button)findViewById(R.id.start);
      start.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              a.start();
          }
      });

      stop=(Button)findViewById(R.id.stop);
      stop.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              a.close();
          }
      });


      text=(EditText)findViewById(R.id.text);
      int i=5000;
      if(i==a.getTime())
        text.setText(a.getTime());
    }

class Music extends Thread{
    private boolean isLoop;
    MediaPlayer mp;

    public Music(String name, boolean isLoop){
        this.isLoop=isLoop;
    }

    public int getTime(){
        if(mp==null){return 0;}
        else{return mp.getCurrentPosition();}
    }

    public void close(){
        isLoop=false;
        mp.stop();
        this.interrupt();
    }

    @Override
    public void run() {
        super.run();
        try {
                mp= MediaPlayer.create(
                        getApplicationContext(), R.raw.wishyouweregay);
                mp.start();

        }catch (Exception e){}
    }
}
}
