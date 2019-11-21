package com.example.skunivproject;



import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TabHost;

public class MusicSelect extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_select);

        TabHost th = (TabHost)findViewById(R.id.th);
        //탭호스트 실행시키기
        th.setup();

        //탭그룹에 탭 추가1
        TabHost.TabSpec ts1 = th.newTabSpec("Tab1");
        ts1.setIndicator("POP");
        ts1.setContent(R.id.tab_view1);
        th.addTab(ts1);
        th.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#939FE2"));

        //탭그룹에 탭 추가2
        TabHost.TabSpec ts2 = th.newTabSpec("Tab2");
        ts2.setIndicator("K-POP");
        ts2.setContent(R.id.tab_view2);
        th.addTab(ts2);
        th.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#CE85DB"));

        //탭그룹에 탭 추가3
        TabHost.TabSpec ts3 = th.newTabSpec("Tab3");
        ts3.setIndicator("CLASSIC");
        ts3.setContent(R.id.tab_view3);
        th.addTab(ts3);
        th.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#7149BB"));

        //탭호스트 실행하기
        th.setCurrentTab(0);

        //대량의 데이터들 (갤러리에 보여질 데이터들)
        final int img[] = {
               R.drawable.wishyouweregay,
                R.drawable.mine,
                R.drawable.paris,
                R.drawable.wishyouweregay,
                R.drawable.mine,
                R.drawable.paris,
                R.drawable.wishyouweregay,
                R.drawable.mine,
                R.drawable.paris
        };

        final String imgName[]={
                "wish you were gay",
                "mine",
                "paris",
                "wish you were gay",
                "mine",
                "paris",
                "wish you were gay",
                "mine",
                "paris"
        };

        // 갤러리 어댑터 생성
        GalleryAdapter adapter = new GalleryAdapter(
                getApplicationContext(), // 다른 액티비티 객체들 간의 리소스 공유 혹은 설정에 접근을 위한 메소드
                R.layout.musicitem, //어떤 레이아웃을 사용할 것인지
                img); //어떤 데이터들을 사용할 것인지

        // 갤러리에 어댑터 설정하기(연결하기)
        Gallery g = (Gallery)findViewById(R.id.gallery1);
        g.setAdapter(adapter);

        //xml에 있는 이미지뷰 선언하기
        final ImageView iv = (ImageView)findViewById(R.id.imageView1);

        //갤러리의 사진을 누를때 마다
        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view,
                                       final int position, long id) { // 선택되었을 때 콜백메서드
                iv.setImageResource(img[position]);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gamePage2=new Intent(getApplicationContext(), GamePage.class);
                        gamePage2.putExtra("img",position);
                        gamePage2.putExtra("imgTitle",imgName[position]);
                        startActivity(gamePage2);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final int img2[] = {
                R.drawable.holiday,
                R.drawable.itzy2,
                R.drawable.snapping2,
                R.drawable.holiday,
                R.drawable.itzy2,
                R.drawable.snapping2,
                R.drawable.holiday,
                R.drawable.itzy2,
                R.drawable.snapping2
        };

        final String imgName2[]={
                "holiday",
                "itzy",
                "snapping",
                "holiday",
                "itzy",
                "snapping",
                "holiday",
                "itzy",
                "snapping",
        };

        // 두번째 탭에 대한 어댑터 생성
        GalleryAdapter2 adapter2 = new GalleryAdapter2(
                getApplicationContext(),
                R.layout.musicitem2,
                img2);

        // adapterView
        Gallery g2 = (Gallery)findViewById(R.id.gallery2);
        g2.setAdapter(adapter2);

        final ImageView iv2 = (ImageView)findViewById(R.id.imageView2);

        g2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                      final int position, long id) {
                iv2.setImageResource(img2[position]);
                iv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gamePage2=new Intent(getApplicationContext(), GamePage.class);
                        gamePage2.putExtra("img",position);
                        gamePage2.putExtra("imgTitle",imgName2[position]);
                        startActivity(gamePage2);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    }
