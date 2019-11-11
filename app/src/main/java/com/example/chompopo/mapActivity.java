package com.example.chompopo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class mapActivity extends AppCompatActivity implements OnTouchListener {
    // These matrices will be used to move and zoom image
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        ImageView map = (ImageView) findViewById(R.id.map);
        map.setOnTouchListener(this);
    }

    //드래그 이동 + 확대 + 가능하다면 더블탭 확대
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //최초이미지위치
        Log.i("o",event.getX()+","+event.getY());
        return false;
    }


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
}

