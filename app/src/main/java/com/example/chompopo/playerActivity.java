package com.example.chompopo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class playerActivity extends AppCompatActivity {

    MediaPlayer musicPlayer;
    int phase;

    @Override
    public void onCreate(Bundle savedIns)
    {
        super.onCreate(savedIns);
        setContentView(R.layout.player_layout);

        phase = 1;


    }

    //마커 깜빡임 구현 함수
    public void blinkCircle(final ImageView iv){

        final AlphaAnimation on1 = new AlphaAnimation(0,1);
        on1.setDuration(333);
        on1.setFillAfter(true);

        final AlphaAnimation off1 = new AlphaAnimation(1,0);
        off1.setDuration(333);
        off1.setFillAfter(true);

        final AlphaAnimation on2 = new AlphaAnimation(0,1);
        on2.setDuration(333);
        on2.setFillAfter(true);

        final AlphaAnimation off2 = new AlphaAnimation(1,0);
        off2.setDuration(333);
        off2.setFillAfter(true);

        final AlphaAnimation on3 = new AlphaAnimation(0,1);
        on3.setDuration(333);
        on3.setFillAfter(true);

        final AlphaAnimation off3 = new AlphaAnimation(1,0);
        off3.setDuration(333);
        off3.setFillAfter(true);

    }

    //음표움직임 구현 함수

    //if 속도(어떻게 할 건지?)가 얼마 이상이면 duration 바꿀 것

}
