package com.example.chompopo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);

        //애니메이션 부분
        final ImageView iv = (ImageView)findViewById(R.id.introText);
        Animation animation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.intro_anim);

        iv.startAnimation(animation);

        //인트로 5초 핸들러
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("station","zs");
                startActivity(intent);
                finish();
            }
        },500);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }

}
