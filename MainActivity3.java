package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_offline_time;
    TextView tv_money_gained;
    Button b_nextActivity;
    TextView tv_money;
    public MediaPlayer mediaPlayer1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        mediaPlayer1 = MediaPlayer.create(MainActivity3.this,R.raw.click);
        mediaPlayer1.start();

        tv_offline_time = findViewById(R.id.textView23);
        if(MainActivity.elapsedMinutes<120)
            tv_offline_time.setText("You have been offline for " + MainActivity.elapsedMinutes + " minutes and " + MainActivity.elapsedSeconds + " seconds and you gained");
        else
            tv_offline_time.setText("You have been offline for more than 2 hours and you gained");

        tv_money_gained = findViewById(R.id.textView26);
        tv_money_gained.setText(MainActivity2.format_money_display(MainActivity.gainedMoney) + "$");

        tv_money = findViewById(R.id.textView38);
        tv_money.setText(MainActivity2.format_money_display(MainActivity2.money) + "$");

        b_nextActivity = findViewById(R.id.button13);
        b_nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onBackPressed(){
    }
}