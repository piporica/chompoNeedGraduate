package com.example.chompopo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면전환
        ImageButton selectmap = (ImageButton)findViewById(R.id.selectmap);
        ImageButton setting = (ImageButton)findViewById(R.id.settingbtn);
        ImageButton musicsetting = (ImageButton)findViewById(R.id.musicbtn);

        //맵
        selectmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        mapActivity.class);
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

    }

}
