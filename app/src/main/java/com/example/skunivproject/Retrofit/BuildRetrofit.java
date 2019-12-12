package com.example.skunivproject.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuildRetrofit {

    private static final BuildRetrofit Instance = new BuildRetrofit();

    public static BuildRetrofit getInstance(){
        return Instance;
    }

    private Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.0.8:8080/")
            //Json 파일을 자바오브젝트로 변환시킬수 있게 GSON을 사용
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitInterface retrofitInterface;

    //레트로핏인터페이스 실행
    public RetrofitInterface getRetrofitInterface(){
        if(retrofitInterface == null){
            retrofitInterface=retrofit.create(RetrofitInterface.class);
        }

        return retrofitInterface;
    }
}
