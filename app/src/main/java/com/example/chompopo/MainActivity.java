package com.example.chompopo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String station;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면전환
        ImageButton selectmap = findViewById(R.id.selectmap);
        ImageButton setting = findViewById(R.id.settingbtn);
        ImageButton musicsetting = findViewById(R.id.musicbtn);

        //맵
        selectmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        mapActivity.class);
                intent.putExtra("station", station);
                startActivity(intent);
            }
        });

        //설정
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        SettingActivity.class);
                intent.putExtra("station", station);
                startActivity(intent);
            }
        });

        //음악설정
        musicsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MusicSettingActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String sub = intent.getExtras().getString("station");
        ImageView iv = findViewById(R.id.station_img);
        station = sub;
        if(sub.equals("nkh"))
        {
            iv.setImageResource(R.drawable.newkh);
        }
    }

}
