package com.example.chompopo;

import android.app.Application;

public class MyApp extends Application {

    private int music;

    @Override
    public void onCreate() {
        //전역 변수 초기화
        music = 0;
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setmusic(int state){
        this.music = state;
    }

    public int getmusic(){
        return music;
    }

}
