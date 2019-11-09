package com.example.chompopo;

import android.os.Handler;
import android.widget.ImageView;

public class playerActivity {

    //마커 깜빡임 구현 함수
    public void blinkCircle(final ImageView iv){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            int i = 1;
            int timer;
            @Override
            public void run() {
                if(i<0)
                {

                }

            }
        });

    }

    //음표움직임 구현 함수

    //if 속도(어떻게 할 건지?)가 얼마 이상이면 duration 바꿀 것

}
