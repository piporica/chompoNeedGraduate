package com.example.chompopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    String station;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        Intent intent = getIntent();
        station = intent.getStringExtra("station");
        findViewById(R.id.set_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),MainActivity.class);
                intent.putExtra("station", station);
                startActivity(intent);
            }
        });
    }
}