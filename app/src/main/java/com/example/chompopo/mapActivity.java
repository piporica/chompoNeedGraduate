package com.example.chompopo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class mapActivity extends AppCompatActivity  {
    // These matrices will be used to move and zoom image

    String station;

    //맵 이미지 매트릭스
    Matrix first = new Matrix();
    Matrix matrix = new Matrix();
    Matrix svmatrix = new Matrix();

    //신금호 저장변수
    PointF nkhMin;
    PointF nkhMax;

    int mapWidth;
    int mapHeight;

    //parent의 넓이/높이
    int dwidth;
    int dheight;

    PointF start = new PointF();    //터치 시작점
    PointF mid = new PointF(); //확대중간위치
    float oldDist = 1f;

    //적용할 상태들
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    static final int OFF = 3;

    int mode = NONE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        ImageView map = findViewById(R.id.map);

        //인텐트 받기
        Intent intent = getIntent();
        station = intent.getStringExtra("station");

        //맵 중앙배치하기
        //맵리얼크기
        mapWidth = map.getDrawable().getIntrinsicWidth();
        mapHeight = map.getDrawable().getIntrinsicHeight();

        //화면크기
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        dwidth = dm.widthPixels;
        dheight = dm.heightPixels;

        first.postTranslate((dwidth/2)-(mapWidth/2), (dheight/2)-(mapHeight/2));

        map.setImageMatrix(first);

        svmatrix.set(first);
        matrix.set(first);
        map.setOnTouchListener(touch);


        ImageButton goback = findViewById(R.id.gobackbtn);
        ImageButton ok = findViewById(R.id.chkbtn);
        ImageButton mapch= findViewById(R.id.map_choice);

        //뒤로가기
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class);
                intent.putExtra("station",station);
                startActivity(intent);
            }
        });

        //ok
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class);
                if(mode == OFF) station = "nkh";
                intent.putExtra("station",station);
                startActivity(intent);
            }
        });

        //다른맵고르기
        mapch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.nkh).setVisibility(View.INVISIBLE);
                findViewById(R.id.map_choice).setVisibility(View.INVISIBLE);
                mode = NONE;
            }
        });

    }

        OnTouchListener touch = new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(mode == OFF) return false;
                ImageView view = (ImageView)v;
                switch (event.getAction() & MotionEvent.ACTION_MASK)
                {

                    //누름
                    case MotionEvent.ACTION_DOWN:
                        start.set(event.getX(),event.getY());
                        mode = DRAG;
                        break;

                    //멀티터치
                    case MotionEvent.ACTION_POINTER_DOWN:
                        oldDist = spacing(event);
                        if(oldDist >10f) //두손가락 인정 최소거리
                        {
                            svmatrix.set(matrix);
                            midPoint(mid,event);
                            mode = ZOOM;
                        }
                        break;

                    case MotionEvent.ACTION_POINTER_UP:
                    {
                        mode = NONE;
                        svmatrix.set(matrix);
                        break;
                    }
                    //뗌
                    case MotionEvent.ACTION_UP:
                        mode = NONE;
                        svmatrix.set(matrix);
                        break;

                    //움직임
                    case MotionEvent.ACTION_MOVE :
                        if(mode == DRAG)
                        {
                            matrix.set(svmatrix);
                            matrix.postTranslate(event.getX()-start.x,event.getY()-start.y);



                        }
                        else if(mode == ZOOM)
                        {
                            float newDist = spacing(event);
                            if(newDist > 10f)
                            {
                                matrix.set(svmatrix);
                                float scale = newDist/oldDist;
                                matrix.postScale(scale,scale,mid.x,mid.y);

                            }
                        }
                        break;
                }

                view.setImageMatrix(matrix);
                checkpoint(event);
                return true;
            }
        };


    /** 두 포인트 사이의 거리 계산 */
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x * x + y * y);
    }

    /** 두 포인트 사이의 중점 계산 */
    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }


    //누른 곳이 지하철역인지 확인
    private int checkpoint(MotionEvent event)
    {
        //신금호 : 931~963 / 391~416
        float[] f1 = new float[9];
        matrix.getValues(f1);
        float realx = (event.getX()-f1[2])/f1[0];
        float realy = (event.getY()-f1[5])/f1[0];

        Log.i("wh","w: "+realx+"y :"+realy);

        if((realx>3759 && realx <3850)&&(realy>1570 && realy<1670))
        {
            mode = NONE;
            findViewById(R.id.nkh).setVisibility(View.VISIBLE);
            findViewById(R.id.map_choice).setVisibility(View.VISIBLE);
            mode = OFF;
        }

        return 1;
    }

}

//신금호-비율로 짜야 정확함
//시간있을 때 지도 밖으로 나가면 돌아오는 함수 짤 것

