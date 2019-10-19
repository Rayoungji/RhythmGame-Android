package com.example.skunivproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

//데이터를 get,set하는 메소드들과 아이템뷰를 사용하여 갤러리에 보여지게 하는부분을 구현한다-> 데이터에 접근하고 데이터를 보여준다
public class GalleryAdapter extends BaseAdapter {

    Context context;
    int layout; //musicitem (하이템 하나의 틀)
    int img[];
    LayoutInflater inf;

    //하나의 아이템에 대한 레이아웃 & 보여줄 데이터들의 배열받기
    public GalleryAdapter(Context context, int layout, int[] img) {
        this.context = context; //어플리케이션 정보에 접근하기 위한 인스턴스 (이건 필수변수임!!) or 자신이 어떤 어플리케이션을 나타내는 지 보여주는 id 역할
        this.layout = layout;
        this.img = img;
        //xml에 씌여저 있는 view의 정의를 실제 객체로 만드는 역할 -> layoutxml을 객체로 만들어줌
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    //필수함수!!(데이터의 갯수)
    @Override
    public int getCount() { // 보여줄 데이터의 총 개수 - 꼭 작성해야 함
        return img.length;
    }

    //아이템 가져오기(아이템 추가?)
    @Override
    public Object getItem(int position) { // 해당행의 데이터- 안해도 됨
        return null;
    }

    //아이템 아이디 가져오기
    @Override
    public long getItemId(int position) { // 해당행의 유니크한 id - 안해도 됨
        return 0;
    }

    //갤러리 안에 있는 imageview에 데이터를 공급하는 메소드
    //position은 이미지배열의 순서, converView는 실제 보여지는 부분, parent는 배열에 있는 데이터들?
    //필수 메소드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 보여줄 해당행의 row xml 파일의 데이터를 셋팅해서 뷰를 완성하는 작업
        if (convertView == null) {
            //객체로 만든 viewxmlm을 다시 가져온다
            convertView = inf.inflate(layout, null);
        }
        //imageview에 convertview(layout씌운뷰)를 설정해주고 리턴해준다
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        iv.setImageResource(img[position]);
        return convertView;
    }
}

