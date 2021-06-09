package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MSlepp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_calculator);
        final Chronometer ch=(Chronometer)findViewById(R.id.timer);
        int hour = (int) ((SystemClock.elapsedRealtime()-ch.getBase())/1000/60);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setFormat("睡眠时间:%s");
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-ch.getBase()>=6000000){
                    ch.stop();
                }
            }
        });
        Button wake=(Button)findViewById(R.id.wake);
        wake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.stop();
            }
        });
    }
}