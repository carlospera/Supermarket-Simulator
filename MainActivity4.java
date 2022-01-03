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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    TextView tv_money;
    ImageView iv_back;
    ImageView sound_check;

    TextView tv_most_efficient,tv_most_efficient_mps;
    Button b_contor_most_efficient;
    ImageView iv_most_efficient;

    TextView tv_most_inefficient,tv_most_inefficient_mps;
    Button b_contor_most_inefficient;
    ImageView iv_most_inefficient;

    Button b_gamble_money,b_go_shopping,b_achievements,b_stock_market;

    Animation scaleUp,scaleDown;

    public MediaPlayer mediaPlayer1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        mediaPlayer1 = MediaPlayer.create(MainActivity4.this,R.raw.click);
        mediaPlayer1.start();

        //Setting animation
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        tv_money = findViewById(R.id.textView30);
        tv_money.setText(MainActivity2.format_money_display(MainActivity2.money)+"$");

        iv_back = findViewById(R.id.imageView17);
        sound_check = findViewById(R.id.imageView20);

        b_gamble_money = findViewById(R.id.button52);
        b_gamble_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

        b_go_shopping = findViewById(R.id.button54);
        b_go_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });

        b_achievements = findViewById(R.id.button88);
        b_achievements.setText(check_achievements()+"/20");
        b_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity7(); }
        });

        b_stock_market = findViewById(R.id.button91);
        b_stock_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });

        if(!MainActivity.sound_on)
            sound_check.setImageResource(R.drawable.sound_off);
        sound_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound_check.startAnimation(scaleUp);
                if(MainActivity.sound_on)
                {
                    sound_check.setImageResource(R.drawable.sound_off);
                    MainActivity.sound_on = false;
                    MainActivity.mediaPlayer.pause();
                }
                else
                {
                    sound_check.setImageResource(R.drawable.sound_on);
                    MainActivity.sound_on = true;
                    MainActivity.mediaPlayer.start();
                }
                sound_check.startAnimation(scaleDown);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_back.startAnimation(scaleUp);
                iv_back.startAnimation(scaleDown);
                openActivity2();
            }
        });

        tv_most_efficient = findViewById(R.id.textView47);
        tv_most_efficient_mps = findViewById(R.id.textView33);
        b_contor_most_efficient = findViewById(R.id.button47);
        iv_most_efficient = findViewById(R.id.imageView27);

        tv_most_inefficient = findViewById(R.id.textView48);
        tv_most_inefficient_mps = findViewById(R.id.textView43);
        b_contor_most_inefficient = findViewById(R.id.button49);
        iv_most_inefficient = findViewById(R.id.imageView28);


        double max = MainActivity2.mps_produce_dept;
        tv_most_efficient.setText("Most efficient: Produce Dept");
        b_contor_most_efficient.setText(""+MainActivity2.contor_produce_dept);
        iv_most_efficient.setImageResource(R.drawable.lemon);
        if(MainActivity2.mps_bakery>max)
        {
            max = MainActivity2.mps_bakery;
            tv_most_efficient.setText("Most efficient: Bakery");
            b_contor_most_efficient.setText(""+MainActivity2.contor_bakery);
            iv_most_efficient.setImageResource(R.drawable.donut);
        }
        if(MainActivity2.mps_butcher>max)
        {
            max = MainActivity2.mps_butcher;
            tv_most_efficient.setText("Most efficient: Butcher");
            b_contor_most_efficient.setText(""+MainActivity2.contor_butcher);
            iv_most_efficient.setImageResource(R.drawable.ham);
        }
        if(MainActivity2.mps_seafood>max) 
        {
            max = MainActivity2.mps_seafood;
            tv_most_efficient.setText("Most efficient: Seafood");
            b_contor_most_efficient.setText(""+MainActivity2.contor_seafood);
            iv_most_efficient.setImageResource(R.drawable.crab);
        }
        if(MainActivity2.mps_clothing>max)
        {
            max = MainActivity2.mps_clothing;
            tv_most_efficient.setText("Most efficient: Clothing");
            b_contor_most_efficient.setText(""+MainActivity2.contor_clothing);
            iv_most_efficient.setImageResource(R.drawable.tshirt);
        }
            
        if(MainActivity2.mps_perfume>max)
        {
            max = MainActivity2.mps_perfume;
            tv_most_efficient.setText("Most efficient: Perfume");
            b_contor_most_efficient.setText(""+MainActivity2.contor_perfume);
            iv_most_efficient.setImageResource(R.drawable.perfume);
        }
        if(MainActivity2.mps_electronics>max)
        {
            max = MainActivity2.mps_electronics;
            tv_most_efficient.setText("Most efficient: Electonics");
            b_contor_most_efficient.setText(""+MainActivity2.contor_electronics);
            iv_most_efficient.setImageResource(R.drawable.tv);
        }
        if(MainActivity2.mps_jewelry>max)
        {
            max = MainActivity2.mps_jewelry;
            tv_most_efficient.setText("Most efficient: Jewelry");
            b_contor_most_efficient.setText(""+MainActivity2.contor_jewelry);
            iv_most_efficient.setImageResource(R.drawable.ring);
        }
        tv_most_efficient_mps.setText("Profit: " + MainActivity2.format_money_display(max*60)+"$/min");



        double min = MainActivity2.mps_produce_dept;
        tv_most_inefficient.setText("Least efficient: Produce Dept");
        b_contor_most_inefficient.setText(""+MainActivity2.contor_produce_dept);
        iv_most_inefficient.setImageResource(R.drawable.lemon);
        if(MainActivity2.mps_bakery<min && MainActivity2.mps_bakery!=0)
        {
            min = MainActivity2.mps_bakery;
            tv_most_inefficient.setText("Least efficient: Bakery");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_bakery);
            iv_most_inefficient.setImageResource(R.drawable.donut);
        }
        if(MainActivity2.mps_butcher<min && MainActivity2.mps_butcher!=0)
        {
            min = MainActivity2.mps_butcher;
            tv_most_inefficient.setText("Least efficient: Butcher");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_butcher);
            iv_most_inefficient.setImageResource(R.drawable.ham);
        }
        if(MainActivity2.mps_seafood<min && MainActivity2.mps_seafood!=0)
        {
            min = MainActivity2.mps_seafood;
            tv_most_inefficient.setText("Least efficient: Seafood");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_seafood);
            iv_most_inefficient.setImageResource(R.drawable.crab);
        }
        if(MainActivity2.mps_clothing<min && MainActivity2.mps_clothing!=0)
        {
            min = MainActivity2.mps_clothing;
            tv_most_inefficient.setText("Least efficient: Clothing");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_clothing);
            iv_most_inefficient.setImageResource(R.drawable.tshirt);
        }

        if(MainActivity2.mps_perfume<min && MainActivity2.mps_perfume!=0)
        {
            min = MainActivity2.mps_perfume;
            tv_most_inefficient.setText("Least efficient: Perfume");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_perfume);
            iv_most_inefficient.setImageResource(R.drawable.perfume);
        }
        if(MainActivity2.mps_electronics<min && MainActivity2.mps_electronics!=0)
        {
            min = MainActivity2.mps_electronics;
            tv_most_inefficient.setText("Least efficient: Electonics");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_electronics);
            iv_most_inefficient.setImageResource(R.drawable.tv);
        }
        if(MainActivity2.mps_jewelry<min && MainActivity2.mps_jewelry!=0)
        {
            min = MainActivity2.mps_jewelry;
            tv_most_inefficient.setText("Least efficient: Jewelry");
            b_contor_most_inefficient.setText(""+MainActivity2.contor_jewelry);
            iv_most_inefficient.setImageResource(R.drawable.ring);
        }
        tv_most_inefficient_mps.setText("Profit: " + MainActivity2.format_money_display(min*60)+"$/min");


        Thread t = new Thread()
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
        t.start();


    }

    public static int check_achievements()
    {
        int completed_achievements = 0;
        if(MainActivity2.contor_produce_dept >= 500)
            completed_achievements++;
        if(MainActivity2.contor_bakery >= 500)
            completed_achievements++;
        if(MainActivity2.contor_butcher >= 500)
            completed_achievements++;
        if(MainActivity2.contor_seafood >= 500)
            completed_achievements++;
        if(MainActivity2.contor_clothing >= 500)
            completed_achievements++;
        if(MainActivity2.contor_perfume >= 500)
            completed_achievements++;
        if(MainActivity2.contor_electronics >= 500)
            completed_achievements++;
        if(MainActivity2.contor_jewelry >= 500)
            completed_achievements++;
        if(MainActivity2.contor_produce_dept >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_bakery >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_butcher >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_seafood >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_clothing >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_perfume >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_electronics >= 1000)
            completed_achievements++;
        if(MainActivity2.contor_jewelry >= 1000)
            completed_achievements++;
        return completed_achievements;
    }


    public void onBackPressed(){
    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void openActivity6() {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    public void openActivity7() {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void openActivity8() {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }

}