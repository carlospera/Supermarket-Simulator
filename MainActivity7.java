package com.example.supermarket;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    ImageView iv_back;

    static TextView tv_achiv_completed;
    static TextView tv_achiv1,tv_achiv2,tv_achiv3,tv_achiv4,tv_achiv5,tv_achiv6,tv_achiv7,tv_achiv8,tv_achiv9,tv_achiv10,tv_achiv11,tv_achiv12,tv_achiv13,tv_achiv14,tv_achiv15,tv_achiv16,tv_achiv17,tv_achiv18,tv_achiv19,tv_achiv20;
    static ImageView iv_achiv1,iv_achiv2,iv_achiv3,iv_achiv4,iv_achiv5,iv_achiv6,iv_achiv7,iv_achiv8,iv_achiv9,iv_achiv10,iv_achiv11,iv_achiv12,iv_achiv13,iv_achiv14,iv_achiv15,iv_achiv16,iv_achiv17,iv_achiv18,iv_achiv19,iv_achiv20;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        tv_achiv_completed = findViewById(R.id.textView34);

        tv_achiv1 = findViewById(R.id.textView44);
        tv_achiv2 = findViewById(R.id.textView45);
        tv_achiv3 = findViewById(R.id.textView46);
        tv_achiv4 = findViewById(R.id.textView53);
        tv_achiv5 = findViewById(R.id.textView54);
        tv_achiv6 = findViewById(R.id.textView55);
        tv_achiv7 = findViewById(R.id.textView56);
        tv_achiv8 = findViewById(R.id.textView57);
        tv_achiv9 = findViewById(R.id.textView58);
        tv_achiv10 = findViewById(R.id.textView59);
        tv_achiv11 = findViewById(R.id.textView60);
        tv_achiv12 = findViewById(R.id.textView61);
        tv_achiv13 = findViewById(R.id.textView62);
        tv_achiv14 = findViewById(R.id.textView63);
        tv_achiv15 = findViewById(R.id.textView64);
        tv_achiv16 = findViewById(R.id.textView65);
        tv_achiv17 = findViewById(R.id.textView66);
        tv_achiv18 = findViewById(R.id.textView67);
        tv_achiv19 = findViewById(R.id.textView68);
        tv_achiv20 = findViewById(R.id.textView69);

        iv_achiv1 = findViewById(R.id.imageView25);
        iv_achiv2 = findViewById(R.id.imageView26);
        iv_achiv3 = findViewById(R.id.imageView32);
        iv_achiv4 = findViewById(R.id.imageView33);
        iv_achiv5 = findViewById(R.id.imageView34);
        iv_achiv6 = findViewById(R.id.imageView35);
        iv_achiv7 = findViewById(R.id.imageView36);
        iv_achiv8 = findViewById(R.id.imageView37);
        iv_achiv9 = findViewById(R.id.imageView38);
        iv_achiv10 = findViewById(R.id.imageView39);
        iv_achiv11 = findViewById(R.id.imageView40);
        iv_achiv12 = findViewById(R.id.imageView41);
        iv_achiv13 = findViewById(R.id.imageView42);
        iv_achiv14 = findViewById(R.id.imageView43);
        iv_achiv15 = findViewById(R.id.imageView44);
        iv_achiv16 = findViewById(R.id.imageView45);
        iv_achiv17 = findViewById(R.id.imageView46);
        iv_achiv18 = findViewById(R.id.imageView47);
        iv_achiv19 = findViewById(R.id.imageView48);
        iv_achiv20 = findViewById(R.id.imageView49);

        iv_back = findViewById(R.id.imageView19);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity4(); }
        });

        check_achievements();

    }

    @SuppressLint("SetTextI18n")
    public static void check_achievements()
    {
        int completed_achievements = 0;
        if(MainActivity2.contor_produce_dept >= 500)
        {
            completed_achievements++;
            tv_achiv1.setTextColor(Color.GREEN);
            iv_achiv1.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_produce_dept >= 1000)
            {
                completed_achievements++;
                tv_achiv9.setTextColor(Color.GREEN);
                iv_achiv9.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_bakery >= 500)
        {
            completed_achievements++;
            tv_achiv2.setTextColor(Color.GREEN);
            iv_achiv2.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_bakery >= 1000)
            {
                completed_achievements++;
                tv_achiv10.setTextColor(Color.GREEN);
                iv_achiv10.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_butcher >= 500)
        {
            completed_achievements++;
            tv_achiv3.setTextColor(Color.GREEN);
            iv_achiv3.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_butcher >= 1000)
            {
                completed_achievements++;
                tv_achiv11.setTextColor(Color.GREEN);
                iv_achiv11.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_seafood >= 500)
        {
            completed_achievements++;
            tv_achiv4.setTextColor(Color.GREEN);
            iv_achiv4.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_seafood >= 1000)
            {
                completed_achievements++;
                tv_achiv12.setTextColor(Color.GREEN);
                iv_achiv12.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_clothing >= 500)
        {
            completed_achievements++;
            tv_achiv5.setTextColor(Color.GREEN);
            iv_achiv5.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_clothing >= 1000)
            {
                completed_achievements++;
                tv_achiv13.setTextColor(Color.GREEN);
                iv_achiv13.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_perfume >= 500)
        {
            completed_achievements++;
            tv_achiv6.setTextColor(Color.GREEN);
            iv_achiv6.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_perfume >= 1000)
            {
                completed_achievements++;
                tv_achiv14.setTextColor(Color.GREEN);
                iv_achiv14.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_electronics >= 500)
        {
            completed_achievements++;
            tv_achiv7.setTextColor(Color.GREEN);
            iv_achiv7.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_electronics >= 1000)
            {
                completed_achievements++;
                tv_achiv15.setTextColor(Color.GREEN);
                iv_achiv15.setImageResource(R.drawable.checked);
            }
        }
        if(MainActivity2.contor_jewelry >= 500)
        {
            completed_achievements++;
            tv_achiv8.setTextColor(Color.GREEN);
            iv_achiv8.setImageResource(R.drawable.checked);
            if(MainActivity2.contor_jewelry >= 1000)
            {
                completed_achievements++;
                tv_achiv16.setTextColor(Color.GREEN);
                iv_achiv16.setImageResource(R.drawable.checked);
            }
        }
        tv_achiv_completed.setText(completed_achievements + "/20 completed");
    }

    public void openActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}