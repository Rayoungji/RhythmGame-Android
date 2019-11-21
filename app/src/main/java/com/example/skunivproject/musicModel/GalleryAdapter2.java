package com.example.skunivproject.musicModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.skunivproject.R;

public class GalleryAdapter2 extends BaseAdapter {

    Context context;
    int layout;
    int img2[];
    LayoutInflater inf;

    public GalleryAdapter2(Context context, int layout, int[] img) {
        this.context = context;
        this.layout = layout;
        this.img2 = img;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 보여줄 데이터의 총 개수 - 꼭 작성해야 함
        return img2.length;
    }

    @Override
    public Object getItem(int position) { // 해당행의 데이터- 안해도 됨
        return null;
    }

    @Override
    public long getItemId(int position) { // 해당행의 유니크한 id - 안해도 됨
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 보여줄 해당행의 row xml 파일의 데이터를 셋팅해서 뷰를 완성하는 작업
        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }

        ImageView iv2 = (ImageView)convertView.findViewById(R.id.imageView2);
        iv2.setImageResource(img2[position]);
        return convertView;
    }
}