package com.example.skunivproject.rankModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.skunivproject.R;

import java.util.ArrayList;

public class RankAdapter extends BaseAdapter {

    Context mContext=null;
    LayoutInflater mLayoutInflater=null;
    ArrayList<RankItemData> Data;

    public  RankAdapter(Context context, ArrayList<RankItemData> data){

        this.mContext=context;
        this.Data=data;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public  int getCount(){
        return Data.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public RankItemData getItem(int position){
        return Data.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        View view=mLayoutInflater.inflate(R.layout.rankitem,null);

        TextView RankNum=(TextView)view.findViewById(R.id.RankNum);
        TextView PlayerId=(TextView)view.findViewById(R.id.PlayerId);
        TextView Score=(TextView)view.findViewById(R.id.Score);

        RankNum.setText(Integer.toString(Data.get(position).getRankNum()));
        PlayerId.setText(Data.get(position).getPlayerId());
        Score.setText(Integer.toString(Data.get(position).getScore()));

        return  view;
    }

}