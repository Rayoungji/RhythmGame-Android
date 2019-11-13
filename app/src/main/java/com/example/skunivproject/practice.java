//package com.example.skunivproject;
//
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//
////게임 실행화면에 대한 메인 스레드
//public class practice extends AppCompatActivity {
//
//    MediaPlayer mp;
//    ImageView note1, note2, note3, note4;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_practice);
//
//        Button btn = (Button) findViewById(R.id.exit);
//        note1 = (ImageView) findViewById(R.id.note1);
//        note2 = (ImageView) findViewById(R.id.note2);
//        note3 = (ImageView) findViewById(R.id.note3);
//        note4 = (ImageView) findViewById(R.id.note4);
//
//        MultiThread thread1 = new MultiThread("note1", note1.getX(), note1.getY());
//        MultiThread thread2 = new MultiThread("note2", note1.getX(), note1.getY());
//        MultiThread thread3 = new MultiThread("note3", note1.getX(), note1.getY());
//        MultiThread thread4 = new MultiThread("note4", note1.getX(), note1.getY());
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//
//        //인텐트로 음악제목 가져오기
//        Intent intent = getIntent();
//        int img = intent.getIntExtra("img", 1);
//        String imageName = intent.getStringExtra("imgTitle");
//        String a = "wish you were gay", b = "mine", c = "paris";
//        String d = "holiday", e = "itzy", f = "snapping";
//
//        //가져온 제목에 맞는 음악 재생하기
//        if (a.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(), R.raw.wishyouweregay);
//            mp.start();
//
//        }
//
//        if (b.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(),
//                    R.raw.mine);
//            mp.start();
//        }
//
//        if (c.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(),
//                    R.raw.paris);
//            mp.start();
//        }
//
//        if (d.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(), R.raw.holiday);
//            mp.start();
//        }
//
//        if (e.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(),
//                    R.raw.itzy);
//            mp.start();
//        }
//
//        if (f.equals(imageName)) {
//            mp = MediaPlayer.create(
//                    getApplicationContext(),
//                    R.raw.snapping);
//            mp.start();
//        }
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp.stop();
//                AlertDialog.Builder exit = new AlertDialog.Builder(GamePage2.this);
//                exit.setTitle(">>게임을 종료하시겠습니까?<<");
//                exit.setMessage("게임을 종료하시면 지금까지의 기록은 사라지게됩니다");
//                exit.setPositiveButton("종료하기", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent finish = new Intent(getApplicationContext(), SecondMain.class);
//                        startActivity(finish);
//                    }
//                });
//                exit.show();
//            }
//        });
//
//    }
//
//    class MultiThread extends Thread {
//        private final String noteName;
//        float x, y;
//
//        public MultiThread(String noteName, float x, float y) {
//            this.x = x;
//            this.y = y;
//            this.noteName = noteName;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                Handler handler = new Handler();
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (noteName.equals("note1")) {
//                            note1.setX(x);
//                            note1.setY(y + 7);
//                        } else if (noteName.equals("note2")) {
//                            note2.setX(x);
//                            note2.setY(y + 5);
//                        } else if (noteName.equals("note3")) {
//                            note3.setX(x);
//                            note3.setY(y + 5);
//                        } else if (noteName.equals("note4")) {
//                            note4.setX(x);
//                            note4.setY(y + 5);
//                        }
//                    }
//                });
//                try {
//                    Thread.sleep(10);
//                } catch (Exception e) {
//                }
//
//            }
//        }
//    }
//}
//
//
//
//
