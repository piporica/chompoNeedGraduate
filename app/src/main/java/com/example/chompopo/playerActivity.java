package com.example.chompopo;

import android.content.Intent;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class playerActivity extends AppCompatActivity {

    private static final int MSG_START = 100;
    private static final int MSG_REPEAT = 101;
    private static final int MSG_DELETE = 102;

    timeHandler timeHandler = null;
    makenote makenote = null;

    float speed;
    MediaPlayer musicPlayer1;
    MediaPlayer musicPlayer2;
    MediaPlayer musicPlayer3;
    MediaPlayer musicPlayer4;

    int phase;
    ImageView circle1;
    ImageView circle2;
    ImageView circle3;
    ImageView texts;

    AnimationSet set1;
    AnimationSet set2;
    AnimationSet set3;

    playerActivity activity = this;


    @Override
    public void onCreate(Bundle savedIns)
    {
        super.onCreate(savedIns);
        setContentView(R.layout.player_layout);
        circle1 = findViewById(R.id.c1_1);
        circle2 = findViewById(R.id.c1_2);
        circle3 = findViewById(R.id.c1_3);
        phase = 1;
        speed = 1.0f;


        timeHandler = new timeHandler();
        makenote = new makenote();

        blinkanims();
        timeHandler.sendEmptyMessage(MSG_START);
        makenote.sendEmptyMessage(0);

//        movingnotes((FrameLayout) findViewById(R.id.musicscore));


        //테스트용 버튼 리스너
        (findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speed = 1.0f;
                switch (phase)
                {
                    case 1:
                        musicPlayer1.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 2:
                        musicPlayer2.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 3:
                        musicPlayer3.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 4:
                        musicPlayer4.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 5:
                        musicPlayer4.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                }
            }
        });

        (findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speed = 1.5f;
                switch (phase)
                {
                    case 1:
                        musicPlayer1.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 2:
                        musicPlayer2.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 3:
                        musicPlayer3.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 4:
                        musicPlayer4.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                    case 5:
                        musicPlayer4.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        break;
                }
            }
        });


        //미디어 셋
        musicPlayer1 = MediaPlayer.create(this,R.raw.f);
        musicPlayer1.setLooping(true);
        musicPlayer2 = MediaPlayer.create(this,R.raw.fr);
        musicPlayer2.setLooping(true);
        musicPlayer3 = MediaPlayer.create(this,R.raw.fp);
        musicPlayer3.setLooping(true);
        musicPlayer4 = MediaPlayer.create(this,R.raw.frp);
        musicPlayer4.setLooping(true);

        musicPlayer1.start();


        //이미지 터치 시
        texts = (findViewById(R.id.texts));
        texts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase < 6) phase++;
                switch (phase)
                {
                    case 2 :
                        musicPlayer1.stop();
                        musicPlayer1.release();
                        musicPlayer2.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        musicPlayer2.start();
                        timeHandler.sendEmptyMessage(MSG_START);
                        texts.setImageResource(R.drawable.text2);

                        break;
                    case 3 :
                        musicPlayer2.stop();
                        musicPlayer2.release();
                        musicPlayer3.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        musicPlayer3.start();

                        timeHandler.sendEmptyMessage(MSG_START);
                        texts.setImageResource(R.drawable.text3);
                        break;
                    case 4 :
                        musicPlayer3.stop();
                        musicPlayer3.release();
                        musicPlayer4.setPlaybackParams(new PlaybackParams().setSpeed(speed));
                        musicPlayer4.start();
                        timeHandler.sendEmptyMessage(MSG_START);
                        texts.setImageResource(R.drawable.text4);
                        break;
                    case 5 :
                        timeHandler.sendEmptyMessage(MSG_START);
                        texts.setImageResource(R.drawable.text5);
                        break;
                    case 6 :
                        musicPlayer4.stop();
                        musicPlayer4.release();
                        timeHandler.sendEmptyMessage(MSG_DELETE);
                        Intent intent = new Intent(
                                getApplicationContext(),OuttroActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });




    }



    //마커 깜빡임 구현 함수
    public void blinkanims(){

        final AlphaAnimation on1 = new AlphaAnimation(0,1);
        on1.setDuration(333);
        on1.setFillAfter(true);

        final AlphaAnimation on2 = new AlphaAnimation(0,1);
        on2.setStartOffset(333);
        on2.setDuration(666);
        on2.setFillAfter(true);

        final AlphaAnimation on3 = new AlphaAnimation(0,1);
        on3.setStartOffset(667);
        on3.setDuration(1000);
        on3.setFillAfter(true);

        final AlphaAnimation off3 = new AlphaAnimation(1,0);
        off3.setStartOffset(1000);
        off3.setDuration(1333);
        off3.setFillAfter(true);

        final AlphaAnimation off2 = new AlphaAnimation(1,0);
        off2.setStartOffset(1333);
        off2.setDuration(1666);
        off2.setFillAfter(true);

        final AlphaAnimation off1 = new AlphaAnimation(1,0);
        off1.setStartOffset(1334);
        off1.setDuration(2000);
        off1.setFillAfter(true);


        set1 = new AnimationSet(true);
        set1.addAnimation(on1);
        set1.addAnimation(off1);

        set2 = new AnimationSet(true);
        set2.addAnimation(on2);
        set2.addAnimation(off2);

        set3 = new AnimationSet(true);
        set3.addAnimation(on3);
        set3.addAnimation(off3);

    }

    public void invi()
    {
        circle1.clearAnimation();
        circle2.clearAnimation();
        circle3.clearAnimation();
    }
    public void blinkset(int nowPhase)
    {
        switch (nowPhase)
        {
            case 1:
                circle1 = findViewById(R.id.c1_1);
                circle2 = findViewById(R.id.c1_2);
                circle3 = findViewById(R.id.c1_3);
                break;
            case 2:
                circle1 = findViewById(R.id.c2_1);
                circle2 = findViewById(R.id.c2_2);
                circle3 = findViewById(R.id.c2_3);
                break;
            case 3:
                circle1 = findViewById(R.id.c3_1);
                circle2 = findViewById(R.id.c3_2);
                circle3 = findViewById(R.id.c3_3);
                break;
            case 4:
                circle1 = findViewById(R.id.c4_1);
                circle2 = findViewById(R.id.c4_2);
                circle3 = findViewById(R.id.c4_3);
                break;
            case 5:
                circle1 = findViewById(R.id.c5_1);
                circle2 = findViewById(R.id.c5_2);
                circle3 = findViewById(R.id.c5_3);
                break;
        }
    }
    public void blinkrpt()
    {
        circle1.setVisibility(View.VISIBLE);
        circle2.setVisibility(View.VISIBLE);
        circle3.setVisibility(View.VISIBLE);

        circle1.startAnimation(set1);
        circle2.startAnimation(set2);
        circle3.startAnimation(set3);

        circle1.setVisibility(View.INVISIBLE);
        circle2.setVisibility(View.INVISIBLE);
        circle3.setVisibility(View.INVISIBLE);
    }
    //음표움직임 구현 함수

    //if 속도(어떻게 할 건지?)가 얼마 이상이면 duration 바꿀 것

    private class timeHandler extends Handler
    {
        int count = 0;
        @Override
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case MSG_START:
                    count = 0;
                    Log.i("why","아니진짜 개빡치네;");
                    invi();
                    blinkset(phase);
                    this.removeMessages(MSG_REPEAT);
                    this.sendEmptyMessageDelayed(MSG_REPEAT,1000);
                    break;
                case MSG_REPEAT:
                    count++;
                    blinkrpt();
                    Log.i("why","dont stop..."+count);
                    this.sendEmptyMessageDelayed(MSG_REPEAT, 3000);
                    break;
                case MSG_DELETE:
                    this.removeMessages(MSG_REPEAT);
                    break;
            }
        }
    };


    private class makenote extends Handler
    {
        int count = 0;
        @Override
        public void handleMessage(Message msg)
        {
            movingnotes((FrameLayout) findViewById(R.id.musicscore));
            this.sendEmptyMessageDelayed(0,300);
        }
    };


    public void movingnotes(FrameLayout l)
    {
        FrameLayout layout = l;

        //뷰크기 구하기 = 이미지크기일거임
        ImageView score = findViewById(R.id.score);
        float scoreW = score.getDrawable().getIntrinsicWidth();

        //동적추가, Span 랜덤
        //~5*scoreW/32 다섯가지 랜덤
        Random rand = new Random();
        ImageView iv = new ImageView(this);
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        int ranname = rand.nextInt(3);

        switch (ranname)
        {
            case 0 : iv.setImageResource(R.drawable.note1);
            break;
            case 1 : iv.setImageResource(R.drawable.note2);
            break;
            case 2 : iv.setImageResource(R.drawable.note3);
            break;
        }

        iv.setScaleType(ImageView.ScaleType.MATRIX);
        final Matrix matrix = new Matrix();

        int randomint = rand.nextInt(5);
        matrix.postTranslate(scoreW/2, (randomint+1)*scoreW/32);
        iv.setImageMatrix(matrix);

        AlphaAnimation al = new AlphaAnimation(1,0);
        al.setDuration(1100);
        al.setStartOffset(1000);
        al.setInterpolator(new AccelerateInterpolator());

        TranslateAnimation tr = new TranslateAnimation(scoreW*0.5f,-scoreW*0.4f,0,0);
        tr.setDuration(2000);
        tr.setInterpolator(new LinearInterpolator());

        AnimationSet aset = new AnimationSet(true);
        aset.setFillAfter(true);
        aset.addAnimation(al);
        aset.addAnimation(tr);

        iv.startAnimation(aset);
        layout.addView(iv);
    }

    @Override
    public void onPause()
    {
        switch (phase)
        {
            case 1:
                musicPlayer1.stop();
                musicPlayer1.release();
                break;
            case 2:
                musicPlayer2.stop();
                musicPlayer2.release();
            case 3:
                musicPlayer3.stop();
                musicPlayer3.release();
                break;
            case 4:
                musicPlayer4.stop();
                musicPlayer4.release();
                break;
            case 5:
                musicPlayer4.stop();
                musicPlayer4.release();
                break;
        }
        makenote.removeMessages(0);
        super.onPause();

    }

}


