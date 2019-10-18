package com.example.skunivproject;



import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TabHost;

public class GamePage extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        TabHost th = (TabHost)findViewById(R.id.th);
        th.setup();

        TabHost.TabSpec ts1 = th.newTabSpec("Tab1");
        ts1.setIndicator("POP");
        ts1.setContent(R.id.tab_view1);
        th.addTab(ts1);
        th.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#939FE2"));

        TabHost.TabSpec ts2 = th.newTabSpec("Tab2");
        ts2.setIndicator("K-POP");
        ts2.setContent(R.id.tab_view2);
        th.addTab(ts2);
        th.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#CE85DB"));

        TabHost.TabSpec ts3 = th.newTabSpec("Tab3");
        ts3.setIndicator("CLASSIC");
        ts3.setContent(R.id.tab_view3);
        th.addTab(ts3);
        th.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#7149BB"));

        th.setCurrentTab(0);

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

        // adapter
        GalleryAdapter adapter = new GalleryAdapter(
                getApplicationContext(), // 현재 화면의 제어권자
                R.layout.musicitem,
                img);

        // adapterView
        Gallery g = (Gallery)findViewById(R.id.gallery1);
        g.setAdapter(adapter);

        final ImageView iv = (ImageView)findViewById(R.id.imageView1);

        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) { // 선택되었을 때 콜백메서드
                iv.setImageResource(img[position]);
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

        // adapter
        GalleryAdapter2 adapter2 = new GalleryAdapter2(
                getApplicationContext(), // 현재 화면의 제어권자
                R.layout.musicitem2,
                img2);

        // adapterView
        Gallery g2 = (Gallery)findViewById(R.id.gallery2);
        g2.setAdapter(adapter2);

        final ImageView iv2 = (ImageView)findViewById(R.id.imageView2);

        g2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) { // 선택되었을 때 콜백메서드
                iv2.setImageResource(img2[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    }


