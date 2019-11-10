package com.example.chompopo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OuttroActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outtro_layout);

        outtroAnim();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },5000);
    }

    public void outtroAnim() {

        //애니메이션 정의

        final AlphaAnimation anim = new AlphaAnimation(0, 1);
        anim.setDuration(1000);
        anim.setFillAfter(true);

        final AlphaAnimation anim2 = new AlphaAnimation(0, 1);
        anim2.setDuration(1500);
        anim2.setStartOffset(500);
        anim2.setFillAfter(true);

        final AlphaAnimation anim3 = new AlphaAnimation(0, 1);
        anim3.setStartOffset(1000);
        anim3.setDuration(2000);
        anim3.setFillAfter(true);

        final AlphaAnimation anim4 = new AlphaAnimation(0, 1);
        anim4.setStartOffset(1500);
        anim4.setDuration(2500);
        anim4.setFillAfter(true);

        //차례로 실행

        final ImageView iv1 = (ImageView)findViewById(R.id.img1);
        final ImageView iv2 = (ImageView)findViewById(R.id.img2);
        final ImageView iv3 = (ImageView)findViewById(R.id.img3);
        final ImageView iv4 = (ImageView)findViewById(R.id.img4);

        iv1.startAnimation(anim);

        iv2.startAnimation(anim2);

        iv3.startAnimation(anim3);

        iv4.startAnimation(anim4);

    }
}
