package com.example.supermarket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    Animation scaleUp,scaleDown;

    public static long money;
    public static long start_money;

    TextView tv_money;

    private MediaPlayer mp;

    Button b_back;
    Button buy1,buy2,buy3,buy4,buy5,buy6,buy7,buy8,buy9,buy10;
    Button buy11,buy12,buy13,buy14,buy15,buy16,buy17,buy18,buy19,buy20;
    Button buy21,buy22,buy23,buy24,buy25,buy26,buy27,buy28,buy29,buy30;
    Button buy31,buy32,buy33,buy34,buy35,buy36;

    Button sell1,sell2,sell3,sell4,sell5,sell6,sell7,sell8,sell9,sell10;
    Button sell11,sell12,sell13,sell14,sell15,sell16,sell17,sell18,sell19,sell20;
    Button sell21,sell22,sell23,sell24,sell25,sell26,sell27,sell28,sell29,sell30;
    Button sell31,sell32,sell33,sell34,sell35,sell36;

    TextView nr1,nr2,nr3,nr4,nr5,nr6,nr7,nr8,nr9,nr10;
    TextView nr11,nr12,nr13,nr14,nr15,nr16,nr17,nr18,nr19,nr20;
    TextView nr21,nr22,nr23,nr24,nr25,nr26,nr27,nr28,nr29,nr30;
    TextView nr31,nr32,nr33,nr34,nr35,nr36,receipt,receiptTotal;

    int nrr1=0,nrr2=0,nrr3=0,nrr4=0,nrr5=0,nrr6=0,nrr7=0,nrr8=0,nrr9=0,nrr10=0;
    int nrr11=0,nrr12=0,nrr13=0,nrr14=0,nrr15=0,nrr16=0,nrr17=0,nrr18=0,nrr19=0,nrr20=0;
    int nrr21=0,nrr22=0,nrr23=0,nrr24=0,nrr25=0,nrr26=0,nrr27=0,nrr28=0,nrr29=0,nrr30=0;
    int nrr31=0,nrr32=0,nrr33=0,nrr34=0,nrr35=0,nrr36=0;

    public MediaPlayer mediaPlayer1;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        mediaPlayer1 = MediaPlayer.create(MainActivity6.this,R.raw.click);
        mediaPlayer1.start();


        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        tv_money = findViewById(R.id.textView14);
        b_back = findViewById(R.id.button17);

        nr1 = findViewById(R.id.textView4);
        nr2 = findViewById(R.id.textView10);
        nr3 = findViewById(R.id.textView7);
        nr4 = findViewById(R.id.textView13);
        nr5 = findViewById(R.id.textView17);
        nr6 = findViewById(R.id.textView20);
        nr7 = findViewById(R.id.textView22);
        nr8 = findViewById(R.id.textView26);
        nr9 = findViewById(R.id.textView42);
        nr10= findViewById(R.id.textView39);
        nr11= findViewById(R.id.textView202);
        nr12= findViewById(R.id.textView205);
        nr13= findViewById(R.id.textView208);
        nr14= findViewById(R.id.textView211);
        nr15= findViewById(R.id.textView214);
        nr16= findViewById(R.id.textView217);
        nr17= findViewById(R.id.textView220);
        nr18= findViewById(R.id.textView223);
        nr19= findViewById(R.id.textView226);
        nr20= findViewById(R.id.textView229);
        nr21= findViewById(R.id.textView232);
        nr22= findViewById(R.id.textView235);
        nr23= findViewById(R.id.textView238);
        nr24= findViewById(R.id.textView241);
        nr25= findViewById(R.id.textView244);
        nr26= findViewById(R.id.textView247);
        nr27= findViewById(R.id.textView250);
        nr28= findViewById(R.id.textView253);
        nr29= findViewById(R.id.textView256);
        nr30= findViewById(R.id.textView259);
        nr31= findViewById(R.id.textView262);
        nr32= findViewById(R.id.textView265);
        nr33= findViewById(R.id.textView268);
        nr34= findViewById(R.id.textView271);
        nr35= findViewById(R.id.textView274);
        nr36= findViewById(R.id.textView277);
        receipt = findViewById(R.id.textView30);
        receiptTotal = findViewById(R.id.textView31);

        buy1 = findViewById(R.id.button9);
        buy2 = findViewById(R.id.button14);
        buy3 = findViewById(R.id.button12);
        buy4 = findViewById(R.id.button16);
        buy5 = findViewById(R.id.button19);
        buy6 = findViewById(R.id.button21);
        buy7 = findViewById(R.id.button24);
        buy8 = findViewById(R.id.button26);
        buy9 = findViewById(R.id.button42);
        buy10 = findViewById(R.id.button29);
        buy11 = findViewById(R.id.button301);
        buy12 = findViewById(R.id.button303);
        buy13 = findViewById(R.id.button305);
        buy14 = findViewById(R.id.button307);
        buy15 = findViewById(R.id.button309);
        buy16 = findViewById(R.id.button311);
        buy17 = findViewById(R.id.button313);
        buy18 = findViewById(R.id.button315);
        buy19 = findViewById(R.id.button317);
        buy20 = findViewById(R.id.button319);
        buy21 = findViewById(R.id.button321);
        buy22 = findViewById(R.id.button323);
        buy23 = findViewById(R.id.button325);
        buy24 = findViewById(R.id.button327);
        buy25 = findViewById(R.id.button329);
        buy26 = findViewById(R.id.button331);
        buy27 = findViewById(R.id.button333);
        buy28 = findViewById(R.id.button335);
        buy29 = findViewById(R.id.button337);
        buy30 = findViewById(R.id.button339);
        buy31 = findViewById(R.id.button341);
        buy32 = findViewById(R.id.button343);
        buy33 = findViewById(R.id.button345);
        buy34 = findViewById(R.id.button347);
        buy35 = findViewById(R.id.button349);
        buy36 = findViewById(R.id.button351);

        sell1 = findViewById(R.id.button10);
        sell2 = findViewById(R.id.button13);
        sell3 = findViewById(R.id.button11);
        sell4 = findViewById(R.id.button15);
        sell5 = findViewById(R.id.button18);
        sell6 = findViewById(R.id.button20);
        sell7 = findViewById(R.id.button23);
        sell8 = findViewById(R.id.button25);
        sell9 = findViewById(R.id.button40);
        sell10 = findViewById(R.id.button27);
        sell11 = findViewById(R.id.button300);
        sell12 = findViewById(R.id.button302);
        sell13 = findViewById(R.id.button304);
        sell14 = findViewById(R.id.button306);
        sell15 = findViewById(R.id.button308);
        sell16 = findViewById(R.id.button310);
        sell17 = findViewById(R.id.button312);
        sell18 = findViewById(R.id.button314);
        sell19 = findViewById(R.id.button316);
        sell20 = findViewById(R.id.button318);
        sell21 = findViewById(R.id.button320);
        sell22 = findViewById(R.id.button322);
        sell23 = findViewById(R.id.button324);
        sell24 = findViewById(R.id.button326);
        sell25 = findViewById(R.id.button328);
        sell26 = findViewById(R.id.button330);
        sell27 = findViewById(R.id.button332);
        sell28 = findViewById(R.id.button334);
        sell29 = findViewById(R.id.button336);
        sell30 = findViewById(R.id.button338);
        sell31 = findViewById(R.id.button340);
        sell32 = findViewById(R.id.button342);
        sell33 = findViewById(R.id.button344);
        sell34 = findViewById(R.id.button346);
        sell35 = findViewById(R.id.button348);
        sell36 = findViewById(R.id.button350);

        money = (long) MainActivity2.money;
        start_money = money;

        money_print(money);
        update_receipt();

        Toast mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        mToast.setText("No money left for this purchase");
        
        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy1.startAnimation(scaleUp);
                    nrr1++;
                    nr1.setText(""+nrr1);
                    money-=1;
                    money_print(money);update_receipt();
                    buy1.startAnimation(scaleDown);
                }
            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-2<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy2.startAnimation(scaleUp);
                    nrr2++;
                    nr2.setText(""+nrr2);
                    money-=2;
                    money_print(money);update_receipt();
                    buy2.startAnimation(scaleDown);
                }
            }
        });
        buy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-9<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy3.startAnimation(scaleUp);
                    nrr3++;
                    nr3.setText(""+nrr3);
                    money-=9;
                    money_print(money);update_receipt();
                    buy3.startAnimation(scaleDown);
                }
            }
        });
        buy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-10<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy4.startAnimation(scaleUp);
                    nrr4++;
                    nr4.setText(""+nrr4);
                    money-=10;
                    money_print(money);update_receipt();
                    buy4.startAnimation(scaleDown);
                }
            }
        });
        buy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-20<0) 
                    mToast.show();
                else
                {
                    buyraw();
                    buy5.startAnimation(scaleUp);
                    nrr5++;
                    nr5.setText(""+nrr5);
                    money-=20;
                    money_print(money);update_receipt();
                    buy5.startAnimation(scaleDown);
                }
            }
        });
        buy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-50<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy6.startAnimation(scaleUp);
                    nrr6++;
                    nr6.setText(""+nrr6);
                    money-=50;
                    money_print(money);update_receipt();
                    buy6.startAnimation(scaleDown);
                }
            }
        });
        buy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-100<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy7.startAnimation(scaleUp);
                    nrr7++;
                    nr7.setText(""+nrr7);
                    money-=100;
                    money_print(money);update_receipt();
                    buy7.startAnimation(scaleDown);
                }
            }
        });
        buy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-150<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy8.startAnimation(scaleUp);
                    nrr8++;
                    nr8.setText(""+nrr8);
                    money-=150;
                    money_print(money);update_receipt();
                    buy8.startAnimation(scaleDown);
                }
            }
        });
        buy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-200<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy9.startAnimation(scaleUp);
                    nrr9++;
                    nr9.setText(""+nrr9);
                    money-=200;
                    money_print(money);update_receipt();
                    buy9.startAnimation(scaleDown);
                }
            }
        });
        buy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-500<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy10.startAnimation(scaleUp);
                    nrr10++;
                    nr10.setText(""+nrr10);
                    money-=500;
                    money_print(money);update_receipt();
                    buy10.startAnimation(scaleDown);
                }
            }
        });
        buy11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-500<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy11.startAnimation(scaleUp);
                    nrr11++;
                    nr11.setText(""+nrr11);
                    money-=500;
                    money_print(money);update_receipt();
                    buy11.startAnimation(scaleDown);
                }
            }
        });
        buy12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-800<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy12.startAnimation(scaleUp);
                    nrr12++;
                    nr12.setText(""+nrr12);
                    money-=800;
                    money_print(money);update_receipt();
                    buy12.startAnimation(scaleDown);
                }
            }
        });
        buy13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy13.startAnimation(scaleUp);
                    nrr13++;
                    nr13.setText(""+nrr13);
                    money-=1000;
                    money_print(money);update_receipt();
                    buy13.startAnimation(scaleDown);
                }
            }
        });
        buy14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1500<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy14.startAnimation(scaleUp);
                    nrr14++;
                    nr14.setText(""+nrr14);
                    money-=1500;
                    money_print(money);update_receipt();
                    buy14.startAnimation(scaleDown);
                }
            }
        });
        buy15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-2000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy15.startAnimation(scaleUp);
                    nrr15++;
                    nr15.setText(""+nrr15);
                    money-=2000;
                    money_print(money);update_receipt();
                    buy15.startAnimation(scaleDown);
                }
            }
        });
        buy16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-3000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy16.startAnimation(scaleUp);
                    nrr16++;
                    nr16.setText(""+nrr16);
                    money-=3000;
                    money_print(money);update_receipt();
                    buy16.startAnimation(scaleDown);
                }
            }
        });
        buy17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-5000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy17.startAnimation(scaleUp);
                    nrr17++;
                    nr17.setText(""+nrr17);
                    money-=5000;
                    money_print(money);update_receipt();
                    buy17.startAnimation(scaleDown);
                }
            }
        });
        buy18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-15000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy18.startAnimation(scaleUp);
                    nrr18++;
                    nr18.setText(""+nrr18);
                    money-=15000;
                    money_print(money);update_receipt();
                    buy18.startAnimation(scaleDown);
                }
            }
        });
        buy19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-30000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy19.startAnimation(scaleUp);
                    nrr19++;
                    nr19.setText(""+nrr19);
                    money-=30000;
                    money_print(money);update_receipt();
                    buy19.startAnimation(scaleDown);
                }
            }
        });
        buy20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-35000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy20.startAnimation(scaleUp);
                    nrr20++;
                    nr20.setText(""+nrr20);
                    money-=35000;
                    money_print(money);update_receipt();
                    buy20.startAnimation(scaleDown);
                }
            }
        });
        buy21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-75000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy21.startAnimation(scaleUp);
                    nrr21++;
                    nr21.setText(""+nrr21);
                    money-=75000;
                    money_print(money);update_receipt();
                    buy21.startAnimation(scaleDown);
                }
            }
        });
        buy22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-100000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy22.startAnimation(scaleUp);
                    nrr22++;
                    nr22.setText(""+nrr22);
                    money-=100000;
                    money_print(money);update_receipt();
                    buy22.startAnimation(scaleDown);
                }
            }
        });
        buy23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-250000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy23.startAnimation(scaleUp);
                    nrr23++;
                    nr23.setText(""+nrr23);
                    money-=250000;
                    money_print(money);update_receipt();
                    buy23.startAnimation(scaleDown);
                }
            }
        });
        buy24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-315000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy24.startAnimation(scaleUp);
                    nrr24++;
                    nr24.setText(""+nrr24);
                    money-=315000;
                    money_print(money);update_receipt();
                    buy24.startAnimation(scaleDown);
                }
            }
        });
        buy25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-800000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy25.startAnimation(scaleUp);
                    nrr25++;
                    nr25.setText(""+nrr25);
                    money-=800000;
                    money_print(money);update_receipt();
                    buy25.startAnimation(scaleDown);
                }
            }
        });
        buy26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy26.startAnimation(scaleUp);
                    nrr26++;
                    nr26.setText(""+nrr26);
                    money-=1000000;
                    money_print(money);update_receipt();
                    buy26.startAnimation(scaleDown);
                }
            }
        });
        buy27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-2000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy27.startAnimation(scaleUp);
                    nrr27++;
                    nr27.setText(""+nrr27);
                    money-=2000000;
                    money_print(money);update_receipt();
                    buy27.startAnimation(scaleDown);
                }
            }
        });
        buy28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-3000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy28.startAnimation(scaleUp);
                    nrr28++;
                    nr28.setText(""+nrr28);
                    money-=3000000;
                    money_print(money);update_receipt();
                    buy28.startAnimation(scaleDown);
                }
            }
        });
        buy29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-7000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy29.startAnimation(scaleUp);
                    nrr29++;
                    nr29.setText(""+nrr29);
                    money-=7000000;
                    money_print(money);update_receipt();
                    buy29.startAnimation(scaleDown);
                }
            }
        });
        buy30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-10000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy30.startAnimation(scaleUp);
                    nrr30++;
                    nr30.setText(""+nrr30);
                    money-=10000000;
                    money_print(money);update_receipt();
                    buy30.startAnimation(scaleDown);
                }
            }
        });
        buy31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-12000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy31.startAnimation(scaleUp);
                    nrr31++;
                    nr31.setText(""+nrr31);
                    money-=12000000;
                    money_print(money);update_receipt();
                    buy31.startAnimation(scaleDown);
                }
            }
        });
        buy32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-420000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy32.startAnimation(scaleUp);
                    nrr32++;
                    nr32.setText(""+nrr32);
                    money-=420000000;
                    money_print(money);update_receipt();
                    buy32.startAnimation(scaleDown);
                }
            }
        });
        buy33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-550000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy33.startAnimation(scaleUp);
                    nrr33++;
                    nr33.setText(""+nrr33);
                    money-=550000000;
                    money_print(money);update_receipt();
                    buy33.startAnimation(scaleDown);
                }
            }
        });
        buy34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-800000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy34.startAnimation(scaleUp);
                    nrr34++;
                    nr34.setText(""+nrr34);
                    money-=800000000;
                    money_print(money);update_receipt();
                    buy34.startAnimation(scaleDown);
                }
            }
        });
        buy35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1000000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy35.startAnimation(scaleUp);
                    nrr35++;
                    nr35.setText(""+nrr35);
                    money-=1000000000;
                    money_print(money);update_receipt();
                    buy35.startAnimation(scaleDown);
                }
            }
        });
        buy36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money-1500000000<0)
                    mToast.show();
                else
                {
                    buyraw();
                    buy36.startAnimation(scaleUp);
                    nrr36++;
                    nr36.setText(""+nrr36);
                    money-=1500000000;
                    money_print(money);update_receipt();
                    buy36.startAnimation(scaleDown);
                }
            }
        });






        sell1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell1.startAnimation(scaleUp);
                money+=nrr1;
                nrr1=0;
                nr1.setText(""+nrr1);
                money_print(money);update_receipt();
                sell1.startAnimation(scaleDown);
            } 
            
        });
        sell2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell2.startAnimation(scaleUp);
                money+=nrr2*2;
                nrr2=0;
                nr2.setText(""+nrr2);
                money_print(money);update_receipt();
                sell2.startAnimation(scaleDown);
            } 
            
        });
        sell3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell3.startAnimation(scaleUp);
                money+=nrr3*9;
                nrr3=0;
                nr3.setText(""+nrr3);
                money_print(money);update_receipt();
                sell3.startAnimation(scaleDown);
            } 
            
        });
        sell4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell4.startAnimation(scaleUp);
                money+=nrr4*10;
                nrr4=0;
                nr4.setText(""+nrr4);
                money_print(money);update_receipt();
                sell4.startAnimation(scaleDown);
            } 
            
        });
        sell5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell5.startAnimation(scaleUp);
                money+=nrr5*20;
                nrr5=0;
                nr5.setText(""+nrr5);
                money_print(money);update_receipt();
                sell5.startAnimation(scaleDown);
            } 
            
        });
        sell6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell6.startAnimation(scaleUp);
                money+=nrr6*50;
                nrr6=0;
                nr6.setText(""+nrr6);
                money_print(money);update_receipt();
                sell6.startAnimation(scaleDown);
            } 
            
        });
        sell7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell7.startAnimation(scaleUp);
                money+=nrr7*100;
                nrr7=0;
                nr7.setText(""+nrr7);
                money_print(money);update_receipt();
                sell7.startAnimation(scaleDown);
            } 
            
        });
        sell8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell8.startAnimation(scaleUp);
                money+=nrr8*150;
                nrr8=0;
                nr8.setText(""+nrr8);
                money_print(money);update_receipt();
                sell8.startAnimation(scaleDown);
            } 
            
        });
        sell9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell9.startAnimation(scaleUp);
                money+=nrr9*200;
                nrr9=0;
                nr9.setText(""+nrr9);
                money_print(money);update_receipt();
                sell9.startAnimation(scaleDown);
            } 
            
        });
        sell10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell10.startAnimation(scaleUp);
                money+=nrr10*500;
                nrr10=0;
                nr10.setText(""+nrr10);
                money_print(money);update_receipt();
                sell10.startAnimation(scaleDown);
            } 
            
        });
        sell11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell11.startAnimation(scaleUp);
                money+=nrr11*500;
                nrr11=0;
                nr11.setText(""+nrr11);
                money_print(money);update_receipt();
                sell11.startAnimation(scaleDown);
            } 
            
        });
        sell12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell12.startAnimation(scaleUp);
                money+=nrr12*800;
                nrr12=0;
                nr12.setText(""+nrr12);
                money_print(money);update_receipt();
                sell12.startAnimation(scaleDown);
            } 
            
        });
        sell13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell13.startAnimation(scaleUp);
                money+=nrr13*1000;
                nrr13=0;
                nr13.setText(""+nrr13);
                money_print(money);update_receipt();
                sell13.startAnimation(scaleDown);
            } 
            
        });
        sell14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell14.startAnimation(scaleUp);
                money+=nrr14*1500;
                nrr14=0;
                nr14.setText(""+nrr14);
                money_print(money);update_receipt();
                sell14.startAnimation(scaleDown);
            } 
            
        });
        sell15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell15.startAnimation(scaleUp);
                money+=nrr15*2000;
                nrr15=0;
                nr15.setText(""+nrr15);
                money_print(money);update_receipt();
                sell15.startAnimation(scaleDown);
            } 
            
        });
        sell16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell16.startAnimation(scaleUp);
                money+=nrr16*3000;
                nrr16=0;
                nr16.setText(""+nrr16);
                money_print(money);update_receipt();
                sell16.startAnimation(scaleDown);
            } 
            
        });
        sell17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell17.startAnimation(scaleUp);
                money+=nrr17*5000;
                nrr17=0;
                nr17.setText(""+nrr17);
                money_print(money);update_receipt();
                sell17.startAnimation(scaleDown);
            } 
            
        });
        sell18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell18.startAnimation(scaleUp);
                money+=nrr18*15000;
                nrr18=0;
                nr18.setText(""+nrr18);
                money_print(money);update_receipt();
                sell18.startAnimation(scaleDown);
            } 
            
        });
        sell19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell19.startAnimation(scaleUp);
                money+=nrr19*30000;
                nrr19=0;
                nr19.setText(""+nrr19);
                money_print(money);update_receipt();
                sell19.startAnimation(scaleDown);
            } 
            
        });
        sell20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell20.startAnimation(scaleUp);
                money+=nrr20*35000;
                nrr20=0;
                nr20.setText(""+nrr20);
                money_print(money);update_receipt();
                sell20.startAnimation(scaleDown);
            } 
            
        });
        sell21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell21.startAnimation(scaleUp);
                money+=nrr21*75000;
                nrr21=0;
                nr21.setText(""+nrr21);
                money_print(money);update_receipt();
                sell21.startAnimation(scaleDown);
            } 
            
        });
        sell22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell22.startAnimation(scaleUp);
                money+=nrr22*100000;
                nrr22=0;
                nr22.setText(""+nrr22);
                money_print(money);update_receipt();
                sell22.startAnimation(scaleDown);
            } 
            
        });
        sell23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell23.startAnimation(scaleUp);
                money+=nrr23*250000;
                nrr23=0;
                nr23.setText(""+nrr23);
                money_print(money);update_receipt();
                sell23.startAnimation(scaleDown);
            } 
            
        });
        sell24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell24.startAnimation(scaleUp);
                money+=nrr24*315000;
                nrr24=0;
                nr24.setText(""+nrr24);
                money_print(money);update_receipt();
                sell24.startAnimation(scaleDown);
            } 
            
        });
        sell25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell25.startAnimation(scaleUp);
                money+=nrr25*800000;
                nrr25=0;
                nr25.setText(""+nrr25);
                money_print(money);update_receipt();
                sell25.startAnimation(scaleDown);
            } 
            
        });
        sell26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell26.startAnimation(scaleUp);
                money+=nrr26*1000000;
                nrr26=0;
                nr26.setText(""+nrr26);
                money_print(money);update_receipt();
                sell26.startAnimation(scaleDown);
            } 
            
        });
        sell27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell27.startAnimation(scaleUp);
                money+=nrr27*2000000;
                nrr27=0;
                nr27.setText(""+nrr27);
                money_print(money);update_receipt();
                sell27.startAnimation(scaleDown);
            } 
            
        });
        sell28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell28.startAnimation(scaleUp);
                money+=nrr28*3000000;
                nrr28=0;
                nr28.setText(""+nrr28);
                money_print(money);update_receipt();
                sell28.startAnimation(scaleDown);
            } 
            
        });
        sell29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell29.startAnimation(scaleUp);
                money+=nrr29*7000000;
                nrr29=0;
                nr29.setText(""+nrr29);
                money_print(money);update_receipt();
                sell29.startAnimation(scaleDown);
            } 
            
        });
        sell30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell30.startAnimation(scaleUp);
                money+=nrr30*10000000;
                nrr30=0;
                nr30.setText(""+nrr30);
                money_print(money);update_receipt();
                sell30.startAnimation(scaleDown);
            } 
            
        });
        sell31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell31.startAnimation(scaleUp);
                money+=nrr31*12000000;
                nrr31=0;
                nr31.setText(""+nrr31);
                money_print(money);update_receipt();
                sell31.startAnimation(scaleDown);
            } 
            
        });
        sell32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell32.startAnimation(scaleUp);
                money+=nrr32*420000000L;
                nrr32=0;
                nr32.setText(""+nrr32);
                money_print(money);update_receipt();
                sell32.startAnimation(scaleDown);
            } 
            
        });
        sell33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell33.startAnimation(scaleUp);
                money+=nrr33*550000000L;
                nrr33=0;
                nr33.setText(""+nrr33);
                money_print(money);update_receipt();
                sell33.startAnimation(scaleDown);
            } 
            
        });
        sell34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell34.startAnimation(scaleUp);
                money+=nrr34*800000000L;
                nrr34=0;
                nr34.setText(""+nrr34);
                money_print(money);update_receipt();
                sell34.startAnimation(scaleDown);
            } 
            
        });
        sell35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell35.startAnimation(scaleUp);
                money+=nrr35*1000000000L;
                nrr35=0;
                nr35.setText(""+nrr35);
                money_print(money);update_receipt();
                sell35.startAnimation(scaleDown);
            } 
            
        });
        sell36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sellraw();
                sell36.startAnimation(scaleUp);
                money+=nrr36*1500000000L;
                nrr36=0;
                nr36.setText(""+nrr36);
                money_print(money);update_receipt();
                sell36.startAnimation(scaleDown);
            } 
            
        });

        b_back.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                b_back.startAnimation(scaleUp);
                openActivity4();
            } else if (event.getAction() == MotionEvent.ACTION_UP)
                b_back.startAnimation(scaleDown);
            return true;
        });
    }

    @SuppressLint("SetTextI18n")
    private void update_receipt()
    {
        receipt.setGravity(Gravity.CENTER);
        receipt.setText("Receipt:\n");
        boolean empty = true;
        if(nrr1>0){receipt.setText(receipt.getText()+ "\nSoda Can x" + nrr1 + " $" + nrr1);empty=false;}
        if(nrr2>0){receipt.setText(receipt.getText()+"\nBurger x" + nrr2 + " $" + nrr2*2L);empty=false;}
        if(nrr3>0){receipt.setText(receipt.getText()+"\nTV Streaming x" + nrr3 + "  $" + nrr3*9L);empty=false;}
        if(nrr4>0){receipt.setText(receipt.getText()+"\nT Shirt x" + nrr4 + "  $" + nrr4*10L);empty=false;}
        if(nrr5>0){receipt.setText(receipt.getText()+"\nRestuarant Meal x" + nrr5 + "  $" + nrr5*20L);empty=false;}
        if(nrr6>0){receipt.setText(receipt.getText()+"\nRent a Car x" + nrr6 + "  $" + nrr6*50L);empty=false;}
        if(nrr7>0){receipt.setText(receipt.getText()+"\nRobot Vacuum x" + nrr7 + "  $" + nrr7*100L);empty=false;}
        if(nrr8>0){receipt.setText(receipt.getText()+"\nHeadphones x" + nrr8 + "  $" + nrr8*150L);empty=false;}
        if(nrr9>0){receipt.setText(receipt.getText()+"\nSneakers x" + nrr9 + "  $" + nrr9*200L);empty=false;}
        if(nrr10>0){receipt.setText(receipt.getText()+"\nDSLR Camera x" + nrr10 + "  $" + nrr10*500L);empty=false;}
        if(nrr11>0){receipt.setText(receipt.getText()+"\nGaming Console x" + nrr11 + "  $" + nrr11*500L);empty=false;}
        if(nrr12>0){receipt.setText(receipt.getText()+"\nSmartphone x" + nrr12 + "  $" + nrr12*800L);empty=false;}
        if(nrr13>0){receipt.setText(receipt.getText()+"\nGaming PC x" + nrr13 + "  $" + nrr13*1000L);empty=false;}
        if(nrr14>0){receipt.setText(receipt.getText()+"\nElectic Bike x" + nrr14 + "  $" + nrr14*1500L);empty=false;}
        if(nrr15>0){receipt.setText(receipt.getText()+"\n7 Days Vacation x" + nrr15 + "  $" + nrr15*2000L);empty=false;}
        if(nrr16>0){receipt.setText(receipt.getText()+"\nPenthouse Rent x" + nrr16 + "  $" + nrr16*3000L);empty=false;}
        if(nrr17>0){receipt.setText(receipt.getText()+"\nRare Sneakers x" + nrr17 + "  $" + nrr17*5000L);empty=false;}
        if(nrr18>0){receipt.setText(receipt.getText()+"\nCheap New Car x" + nrr18 + "  $" + nrr18*1500L);empty=false;}
        if(nrr19>0){receipt.setText(receipt.getText()+"\nLuxury Watch x" + nrr19 + "  $" + nrr19*3000L);empty=false;}
        if(nrr20>0){receipt.setText(receipt.getText()+"\nPool x" + nrr20 + "  $" + nrr20*35000L);empty=false;}
        if(nrr21>0){receipt.setText(receipt.getText()+"\nElectric Car x" + nrr21 + "  $" + nrr21*75000L);empty=false;}
        if(nrr22>0){receipt.setText(receipt.getText()+"\nSemi Truck x" + nrr22 + "  $" + nrr22*100000L);empty=false;}
        if(nrr23>0){receipt.setText(receipt.getText()+"\nSupercar x" + nrr23 + "  $" + nrr23*250000L);empty=false;}
        if(nrr24>0){receipt.setText(receipt.getText()+"\nCoffe Shop x" + nrr24 + "  $" + nrr24*315000L);empty=false;}
        if(nrr25>0){receipt.setText(receipt.getText()+"\nPenthouse x" + nrr25 + "  $" + nrr25*800000L);empty=false;}
        if(nrr26>0){receipt.setText(receipt.getText()+"\nFastFood x" + nrr26 + "  $" + nrr26*1000000L);empty=false;}
        if(nrr27>0){receipt.setText(receipt.getText()+"\nExotic Car x" + nrr27 + "  $" + nrr27*2000000L);empty=false;}
        if(nrr28>0){receipt.setText(receipt.getText()+"\nWind Turbine x" + nrr28 + "  $" + nrr28*3000000L);empty=false;}
        if(nrr29>0){receipt.setText(receipt.getText()+"\nYacht x" + nrr29 + "  $" + nrr29*7000000L);empty=false;}
        if(nrr30>0){receipt.setText(receipt.getText()+"\nTower Block x" + nrr30 + "  $" + nrr30*10000000L);empty=false;}
        if(nrr31>0){receipt.setText(receipt.getText()+"\nF1 Car x" + nrr31 + "  $" + nrr31*12000000L);empty=false;}
        if(nrr32>0){receipt.setText(receipt.getText()+"\nPlane x" + nrr32 + "  $" + nrr32*420000000L);empty=false;}
        if(nrr33>0){receipt.setText(receipt.getText()+"\nCruise Ship x" + nrr33 + "  $" + nrr33*550000000L);empty=false;}
        if(nrr34>0){receipt.setText(receipt.getText()+"\nSkyscraper x" + nrr34 + "  $" + nrr34*800000000L);empty=false;}
        if(nrr35>0){receipt.setText(receipt.getText()+"\nFootball Team x" + nrr35 + "  $" + nrr35*1000000000L);empty=false;}
        if(nrr36>0){receipt.setText(receipt.getText()+"\nBurj Khalifa x" + nrr36 + "  $" + nrr36*1500000000L);empty=false;}
        if(empty) receipt.setText(receipt.getText()+"\nNo purchase yet.");
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        receipt.setText(receipt.getText() + "\n\nThe dream store\n"+date);
        receiptTotal.setGravity(Gravity.CENTER);
        long total = start_money-money;
        receiptTotal.setText("Total : $" + format_money_display((double) total));
    }

    @SuppressLint("SetTextI18n")
    private void money_print(long money)
    {
        tv_money.setText(format_money_display((double) money) + "$");
    }

    @SuppressLint("DefaultLocale")
    public static String format_money_display(Double money)
    {
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

    private void openActivity4() {
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    private void buyraw() {if(MainActivity.sound_on){stopPlaying();mp = MediaPlayer.create(this,R.raw.buy_something);mp.start();}}

    private void sellraw() {if(MainActivity.sound_on){stopPlaying();mp = MediaPlayer.create(this,R.raw.sell_something);mp.start();}}

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void onBackPressed () {
    }

}