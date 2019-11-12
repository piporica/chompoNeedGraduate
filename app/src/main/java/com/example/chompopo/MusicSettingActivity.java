package com.example.chompopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MusicSettingActivity extends AppCompatActivity {

    String station;
    int music;
    MyApp app;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_music_layout);
        Intent intent = getIntent();
        station = intent.getStringExtra("station");

        app = ((MyApp)this.getApplication());
        music = app.getmusic();

        findViewById(R.id.m_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class);
                intent.putExtra("station", station);
                app.setmusic(music);
                startActivity(intent);
            }
        });

        final ImageButton mu1 = findViewById(R.id.mu1);
        final ImageButton mu2 = findViewById(R.id.mu2);
        final ImageButton mu3 = findViewById(R.id.mu3);
        final ImageButton mu4 = findViewById(R.id.mu4);
        final ImageButton mu5 = findViewById(R.id.mu5);
        final ImageButton mu6 = findViewById(R.id.mu6);
        final ImageButton mu7 = findViewById(R.id.mu7);
        final ImageButton mu8 = findViewById(R.id.mu8);
        final ImageButton mu9 = findViewById(R.id.mu9);


        mu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu1.setAlpha(1f);
                music = 1;
            }
        });

        mu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu2.setAlpha(1f);
                music = 2;
            }
        });
        mu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu3.setAlpha(1f);
                music = 3;
            }
        });
        mu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu4.setAlpha(1f);
                music = 4;
            }
        });
        mu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu5.setAlpha(1f);
                music = 5;
            }
        });
        mu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu6.setAlpha(1f);
                music = 6;
            }
        });
        mu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu7.setAlpha(1f);
                music = 7;
            }
        });
        mu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu8.setAlpha(1f);
                music = 8;
            }
        });
        mu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAll30();
                mu9.setAlpha(1f);
                music = 9;
            }
        });

        //초기설정
        setAll30();
        switch (music)
        {
            case 1: mu1.setAlpha(1f);
            break;

            case 2: mu2.setAlpha(1f);
            break;

            case 3: mu3.setAlpha(1f);
            break;

            case 4: mu4.setAlpha(1f);
            break;

            case 5: mu5.setAlpha(1f);
            break;

            case 6: mu6.setAlpha(1f);
            break;

            case 7: mu7.setAlpha(1f);
            break;

            case 8: mu8.setAlpha(1f);
            break;

            case 9: mu9.setAlpha(1f);
            break;
        }
    }

    void setAll30() {
        ImageButton mu1 = findViewById(R.id.mu1);
        ImageButton mu2 = findViewById(R.id.mu2);
        ImageButton mu3 = findViewById(R.id.mu3);
        ImageButton mu4 = findViewById(R.id.mu4);
        ImageButton mu5 = findViewById(R.id.mu5);
        ImageButton mu6 = findViewById(R.id.mu6);
        ImageButton mu7 = findViewById(R.id.mu7);
        ImageButton mu8 = findViewById(R.id.mu8);
        ImageButton mu9 = findViewById(R.id.mu9);

        mu1.setAlpha(0.3f);
        mu2.setAlpha(0.3f);
        mu3.setAlpha(0.3f);
        mu4.setAlpha(0.3f);
        mu5.setAlpha(0.3f);
        mu6.setAlpha(0.3f);
        mu7.setAlpha(0.3f);
        mu8.setAlpha(0.3f);
        mu9.setAlpha(0.3f);
    }

    @Override
    protected void onPause() {
        super.onPause();
        app.setmusic(music);
    }
}
