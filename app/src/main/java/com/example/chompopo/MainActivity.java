package com.example.chompopo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Button player = findViewById(R.id.player);

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

        //플레이어
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        playerActivity.class);
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
                intent.putExtra("station", station);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String sub = intent.getExtras().getString("station");
        ImageView iv = findViewById(R.id.station_img);
        ImageView bg = findViewById(R.id.main_bg);
        station = sub;
        if(sub.equals("nkh"))
        {
            iv.setImageResource(R.drawable.newkh);
            bg.setImageResource(R.drawable.bk_nkh);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("정말로 종료하시겠습니까?");

        alert_ex.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert_ex.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alert_ex.setTitle("Walking Muse");
        AlertDialog alert = alert_ex.create();
        alert.show();

    }

}
