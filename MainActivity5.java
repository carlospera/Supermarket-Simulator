package com.example.supermarket;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    Button b_back;

    TextView tv_money;

    Animation scaleUp,scaleDown;

    ImageView iv_card;

    Boolean current_card_id_red = true;

    Button b_choose_red,b_choose_black,b_try_again;
    
    TextView tv_gamble_result;

    Thread t2;

    public MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        mediaPlayer1 = MediaPlayer.create(MainActivity5.this,R.raw.click);
        mediaPlayer1.start();


        //Setting animation
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        tv_money = findViewById(R.id.textView35);
        tv_money.setText(MainActivity2.format_money_display(MainActivity2.money)+"$");

        iv_card = findViewById(R.id.imageView22);

        b_back = findViewById(R.id.button34);

        b_choose_red = findViewById(R.id.button35);
        b_choose_black = findViewById(R.id.button36);

        b_try_again = findViewById(R.id.button37);

        tv_gamble_result = findViewById(R.id.textView37);
        tv_gamble_result.setVisibility(View.INVISIBLE);

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_back.startAnimation(scaleUp);
                b_back.startAnimation(scaleDown);
                openActivity4();
            }
        });

        final Handler handler = new Handler();
        final int delay = 100;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(current_card_id_red)
                {
                    iv_card.setImageResource(R.drawable.black_card);
                    current_card_id_red = false;
                }
                else
                {
                    iv_card.setImageResource(R.drawable.red_card);
                    current_card_id_red = true;
                }
                handler.postDelayed(this, delay);
            }
        }, delay);

        b_choose_red.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int rand = (Math.random() <= 0.5) ? 1 : 2;
                tv_gamble_result.setVisibility(View.VISIBLE);
                if(rand == 1)
                {
                    iv_card.setImageResource(R.drawable.red_card);
                    tv_gamble_result.setTextColor(Color.GREEN);
                    tv_gamble_result.setText("You won: " + MainActivity2.format_money_display(MainActivity2.money*2) + "$");
                    MainActivity2.money *= 2;
                }
                else
                {
                    iv_card.setImageResource(R.drawable.black_card);
                    MainActivity2.money = 0;
                    tv_gamble_result.setTextColor(Color.RED);
                    tv_gamble_result.setText("You lost all your money!");
                }
                b_choose_black.setVisibility(View.INVISIBLE);
                b_choose_red.setVisibility(View.INVISIBLE);
                iv_card.startAnimation(scaleUp);
                iv_card.startAnimation(scaleDown);
                b_try_again.setVisibility(View.VISIBLE);
                handler.removeCallbacksAndMessages(null);
            }
        });

        b_choose_black.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int rand = (Math.random() <= 0.5) ? 1 : 2;
                tv_gamble_result.setVisibility(View.VISIBLE);
                if(rand == 1)
                {
                    iv_card.setImageResource(R.drawable.red_card);
                    tv_gamble_result.setTextColor(Color.RED);
                    tv_gamble_result.setText("You lost all your money!");
                    MainActivity2.money = 0;
                }
                else
                {
                    iv_card.setImageResource(R.drawable.black_card);
                    tv_gamble_result.setTextColor(Color.GREEN);
                    tv_gamble_result.setText("You won: " + MainActivity2.format_money_display(MainActivity2.money*2) + "$");
                    MainActivity2.money *= 2;
                }
                b_choose_black.setVisibility(View.INVISIBLE);
                b_choose_red.setVisibility(View.INVISIBLE);
                iv_card.startAnimation(scaleUp);
                iv_card.startAnimation(scaleDown);
                b_try_again.setVisibility(View.VISIBLE);
                handler.removeCallbacksAndMessages(null);
            }
        });

        b_try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_try_again.startAnimation(scaleUp);
                b_try_again.startAnimation(scaleDown);
                tv_gamble_result.setVisibility(View.INVISIBLE);
                b_choose_black.setVisibility(View.VISIBLE);
                b_choose_red.setVisibility(View.VISIBLE);
                b_try_again.setVisibility(View.INVISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(current_card_id_red)
                        {
                            iv_card.setImageResource(R.drawable.black_card);
                            current_card_id_red = false;
                        }
                        else
                        {
                            iv_card.setImageResource(R.drawable.red_card);
                            current_card_id_red = true;
                        }
                        handler.postDelayed(this, delay);
                    }
                }, delay);
            }
        });



        Thread t1 = new Thread()
        {
            public void run()
            {
                try {
                    while(!isInterrupted())
                    {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_money.setText(MainActivity2.format_money_display(MainActivity2.money)+"$");
                                tv_money.startAnimation(scaleUp);
                                tv_money.startAnimation(scaleDown);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t1.start();

        t2 = new Thread()
        {
            public void run()
            {
                try {
                    while(!isInterrupted())
                    {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(current_card_id_red)
                                {
                                    iv_card.setImageResource(R.drawable.black_card);
                                    current_card_id_red = false;
                                }
                                else
                                {
                                    iv_card.setImageResource(R.drawable.red_card);
                                    current_card_id_red = true;
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        //t2.start();
    }

    public void openActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void onBackPressed(){
    }
}