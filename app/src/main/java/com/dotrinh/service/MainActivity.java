package com.dotrinh.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartBtn, btnStopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartBtn = findViewById(R.id.buttonStartService);
        btnStopBtn = findViewById(R.id.buttonStopService);
        btnStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        btnStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
    }

    public void startService() {
        Intent serviceIntent = new Intent(this, MyForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Đây là ví dụ về foreground không bind interface");
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService() {
        Intent serviceIntent = new Intent(this, MyForegroundService.class);
        stopService(serviceIntent);
    }
}
