package com.example.skunivproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        RankNum.setText(Data.get(position).getRankNum());
        PlayerId.setText(Data.get(position).getPlayerId());
        Score.setText(Data.get(position).getScore());

        return  view;
    }

}
