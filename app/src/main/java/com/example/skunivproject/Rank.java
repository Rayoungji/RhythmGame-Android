package com.example.skunivproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.widget.ListView;
import com.example.skunivproject.rankModel.PlayListAdapter;

public class Rank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        final ListView listView=(ListView)findViewById(R.id.Rank);

        final PlayListAdapter adapter=new PlayListAdapter();

        final int img[] = {
                R.drawable.wishyouweregay,
                R.drawable.mine,
                R.drawable.paris,
                R.drawable.holiday,
                R.drawable.itzy2,
                R.drawable.snapping2,
                R.drawable.frozen,
                R.drawable.frozen2,
                R.drawable.speechless
        };

        final String imgName[]={
                "wish you were gay",
                "mine",
                "paris",
                "holiday",
                "itzy",
                "snapping",
                "frozen",
                "frozen2",
                "speechless"
        };

        for(int i=0; i<img.length; i++){
            adapter.addItem(ContextCompat.getDrawable(this,img[i]),imgName[i]);
        }

        listView.setAdapter(adapter);

    }

}