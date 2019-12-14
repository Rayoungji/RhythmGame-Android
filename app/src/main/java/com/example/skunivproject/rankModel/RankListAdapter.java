package com.example.skunivproject.rankModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.skunivproject.R;

import java.util.ArrayList;


public class RankListAdapter extends BaseAdapter {

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<RankItemData> rankItemDataArrayList=new ArrayList<RankItemData>();

    //Adapter에 사용되는 데이터의 개수 리턴
    @Override
    public int getCount() {
        return rankItemDataArrayList.size();
    }

    //BaseAdapter 필수함수
    @Override
    public Object getItem(int position) {
        return null;
    }

    //BaseAdapter 필수함수
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos=position;
        final Context context=parent.getContext();

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.rankitem,parent,false);
        }

        final TextView PlayerId=(TextView)convertView.findViewById(R.id.PlayerId);
        final TextView Score=(TextView)convertView.findViewById(R.id.Score);

        final RankItemData rankItemData=rankItemDataArrayList.get(position);

        PlayerId.setText(rankItemData.getPlayerId());
        Score.setText(Integer.toString(rankItemData.getScore()));

        return convertView;
    }

    public void addItem(String id, int score){
        RankItemData item=new RankItemData();
        item.setPlayerId(id);
        item.setScore(score);
        rankItemDataArrayList.add(item);
    }
}