package com.dotrinh.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BgServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bg_service_activity);
        final TextView text = findViewById(R.id.startBtn);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("Started")) {
                    text.setText("Stoped");
                    stopService(new Intent(BgServiceActivity.this, BackgroundService.class));
                } else {
                    text.setText("Started");
                    startService(new Intent(BgServiceActivity.this, BackgroundService.class));
                }

            }
        });
    }
}

