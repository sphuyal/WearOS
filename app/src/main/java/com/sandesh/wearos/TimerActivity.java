package com.sandesh.wearos;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class TimerActivity extends WearableActivity {

    private TextView tvSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvSeconds = findViewById(R.id.tvSeconds);

        // Enables Always-on
        setAmbientEnabled();

        new CountDownTimer(30000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                tvSeconds.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                tvSeconds.setText("Done");

            }
        }.start();
    }
}
