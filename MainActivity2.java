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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_produce_dept,tv_cost_produce_dept;
    Button b_produce_dept,b_frame_produce_dept;
    Button btv_contor_produce_dept;
    public static int contor_produce_dept;
    public static double mps_produce_dept;
    public static double cost_produce_dept;

    TextView tv_bakery,tv_cost_bakery;
    Button b_bakery,b_frame_bakery;
    Button btv_contor_bakery;
    public static int contor_bakery;
    public static double mps_bakery;
    public static double cost_bakery;

    TextView tv_butcher,tv_cost_butcher;
    Button b_butcher,b_frame_butcher;
    Button btv_contor_butcher;
    public static int contor_butcher;
    public static double mps_butcher;
    public static double cost_butcher;

    TextView tv_seafood,tv_cost_seafood;
    Button b_seafood,b_frame_seafood;
    Button btv_contor_seafood;
    public static int contor_seafood;
    public static double mps_seafood;
    public static double cost_seafood;

    TextView tv_clothing,tv_cost_clothing;
    Button b_clothing,b_frame_clothing;
    Button btv_contor_clothing;
    public static int contor_clothing;
    public static double mps_clothing;
    public static double cost_clothing;

    TextView tv_perfume,tv_cost_perfume;
    Button b_perfume,b_frame_perfume;
    Button btv_contor_perfume;
    public static int contor_perfume;
    public static double mps_perfume;
    public static double cost_perfume;

    TextView tv_electronics,tv_cost_electronics;
    Button b_electronics,b_frame_electronics;
    Button btv_contor_electronics;
    public static int contor_electronics;
    public static double mps_electronics;
    public static double cost_electronics;

    TextView tv_jewelry,tv_cost_jewelry;
    Button b_jewelry,b_frame_jewelry;
    Button btv_contor_jewelry;
    public static int contor_jewelry;
    public static double mps_jewelry;
    public static double cost_jewelry;

    TextView tv_money,tv_money_per_min;
    public static double money,money_per_second;

    public static final String FILE_NAME = "example.txt";

    Animation scaleUp,scaleDown;

    public MediaPlayer mediaPlayer1;
    public MediaPlayer mediaPlayer2;

    ImageView three_bars;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables", "DefaultLocale", "ClickableViewAccessibility", "WrongViewCast", "CutPasteId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        mediaPlayer1 = MediaPlayer.create(MainActivity2.this,R.raw.click);
        mediaPlayer1.start();
        mediaPlayer2 = MediaPlayer.create(MainActivity2.this,R.raw.buy_something);

        three_bars = findViewById(R.id.imageView15);

        three_bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                three_bars.startAnimation(scaleUp);
                three_bars.startAnimation(scaleDown);
                openActivity4();
            }
        });

        //Setting animation
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        //Setting main money Text View
        tv_money = findViewById(R.id.textView5);
        tv_money_per_min = findViewById(R.id.textView6);
        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;

        //Showing main money
        tv_money.setText(format_money_display(money)+"$");
        tv_money_per_min.setText(format_money_display(money_per_second*60)+"$/min");

        //Setting Produce Dept View
        tv_produce_dept = findViewById(R.id.textView7);
        tv_cost_produce_dept = findViewById(R.id.textView8);
        btv_contor_produce_dept = findViewById(R.id.button2);
        b_produce_dept = findViewById(R.id.button3);
        b_frame_produce_dept = findViewById(R.id.button);

        //Setting Bakery View
        tv_bakery = findViewById(R.id.textView10);
        tv_cost_bakery = findViewById(R.id.textView11);
        btv_contor_bakery = findViewById(R.id.button5);
        b_bakery = findViewById(R.id.button6);
        b_frame_bakery = findViewById(R.id.button4);

        //Setting Butcher View
        tv_butcher = findViewById(R.id.textView9);
        tv_cost_butcher = findViewById(R.id.textView12);
        btv_contor_butcher = findViewById(R.id.button10);
        b_butcher = findViewById(R.id.button11);
        b_frame_butcher = findViewById(R.id.button9);

        //Setting Seafood View
        tv_seafood = findViewById(R.id.textView14);
        tv_cost_seafood = findViewById(R.id.textView13);
        btv_contor_seafood = findViewById(R.id.button14);
        b_seafood = findViewById(R.id.button15);
        b_frame_seafood = findViewById(R.id.button12);

        //Setting Clothing View
        tv_clothing = findViewById(R.id.textView16);
        tv_cost_clothing = findViewById(R.id.textView15);
        btv_contor_clothing = findViewById(R.id.button17);
        b_clothing = findViewById(R.id.button18);
        b_frame_clothing = findViewById(R.id.button16);

        //Setting Perfume View
        tv_perfume = findViewById(R.id.textView17);
        tv_cost_perfume = findViewById(R.id.textView18);
        btv_contor_perfume = findViewById(R.id.button20);
        b_perfume = findViewById(R.id.button21);
        b_frame_perfume = findViewById(R.id.button19);

        //Setting Electronics View
        tv_electronics = findViewById(R.id.textView20);
        tv_cost_electronics = findViewById(R.id.textView19);
        btv_contor_electronics = findViewById(R.id.button23);
        b_electronics = findViewById(R.id.button24);
        b_frame_electronics = findViewById(R.id.button22);

        //Setting Jewelry View
        tv_jewelry = findViewById(R.id.textView22);
        tv_cost_jewelry = findViewById(R.id.textView21);
        btv_contor_jewelry = findViewById(R.id.button26);
        b_jewelry = findViewById(R.id.button28);
        b_frame_jewelry = findViewById(R.id.button25);

        //Showing mps for every product
        tv_produce_dept.setText("PROUCE DEPT.\nProfit: "+ format_money_display(mps_produce_dept*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_produce_dept));
        if(mps_bakery!=0)tv_bakery.setText("BAKERY\nProfit: "+ format_money_display(mps_bakery*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_bakery));
        if(mps_butcher!=0)tv_butcher.setText("BUTCHER\nProfit: "+ format_money_display(mps_butcher*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_butcher));
        if(mps_seafood!=0)tv_seafood.setText("SEAFOOD\nProfit: "+ format_money_display(mps_seafood*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_seafood));
        if(mps_clothing!=0)tv_clothing.setText("CLOTHING\nProfit: "+ format_money_display(mps_clothing*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_clothing));
        if(mps_perfume!=0)tv_perfume.setText("PERFUME\nProfit: "+ format_money_display(mps_perfume*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_perfume));
        if(mps_electronics!=0)tv_electronics.setText("ELECTRONICS\nProfit: "+ format_money_display(mps_electronics*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_electronics));
        if(mps_jewelry!=0)tv_jewelry.setText("JEWELRY\nProfit: "+ format_money_display(mps_jewelry*60) + "$/min"  + "\n\n" + nextIncreaseCalculator(contor_jewelry));

        //Showing cost for every product
        tv_cost_produce_dept.setText("Cost: " + format_money_display(cost_produce_dept)+"$");
        tv_cost_bakery.setText("Cost: " + format_money_display(cost_bakery)+"$");
        tv_cost_butcher.setText("Cost: " + format_money_display(cost_butcher)+"$");
        tv_cost_seafood.setText("Cost: " + format_money_display(cost_seafood)+"$");
        tv_cost_clothing.setText("Cost: " + format_money_display(cost_clothing)+"$");
        tv_cost_perfume.setText("Cost: " + format_money_display(cost_perfume)+"$");
        tv_cost_electronics.setText("Cost: " + format_money_display(cost_electronics)+"$");
        tv_cost_jewelry.setText("Cost: " + format_money_display(cost_jewelry)+"$");

        //Showing number of every product
        btv_contor_produce_dept.setText(""+contor_produce_dept);
        btv_contor_bakery.setText(""+contor_bakery);
        btv_contor_butcher.setText(""+contor_butcher);
        btv_contor_seafood.setText(""+contor_seafood);
        btv_contor_clothing.setText(""+contor_clothing);
        btv_contor_perfume.setText(""+contor_perfume);
        btv_contor_electronics.setText(""+contor_electronics);
        btv_contor_jewelry.setText(""+contor_jewelry);

        //Showing right button color and text
        if(contor_bakery>0){b_bakery.setText("BUY");b_bakery.setBackground(getDrawable(R.drawable.button_shape3));b_frame_bakery.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_butcher>0){b_butcher.setText("BUY");b_butcher.setBackground(getDrawable(R.drawable.button_shape3));b_frame_butcher.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_seafood>0){b_seafood.setText("BUY");b_seafood.setBackground(getDrawable(R.drawable.button_shape3));b_frame_seafood.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_clothing>0){b_clothing.setText("BUY");b_clothing.setBackground(getDrawable(R.drawable.button_shape3));b_frame_clothing.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_perfume>0){b_perfume.setText("BUY");b_perfume.setBackground(getDrawable(R.drawable.button_shape3));b_frame_perfume.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_electronics>0){b_electronics.setText("BUY");b_electronics.setBackground(getDrawable(R.drawable.button_shape3));b_frame_electronics.setBackground(getDrawable(R.drawable.button_shape1));}
        if(contor_jewelry>0){b_jewelry.setText("BUY");b_jewelry.setBackground(getDrawable(R.drawable.button_shape3));b_frame_jewelry.setBackground(getDrawable(R.drawable.button_shape1));}

        final Handler handler = new Handler();
        final int delay = 100;

        //Produce Dept Buy Button action
        b_produce_dept.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(money-cost_produce_dept>=0.00)
                            {
                                b_anim(b_produce_dept);
                                contor_produce_dept++;
                                if(contor_produce_dept%100==0 || contor_produce_dept==25 || contor_produce_dept==50)
                                {
                                    cost_produce_dept*=1.04*multiplicationReturn(contor_produce_dept);
                                    mps_produce_dept*=1.01*multiplicationReturn(contor_produce_dept);
                                }
                                else
                                {
                                    cost_produce_dept*=1.04;
                                    mps_produce_dept*=1.01;
                                }
                                money-=cost_produce_dept;
                                tv_cost_produce_dept.setText("Cost: " + format_money_display(cost_produce_dept)+"$");
                                btv_contor_produce_dept.setText(""+contor_produce_dept);
                                tv_produce_dept.setText("PROUCE DEPT.\nProfit: " + format_money_display(mps_produce_dept*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_produce_dept));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(money-cost_produce_dept>=0.00)
                    {
                        b_anim(b_produce_dept);
                        contor_produce_dept++;
                        if(contor_produce_dept%100==0 || contor_produce_dept==25 || contor_produce_dept==50)
                        {
                            cost_produce_dept*=1.04*multiplicationReturn(contor_produce_dept);
                            mps_produce_dept*=1.01*multiplicationReturn(contor_produce_dept);
                        }
                        else
                        {
                            cost_produce_dept*=1.04;
                            mps_produce_dept*=1.01;
                        }
                        money-=cost_produce_dept;
                        tv_cost_produce_dept.setText("Cost: " + format_money_display(cost_produce_dept)+"$");
                        btv_contor_produce_dept.setText(""+contor_produce_dept);
                        tv_produce_dept.setText("PROUCE DEPT.\nProfit: " + format_money_display(mps_produce_dept*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_produce_dept));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                }
                return true;
            }
        });

        //Bakery Buy Button action
        b_bakery.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_bakery>0 && money-cost_bakery>=0.00)
                            {
                                b_anim(b_bakery);
                                contor_bakery++;
                                if(contor_bakery%100==0 || contor_bakery==25 || contor_bakery==50)
                                {
                                    cost_bakery*=1.04*multiplicationReturn(contor_bakery);
                                    mps_bakery*=1.01*multiplicationReturn(contor_bakery);
                                }
                                else
                                {
                                    cost_bakery*=1.04;
                                    mps_bakery*=1.01;
                                }
                                money-=cost_bakery;
                                tv_cost_bakery.setText("Cost: " + format_money_display(cost_bakery)+"$");
                                btv_contor_bakery.setText(""+contor_bakery);
                                tv_bakery.setText("BAKERY\nProfit: " + format_money_display(mps_bakery*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_bakery));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_bakery==0 && money-cost_bakery>=0.00)
                            {
                                b_anim(b_bakery);
                                money-=cost_bakery;
                                contor_bakery=1;
                                mps_bakery=0.2;
                                tv_cost_bakery.setText("Cost: " + format_money_display(cost_bakery)+"$");
                                btv_contor_bakery.setText(""+contor_bakery);
                                tv_bakery.setText("BAKERY\nProfit: " + format_money_display(mps_bakery*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_bakery));
                                b_bakery.setText("BUY");
                                b_bakery.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_bakery.setBackground(getDrawable(R.drawable.button_shape1));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_bakery>0 && money-cost_bakery>=0.00)
                    {
                        b_anim(b_bakery);
                        contor_bakery++;
                        if(contor_bakery%100==0 || contor_bakery==25 || contor_bakery==50)
                        {
                            cost_bakery*=1.04*multiplicationReturn(contor_bakery);
                            mps_bakery*=1.01*multiplicationReturn(contor_bakery);
                        }
                        else
                        {
                            cost_bakery*=1.04;
                            mps_bakery*=1.01;
                        }
                        money-=cost_bakery;
                        tv_cost_bakery.setText("Cost: " + format_money_display(cost_bakery)+"$");
                        btv_contor_bakery.setText(""+contor_bakery);
                        tv_bakery.setText("BAKERY\nProfit: " + format_money_display(mps_bakery*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_bakery));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_bakery==0 && money-cost_bakery>=0.00)
                    {
                        b_anim(b_bakery);
                        money-=cost_bakery;
                        contor_bakery=1;
                        mps_bakery=0.2;
                        tv_cost_bakery.setText("Cost: " + format_money_display(cost_bakery)+"$");
                        btv_contor_bakery.setText(""+contor_bakery);
                        tv_bakery.setText("BAKERY\nProfit: " + format_money_display(mps_bakery*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_bakery));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_bakery.setText("BUY");
                        b_bakery.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_bakery.setBackground(getDrawable(R.drawable.button_shape1));
                    }

                }
                return true;
            }
        });

        //Butcher Buy Button action
        b_butcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_butcher>0 && money-cost_butcher>=0.00)
                            {
                                b_anim(b_butcher);
                                contor_butcher++;
                                money-=cost_butcher;
                                if(contor_butcher%100==0 || contor_butcher==25 || contor_butcher==50)
                                {
                                    cost_butcher*=1.04*multiplicationReturn(contor_butcher);
                                    mps_butcher*=1.01*multiplicationReturn(contor_butcher);
                                }
                                else
                                {
                                    cost_butcher*=1.04;
                                    mps_butcher*=1.01;
                                }
                                tv_cost_butcher.setText("Cost: " + format_money_display(cost_butcher)+"$");
                                btv_contor_butcher.setText(""+contor_butcher);
                                tv_butcher.setText("BUTCHER\nProfit: " + format_money_display(mps_butcher*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_butcher));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_butcher==0 && money-cost_butcher>=0.00)
                            {
                                b_anim(b_butcher);
                                money-=cost_butcher;
                                contor_butcher=1;
                                mps_butcher=0.9;
                                tv_cost_butcher.setText("Cost: " + format_money_display(cost_butcher)+"$");
                                btv_contor_butcher.setText(""+contor_butcher);
                                tv_butcher.setText("BUTCHER\nProfit: " + format_money_display(mps_butcher*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_butcher));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                                b_butcher.setText("BUY");
                                b_butcher.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_butcher.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_butcher>0 && money-cost_butcher>=0.00)
                    {
                        b_anim(b_butcher);
                        contor_butcher++;
                        money-=cost_butcher;
                        if(contor_butcher%100==0 || contor_butcher==25 || contor_butcher==50)
                        {
                            cost_butcher*=1.04*multiplicationReturn(contor_butcher);
                            mps_butcher*=1.01*multiplicationReturn(contor_butcher);
                        }
                        else
                        {
                            cost_butcher*=1.04;
                            mps_butcher*=1.01;
                        }
                        tv_cost_butcher.setText("Cost: " + format_money_display(cost_butcher)+"$");
                        btv_contor_butcher.setText(""+contor_butcher);
                        tv_butcher.setText("BUTCHER\nProfit: " + format_money_display(mps_butcher*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_butcher));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_butcher==0 && money-cost_butcher>=0.00)
                    {
                        b_anim(b_butcher);
                        money-=cost_butcher;
                        contor_butcher=1;
                        mps_butcher=0.9;
                        tv_cost_butcher.setText("Cost: " + format_money_display(cost_butcher)+"$");
                        btv_contor_butcher.setText(""+contor_butcher);
                        tv_butcher.setText("BUTCHER\nProfit: " + format_money_display(mps_butcher*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_butcher));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_butcher.setText("BUY");
                        b_butcher.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_butcher.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Seafood Buy Button action
        b_seafood.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_seafood>0 && money-cost_seafood>=0.00)
                            {
                                b_anim(b_seafood);
                                contor_seafood++;
                                money-=cost_seafood;
                                if(contor_seafood%100==0 || contor_seafood==25 || contor_seafood==50)
                                {
                                    cost_seafood*=1.04*multiplicationReturn(contor_seafood);
                                    mps_seafood*=1.01*multiplicationReturn(contor_seafood);
                                }
                                else
                                {
                                    cost_seafood*=1.04;
                                    mps_seafood*=1.01;
                                }
                                tv_cost_seafood.setText("Cost: " + format_money_display(cost_seafood)+"$");
                                btv_contor_seafood.setText(""+contor_seafood);
                                tv_seafood.setText("SEAFOOD\nProfit: " + format_money_display(mps_seafood*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_seafood));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_seafood==0 && money-cost_seafood>=0.00)
                            {
                                b_anim(b_seafood);
                                money-=cost_seafood;
                                contor_seafood=1;
                                mps_seafood=3.6;
                                tv_cost_seafood.setText("Cost: " + format_money_display(cost_seafood)+"$");
                                btv_contor_seafood.setText(""+contor_seafood);
                                tv_seafood.setText("SEAFOOD\nProfit: " + format_money_display(mps_seafood*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_seafood));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                                b_seafood.setText("BUY");
                                b_seafood.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_seafood.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_seafood>0 && money-cost_seafood>=0.00)
                    {
                        b_anim(b_seafood);
                        contor_seafood++;
                        money-=cost_seafood;
                        if(contor_seafood%100==0 || contor_seafood==25 || contor_seafood==50)
                        {
                            cost_seafood*=1.04*multiplicationReturn(contor_seafood);
                            mps_seafood*=1.01*multiplicationReturn(contor_seafood);
                        }
                        else
                        {
                            cost_seafood*=1.04;
                            mps_seafood*=1.01;
                        }
                        tv_cost_seafood.setText("Cost: " + format_money_display(cost_seafood)+"$");
                        btv_contor_seafood.setText(""+contor_seafood);
                        tv_seafood.setText("SEAFOOD\nProfit: " + format_money_display(mps_seafood*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_seafood));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_seafood==0 && money-cost_seafood>=0.00)
                    {
                        b_anim(b_seafood);
                        money-=cost_seafood;
                        contor_seafood=1;
                        mps_seafood=3.6;
                        tv_cost_seafood.setText("Cost: " + format_money_display(cost_seafood)+"$");
                        btv_contor_seafood.setText(""+contor_seafood);
                        tv_seafood.setText("SEAFOOD\nProfit: " + format_money_display(mps_seafood*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_seafood));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_seafood.setText("BUY");
                        b_seafood.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_seafood.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Clothing Buy Button action
        b_clothing.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_clothing>0 && money-cost_clothing>=0.00)
                            {
                                b_anim(b_clothing);
                                contor_clothing++;
                                money-=cost_clothing;
                                if(contor_clothing%100==0 || contor_clothing==25 || contor_clothing==50)
                                {
                                    cost_clothing*=1.04*multiplicationReturn(contor_clothing);
                                    mps_clothing*=1.01*multiplicationReturn(contor_clothing);
                                }
                                else
                                {
                                    cost_clothing*=1.04;
                                    mps_clothing*=1.01;
                                }
                                tv_clothing.setText("Cost: " + format_money_display(cost_clothing)+"$" + "\n\n" + nextIncreaseCalculator(contor_clothing));
                                btv_contor_clothing.setText(""+contor_clothing);
                                tv_clothing.setText("CLOTHING\nProfit: " + format_money_display(mps_clothing*60) + "$/min");
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_clothing==0 && money-cost_clothing>=0.00)
                            {
                                b_anim(b_clothing);
                                money-=cost_clothing;
                                contor_clothing=1;
                                mps_clothing=21.6;
                                tv_cost_clothing.setText("Cost: " + format_money_display(cost_clothing)+"$");
                                btv_contor_clothing.setText(""+contor_clothing);
                                tv_clothing.setText("CLOTHING\nProfit: " + format_money_display(mps_clothing*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_clothing));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                                b_clothing.setText("BUY");
                                b_clothing.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_clothing.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_clothing>0 && money-cost_clothing>=0.00)
                    {
                        b_anim(b_clothing);
                        contor_clothing++;
                        money-=cost_clothing;
                        if(contor_clothing%100==0 || contor_clothing==25 || contor_clothing==50)
                        {
                            cost_clothing*=1.04*multiplicationReturn(contor_clothing);
                            mps_clothing*=1.01*multiplicationReturn(contor_clothing);
                        }
                        else
                        {
                            cost_clothing*=1.04;
                            mps_clothing*=1.01;
                        }
                        tv_cost_clothing.setText("Cost: " + format_money_display(cost_clothing)+"$");
                        btv_contor_clothing.setText(""+contor_clothing);
                        tv_clothing.setText("CLOTHING\nProfit: " + format_money_display(mps_clothing*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_clothing));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_clothing==0 && money-cost_clothing>=0.00)
                    {
                        b_anim(b_clothing);
                        money-=cost_clothing;
                        contor_clothing=1;
                        mps_clothing=21.6;
                        tv_cost_clothing.setText("Cost: " + format_money_display(cost_clothing)+"$");
                        btv_contor_clothing.setText(""+contor_clothing);
                        tv_clothing.setText("CLOTHING\nProfit: " + format_money_display(mps_clothing*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_clothing));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_clothing.setText("BUY");
                        b_clothing.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_clothing.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Perfume Buy Button action
        b_perfume.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_perfume>0 && money-cost_perfume>=0.00)
                            {
                                b_anim(b_perfume);
                                contor_perfume++;
                                money-=cost_perfume;
                                if(contor_perfume%100==0 || contor_perfume==25 || contor_perfume==50)
                                {
                                    cost_perfume*=1.04*multiplicationReturn(contor_perfume);
                                    mps_perfume*=1.01*multiplicationReturn(contor_perfume);
                                }
                                else
                                {
                                    cost_perfume*=1.04;
                                    mps_perfume*=1.01;
                                }
                                tv_cost_perfume.setText("Cost: " + format_money_display(cost_perfume)+"$");
                                btv_contor_perfume.setText(""+contor_perfume);
                                tv_perfume.setText("PERFUME\nProfit: " + format_money_display(mps_perfume*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_perfume));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_perfume==0 && money-cost_perfume>=0.00)
                            {
                                b_anim(b_perfume);
                                money-=cost_perfume;
                                contor_perfume = 1;
                                mps_perfume = 648.0;
                                tv_cost_perfume.setText("Cost: " + format_money_display(cost_perfume) + "$");
                                btv_contor_perfume.setText("" + contor_perfume);
                                tv_perfume.setText("PERFUME\nProfit: " + format_money_display(mps_perfume * 60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_perfume));
                                money_per_second = mps_produce_dept + mps_bakery + mps_butcher + mps_seafood + mps_clothing + mps_perfume + mps_electronics + mps_jewelry;
                                b_perfume.setText("BUY");
                                b_perfume.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_perfume.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_perfume>0 && money-cost_perfume>=0.00)
                    {
                        b_anim(b_perfume);
                        contor_perfume++;
                        money-=cost_perfume;
                        if(contor_perfume%100==0 || contor_perfume==25 || contor_perfume==50)
                        {
                            cost_perfume*=1.04*multiplicationReturn(contor_perfume);
                            mps_perfume*=1.01*multiplicationReturn(contor_perfume);
                        }
                        else
                        {
                            cost_perfume*=1.04;
                            mps_perfume*=1.01;
                        }
                        tv_cost_perfume.setText("Cost: " + format_money_display(cost_perfume)+"$");
                        btv_contor_perfume.setText(""+contor_perfume);
                        tv_perfume.setText("PERFUME\nProfit: " + format_money_display(mps_perfume*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_perfume));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_perfume==0 && money-cost_perfume>=0.00)
                    {
                        b_anim(b_perfume);
                        money-=cost_perfume;
                        contor_perfume = 1;
                        mps_perfume = 648.0;
                        tv_cost_perfume.setText("Cost: " + format_money_display(cost_perfume) + "$");
                        btv_contor_perfume.setText("" + contor_perfume);
                        tv_perfume.setText("PERFUME\nProfit: " + format_money_display(mps_perfume * 60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_perfume));
                        money_per_second = mps_produce_dept + mps_bakery + mps_butcher + mps_seafood + mps_clothing + mps_perfume + mps_electronics + mps_jewelry;
                        b_perfume.setText("BUY");
                        b_perfume.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_perfume.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Electronics Buy Button action
        b_electronics.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_electronics>0 && money-cost_electronics>=0.00)
                            {
                                b_anim(b_electronics);
                                contor_electronics++;
                                money-=cost_electronics;
                                if(contor_electronics%100==0 || contor_electronics==25 || contor_electronics==50)
                                {
                                    cost_electronics*=1.04*multiplicationReturn(contor_electronics);
                                    mps_electronics*=1.01*multiplicationReturn(contor_electronics);
                                }
                                else
                                {
                                    cost_electronics*=1.04;
                                    mps_electronics*=1.01;
                                }
                                tv_cost_electronics.setText("Cost: " + format_money_display(cost_electronics)+"$");
                                btv_contor_electronics.setText(""+contor_electronics);
                                tv_electronics.setText("ELECTRONICS\nProfit: " + format_money_display(mps_electronics*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_electronics));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_electronics==0 && money-cost_electronics>=0.00)
                            {
                                b_anim(b_electronics);
                                money-=cost_electronics;
                                contor_electronics=1;
                                mps_electronics=1944.0;
                                tv_cost_electronics.setText("Cost: " + format_money_display(cost_electronics)+"$");
                                btv_contor_electronics.setText(""+contor_electronics);
                                tv_electronics.setText("ELECTRONICS\nProfit: " + format_money_display(mps_electronics*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_electronics));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                                b_electronics.setText("BUY");
                                b_electronics.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_electronics.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_electronics>0 && money-cost_electronics>=0.00)
                    {
                        b_anim(b_electronics);
                        contor_electronics++;
                        money-=cost_electronics;
                        if(contor_electronics%100==0 || contor_electronics==25 || contor_electronics==50)
                        {
                            cost_electronics*=1.04*multiplicationReturn(contor_electronics);
                            mps_electronics*=1.01*multiplicationReturn(contor_electronics);
                        }
                        else
                        {
                            cost_electronics*=1.04;
                            mps_electronics*=1.01;
                        }
                        tv_cost_electronics.setText("Cost: " + format_money_display(cost_electronics)+"$");
                        btv_contor_electronics.setText(""+contor_electronics);
                        tv_electronics.setText("ELECTRONICS\nProfit: " + format_money_display(mps_electronics*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_electronics));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_electronics==0 && money-cost_electronics>=0.00)
                    {
                        b_anim(b_electronics);
                        money-=cost_electronics;
                        contor_electronics=1;
                        mps_electronics=1944.0;
                        tv_cost_electronics.setText("Cost: " + format_money_display(cost_electronics)+"$");
                        btv_contor_electronics.setText(""+contor_electronics);
                        tv_electronics.setText("ELECTRONICS\nProfit: " + format_money_display(mps_electronics*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_electronics));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_electronics.setText("BUY");
                        b_electronics.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_electronics.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Jewelry Buy Button action
        b_jewelry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(contor_jewelry>0 && money-cost_jewelry>=0.00)
                            {
                                b_anim(b_jewelry);
                                contor_jewelry++;
                                money-=cost_jewelry;
                                if(contor_jewelry%100==0 || contor_jewelry==25 || contor_jewelry==50)
                                {
                                    cost_jewelry*=1.04*multiplicationReturn(contor_jewelry);
                                    mps_jewelry*=1.01*multiplicationReturn(contor_jewelry);
                                }
                                else
                                {
                                    cost_jewelry*=1.04;
                                    mps_jewelry*=1.01;
                                }
                                tv_cost_jewelry.setText("Cost: " + format_money_display(cost_jewelry)+"$");
                                btv_contor_jewelry.setText(""+contor_jewelry);
                                tv_jewelry.setText("JEWELRY\nProfit: " + format_money_display(mps_jewelry*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_jewelry));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                            }
                            else if(contor_jewelry==0 && money-cost_jewelry>=0.00)
                            {
                                b_anim(b_jewelry);
                                money-=cost_jewelry;
                                contor_jewelry=1;
                                mps_jewelry=58320.0;
                                tv_cost_jewelry.setText("Cost: " + format_money_display(cost_jewelry)+"$");
                                btv_contor_jewelry.setText(""+contor_jewelry);
                                tv_jewelry.setText("JEWELRY\nProfit: " + format_money_display(mps_jewelry*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_jewelry));
                                money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                                b_jewelry.setText("BUY");
                                b_jewelry.setBackground(getDrawable(R.drawable.button_shape3));
                                b_frame_jewelry.setBackground(getDrawable(R.drawable.button_shape1));
                            }

                            handler.postDelayed(this, delay);
                        }
                    }, delay);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null);
                    if(contor_jewelry>0 && money-cost_jewelry>=0.00)
                    {
                        b_anim(b_jewelry);
                        contor_jewelry++;
                        money-=cost_jewelry;
                        if(contor_jewelry%100==0 || contor_jewelry==25 || contor_jewelry==50)
                        {
                            cost_jewelry*=1.04*multiplicationReturn(contor_jewelry);
                            mps_jewelry*=1.01*multiplicationReturn(contor_jewelry);
                        }
                        else
                        {
                            cost_jewelry*=1.04;
                            mps_jewelry*=1.01;
                        }
                        tv_cost_jewelry.setText("Cost: " + format_money_display(cost_jewelry)+"$");
                        btv_contor_jewelry.setText(""+contor_jewelry);
                        tv_jewelry.setText("JEWELRY\nProfit: " + format_money_display(mps_jewelry*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_jewelry));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                    }
                    else if(contor_jewelry==0 && money-cost_jewelry>=0.00)
                    {
                        b_anim(b_jewelry);
                        money-=cost_jewelry;
                        contor_jewelry=1;
                        mps_jewelry=5832.0;
                        tv_cost_jewelry.setText("Cost: " + format_money_display(cost_jewelry)+"$");
                        btv_contor_jewelry.setText(""+contor_jewelry);
                        tv_jewelry.setText("JEWELRY\nProfit: " + format_money_display(mps_jewelry*60) + "$/min" + "\n\n" + nextIncreaseCalculator(contor_jewelry));
                        money_per_second=mps_produce_dept+mps_bakery+mps_butcher+mps_seafood+mps_clothing+mps_perfume+mps_electronics+mps_jewelry;
                        b_jewelry.setText("BUY");
                        b_jewelry.setBackground(getDrawable(R.drawable.button_shape3));
                        b_frame_jewelry.setBackground(getDrawable(R.drawable.button_shape1));
                    }


                }
                return true;
            }
        });

        //Every second update
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
                                    money += money_per_second;
                                    tv_money.setText(format_money_display(money)+"$");
                                    tv_money.startAnimation(scaleUp);
                                    tv_money.startAnimation(scaleDown);
                                    tv_money_per_min.setText(format_money_display(money_per_second*60)+"$/min");
                                    update_text_file();
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }


    private void update_text_file() {
        FileOutputStream fos = null;
        try {
            String date = new SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault()).format(new Date());
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write((contor_produce_dept+"x"+mps_produce_dept+"x"+cost_produce_dept+"x"+
                    contor_bakery+"x"+mps_bakery+"x"+cost_bakery+"x"+
                    contor_butcher+ "x"+mps_butcher+"x"+cost_butcher+"x"+
                    contor_seafood+"x"+mps_seafood+"x"+cost_seafood+"x"+
                    contor_clothing+"x"+mps_clothing+"x"+cost_clothing+"x"+
                    contor_perfume+"x"+mps_perfume+"x"+cost_perfume+"x"+
                    contor_electronics+"x"+mps_electronics+ "x"+cost_electronics+"x"+
                    contor_jewelry+"x"+mps_jewelry+"x"+cost_jewelry+"x"+
                    money +"x"+date).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void b_anim(Button button) {
        if(MainActivity.sound_on)
            cash_sound();
        button.startAnimation(scaleUp);
        button.startAnimation(scaleDown);
    }

    @SuppressLint("DefaultLocale")
    public static String format_money_display(Double money) {
        if(money<=999.9)
            return String.format("%,.2f",money);
        else if(money>=1000.0 && money<=999999.9)
            return String.format("%,.2f",money/1000)+"k";
        else if(money>=1000000.0 && money<=999999999.9)
            return String.format("%,.2f",money/1000000)+"M";
        else if(money>=1000000000.0 && money<=999999999999.9)
            return String.format("%,.2f",money/1000000000)+"B";
        else if(money>=1000000000000.0 && money<=999999999999999.9)
            return String.format("%,.2f",money/1000000000000L)+"T";
        else if(money>=1000000000000000.0 && money<=999999999999999999.9)
            return String.format("%,.2f",money/1000000000000000L)+"Q";
        else if(money>=1000000000000000000.0 && money<=999999999999999999999.9)
            return String.format("%,.2f",money/1000000000000000000L)+"S";
        else if(money>=1000000000000000000000.0 && money<=999999999999999999999999.9)
            return String.format("%,.2f",money/1000000000000000000000.0)+"SS";
        return String.format("%,.2f",money);
    }

    public static String nextIncreaseCalculator(int contor) {
        if(contor < 25) return "Double profit at 25";
        else if(contor < 50) return "Double profit at 50";
        else if(contor < 100) return "Double profit at 100";
        else if(contor < 200) return "Double profit at 200";
        else if(contor < 300) return "Double profit at 300";
        else if(contor < 400) return "Double profit at 400";
        else if(contor < 500) return "Profit*4 at 500";
        else if(contor < 600) return "Profit*4 at 600";
        else if(contor < 700) return "Profit*4 at 700";
        else if(contor < 800) return "Profit*4 at 800";
        else if(contor < 900) return "Profit*4 at 900";
        else if(contor < 1000) return "Profit*5 at 1000";
        else if(contor < 1100) return "Profit*4 at 1100";
        else if(contor < 1200) return "Profit*4 at 1200";
        else if(contor < 1300) return "Profit*4 at 1300";
        else if(contor < 1400) return "Profit*4 at 1400";
        else if(contor < 1500) return "Profit*4 at 1500";
        else if(contor < 1600) return "Profit*4 at 1600";
        else if(contor < 1700) return "Profit*4 at 1700";
        else if(contor < 1800) return "Profit*4 at 1800";
        else if(contor < 1900) return "Profit*4 at 1900";
        else if(contor < 2000) return "Profit*5 at 2000";
        return "Max level reached";
    }

    public static int multiplicationReturn(int count)
    {
        if(count <=400) return 2;
        else if(count <=900) return 4;
        else if(count == 1000 || count == 2000) return 5;
        return 4;
    }

    private void cash_sound() { stopPlaying();mediaPlayer2=MediaPlayer.create(this,R.raw.buy_something);mediaPlayer2.start();}

    private void stopPlaying() {
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
            mediaPlayer2.release();
            mediaPlayer2 = null;
        }
    }

    public void openActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void onBackPressed(){
    }

}