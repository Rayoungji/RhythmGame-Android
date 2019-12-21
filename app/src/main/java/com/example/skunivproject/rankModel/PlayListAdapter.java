package com.example.skunivproject.rankModel;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skunivproject.R;
import com.example.skunivproject.rankModel.Rank_for_song.SongRank;

import java.util.ArrayList;

public class PlayListAdapter extends BaseAdapter {

    private ArrayList<PlayListItem> playListItems=new ArrayList<>();
    private Button btn;

    @Override
    public int getCount() {
        return playListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return playListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final int pos=position;
        final Context context = parent.getContext();

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.playlistitem,parent,false);
        }


        final ImageView songImage=(ImageView)convertView.findViewById(R.id.Image);
        final TextView songTitle=(TextView)convertView.findViewById(R.id.title);

        btn = (Button)convertView.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<playListItems.size(); i++){
                    if(pos==i){

                        Intent RankPage=new Intent(context.getApplicationContext(), SongRank.class);
                        RankPage.putExtra("songTitle",playListItems.get(pos).getTitle());
                        context.startActivity(RankPage);

                     }
                }
            }
        });

        final PlayListItem playListItem=playListItems.get(position);

        songImage.setImageDrawable(playListItem.getSongImage());
        songTitle.setText(playListItem.getTitle());

        return convertView;
    }

    public void addItem(Drawable songImage, String songTitle){
        PlayListItem item=new PlayListItem();
        item.setSongImage(songImage);
        item.setTitle(songTitle);
        playListItems.add(item);
    }
}
