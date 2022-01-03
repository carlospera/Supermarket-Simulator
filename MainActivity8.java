package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity8 extends AppCompatActivity {
    TextView tv_costGOOG,tv_costFB,tv_costAAPL,tv_costSMSN;
    TextView tv_money;
    Button b_buyGOOG,b_buyFB,b_buyAAPL,b_buySMSN;
    Button b_sellGOOG,b_sellFB,b_sellAAPL,b_sellSMSN;
    Button b_back;
    Button b_contorGOOG,b_contorFB,b_contorAAPL,b_contorSMSN;
    static double costGOOG;
    static double costFB;
    static double costAAPL;
    static double costSMSN;
    static int contorGOOG;
    static int contorFB;
    static int contorAAPL;
    static int contorSMSN ;
    static double moneyInGOOG;
    static double moneyInFB;
    static double moneyInAAPL;
    static double moneyInSMSN;
    ImageView iv_arrowGOOG,iv_arrowFB,iv_arrowAAPL,iv_arrowSMSN;
    TextView tv_arrowGOOG,tv_arrowFB,tv_arrowAAPL,tv_arrowSMSN;
    Animation scaleUp,scaleDown;
    TextView tv_moneyInGOOG,tv_moneyInFB,tv_moneyInAAPL,tv_moneyInSMSN;
    public static final String FILE_NAME = "example2.txt";

    Random random = new Random();
    double flux;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            text = br.readLine();
            String[] arrOfStr = text.split("x");

            costGOOG = Double.parseDouble(arrOfStr[0]);
            costFB = Double.parseDouble(arrOfStr[1]);
            costAAPL = Double.parseDouble(arrOfStr[2]);
            costSMSN = Double.parseDouble(arrOfStr[3]);

            contorGOOG = Integer.parseInt(arrOfStr[4]);
            contorFB = Integer.parseInt(arrOfStr[5]);
            contorAAPL = Integer.parseInt(arrOfStr[6]);
            contorSMSN = Integer.parseInt(arrOfStr[7]);

            moneyInGOOG = Double.parseDouble(arrOfStr[8]);
            moneyInFB = Double.parseDouble(arrOfStr[9]);
            moneyInAAPL = Double.parseDouble(arrOfStr[10]);
            moneyInSMSN = Double.parseDouble(arrOfStr[11]);
            if(costGOOG == 0 || costSMSN == 0 || costFB == 0 || costAAPL == 0) {
                costGOOG = 1000;
                costFB = 10000;
                costAAPL = 100000;
                costSMSN = 1000000;

                contorGOOG = 0;
                contorFB = 0;
                contorAAPL = 0;
                contorSMSN = 0;

                moneyInGOOG = 0;
                moneyInFB = 0;
                moneyInAAPL = 0;
                moneyInSMSN = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //for delay
        tv_money = findViewById(R.id.textView70);
        tv_money.setText(format_money_display(MainActivity2.money)+"$");

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        tv_costGOOG = findViewById(R.id.textView72);
        tv_costGOOG.setText(""+format_money_display(costGOOG));
        tv_costFB = findViewById(R.id.textView75);
        tv_costFB.setText(""+format_money_display(costFB));
        tv_costAAPL = findViewById(R.id.textView77);
        tv_costAAPL.setText(""+format_money_display(costAAPL));
        tv_costSMSN = findViewById(R.id.textView79);
        tv_costSMSN.setText(""+format_money_display(costSMSN));

        iv_arrowGOOG = findViewById(R.id.imageView63);
        iv_arrowFB = findViewById(R.id.imageView64);
        iv_arrowAAPL = findViewById(R.id.imageView65);
        iv_arrowSMSN = findViewById(R.id.imageView66);

        tv_arrowGOOG = findViewById(R.id.textView74);
        tv_arrowFB = findViewById(R.id.textView81);
        tv_arrowAAPL = findViewById(R.id.textView82);
        tv_arrowSMSN = findViewById(R.id.textView83);

        b_buyGOOG = findViewById(R.id.button73);
        b_buyGOOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity2.money-costGOOG >= 0) {
                    animation(b_buyGOOG);
                    MainActivity2.money -= costGOOG;
                    contorGOOG++;
                    b_contorGOOG.setText(""+contorGOOG);
                    moneyInGOOG += costGOOG;
                }
            }
        });

        b_buyFB = findViewById(R.id.button77);
        b_buyFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity2.money-costFB >= 0) {
                    animation(b_buyFB);
                    MainActivity2.money -= costFB;
                    contorFB++;
                    b_contorFB.setText(""+contorFB);
                    moneyInFB += costFB;
                }
            }
        });

        b_buyAAPL = findViewById(R.id.button80);
        b_buyAAPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity2.money-costAAPL >= 0) {
                    animation(b_buyAAPL);
                    MainActivity2.money -= costAAPL;
                    contorAAPL++;
                    b_contorAAPL.setText(""+contorAAPL);
                    moneyInAAPL += costAAPL;
                }
            }
        });

        b_buySMSN = findViewById(R.id.button83);
        b_buySMSN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity2.money-costSMSN >= 0) {
                    animation(b_buySMSN);
                    MainActivity2.money -= costSMSN;
                    contorSMSN++;
                    b_contorSMSN.setText(""+contorSMSN);
                    moneyInSMSN += costSMSN;
                }
            }
        });

        b_sellGOOG = findViewById(R.id.button74);
        b_sellGOOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contorGOOG>0) {
                    animation(b_sellGOOG);
                    MainActivity2.money += contorGOOG*costGOOG;
                    contorGOOG = 0;
                    moneyInGOOG = 0;
                    b_contorGOOG.setText(""+contorGOOG);
                    tv_moneyInGOOG.setText("0");
                    tv_moneyInGOOG.setTextColor(Color.BLACK);
                }
            }
        });

        b_sellFB = findViewById(R.id.button76);
        b_sellFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contorFB>0) {
                    animation(b_sellFB);
                    MainActivity2.money += contorFB*costFB;
                    contorFB = 0;
                    moneyInFB = 0;
                    b_contorFB.setText(""+contorFB);
                    tv_moneyInFB.setText("0");
                    tv_moneyInFB.setTextColor(Color.BLACK);
                }
            }
        });

        b_sellAAPL = findViewById(R.id.button79);
        b_sellAAPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contorAAPL>0) {
                    animation(b_sellAAPL);
                    MainActivity2.money += contorAAPL*costAAPL;
                    contorAAPL = 0;
                    moneyInAAPL = 0;
                    b_contorAAPL.setText(""+contorAAPL);
                    tv_moneyInAAPL.setText("0");
                    tv_moneyInAAPL.setTextColor(Color.BLACK);
                }
            }
        });

        b_sellSMSN = findViewById(R.id.button82);
        b_sellSMSN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contorSMSN>0) {
                    animation(b_sellSMSN);
                    MainActivity2.money += contorSMSN*costSMSN;
                    contorSMSN = 0;
                    moneyInSMSN = 0;
                    b_contorSMSN.setText(""+contorSMSN);
                    tv_moneyInSMSN.setText("0");
                    tv_moneyInSMSN.setTextColor(Color.BLACK);
                }
            }
        });

        b_contorGOOG = findViewById(R.id.button85);
        b_contorFB = findViewById(R.id.button86);
        b_contorAAPL = findViewById(R.id.button87);
        b_contorSMSN = findViewById(R.id.button89);

        b_contorGOOG.setText(""+contorGOOG);
        b_contorFB.setText(""+contorFB);
        b_contorAAPL.setText(""+contorAAPL);
        b_contorSMSN.setText(""+contorSMSN);

        tv_moneyInGOOG = findViewById(R.id.textView84);
        tv_moneyInFB = findViewById(R.id.textView85);
        tv_moneyInAAPL = findViewById(R.id.textView86);
        tv_moneyInSMSN = findViewById(R.id.textView87);

        tv_moneyInGOOG.setText(""+moneyInGOOG);
        tv_moneyInFB.setText(""+moneyInFB);
        tv_moneyInAAPL.setText(""+moneyInAAPL);
        tv_moneyInSMSN.setText(""+moneyInSMSN);

        b_back = findViewById(R.id.button71);
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
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
                                tv_money.setText(format_money_display(MainActivity2.money)+"$");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t1.start();

        Thread t = new Thread()
        {
            public void run()
            {
                try {
                    while(!isInterrupted())
                    {
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                flux = random.nextDouble()*(1.1-0.9) + 0.9;
                                costGOOG *=  flux;
                                if(flux > 1.0) {
                                    iv_arrowGOOG.setImageResource(R.drawable.green_arrow);
                                    tv_arrowGOOG.setTextColor(Color.GREEN);
                                    tv_arrowGOOG.setText((int)(flux*100%100) + "%");
                                }
                                else if(flux < 1.0) {
                                    iv_arrowGOOG.setImageResource(R.drawable.red_arrow);
                                    tv_arrowGOOG.setTextColor(Color.RED);
                                    tv_arrowGOOG.setText((int)(100-(flux*100%100)) + "%");
                                }
                                else {
                                    iv_arrowGOOG.setImageResource(R.drawable.blank_arrow);
                                    tv_arrowGOOG.setTextColor(Color.BLACK);
                                    tv_arrowGOOG.setText("0%");
                                }

                                flux = random.nextDouble()*(1.1-0.9) + 0.9;
                                costFB *=  flux;
                                if(flux > 1.0) {
                                    iv_arrowFB.setImageResource(R.drawable.green_arrow);
                                    tv_arrowFB.setTextColor(Color.GREEN);
                                    tv_arrowFB.setText((int)(flux*100%100) + "%");
                                }
                                else if(flux < 1.0) {
                                    iv_arrowFB.setImageResource(R.drawable.red_arrow);
                                    tv_arrowFB.setTextColor(Color.RED);
                                    tv_arrowFB.setText((int)(100-(flux*100%100)) + "%");
                                }
                                else {
                                    iv_arrowFB.setImageResource(R.drawable.blank_arrow);
                                    tv_arrowFB.setTextColor(Color.BLACK);
                                    tv_arrowFB.setText("0%");
                                }


                                flux = random.nextDouble()*(1.1-0.9) + 0.9;
                                costAAPL *=  flux;
                                if(flux > 1.0) {
                                    iv_arrowAAPL.setImageResource(R.drawable.green_arrow);
                                    tv_arrowAAPL.setTextColor(Color.GREEN);
                                    tv_arrowAAPL.setText((int)(flux*100%100) + "%");
                                }
                                else if(flux < 1.0) {
                                    iv_arrowAAPL.setImageResource(R.drawable.red_arrow);
                                    tv_arrowAAPL.setTextColor(Color.RED);
                                    tv_arrowAAPL.setText((int)(100-(flux*100%100)) + "%");
                                }
                                else {
                                    iv_arrowAAPL.setImageResource(R.drawable.blank_arrow);
                                    tv_arrowAAPL.setTextColor(Color.BLACK);
                                    tv_arrowAAPL.setText("0%");
                                }

                                flux = random.nextDouble()*(1.1-0.9) + 0.9;
                                costSMSN *=  flux;
                                if(flux > 1.0) {
                                    iv_arrowSMSN.setImageResource(R.drawable.green_arrow);
                                    tv_arrowSMSN.setTextColor(Color.GREEN);
                                    tv_arrowSMSN.setText((int)(flux*100%100) + "%");
                                }
                                else if(flux < 1.0) {
                                    iv_arrowSMSN.setImageResource(R.drawable.red_arrow);
                                    tv_arrowSMSN.setTextColor(Color.RED);
                                    tv_arrowSMSN.setText((int)(100-(flux*100%100)) + "%");
                                }
                                else {
                                    iv_arrowSMSN.setImageResource(R.drawable.blank_arrow);
                                    tv_arrowSMSN.setTextColor(Color.BLACK);
                                    tv_arrowSMSN.setText("0%");
                                }
                                animation2(tv_arrowGOOG);
                                animation2(tv_arrowFB);
                                animation2(tv_arrowAAPL);
                                animation2(tv_arrowSMSN);

                                tv_costGOOG.setText(""+format_money_display(costGOOG));
                                animation2(tv_costGOOG);
                                tv_costFB.setText(""+format_money_display(costFB));
                                animation2(tv_costFB);
                                tv_costAAPL.setText(""+format_money_display(costAAPL));
                                animation2(tv_costAAPL);
                                tv_costSMSN.setText(""+format_money_display(costSMSN));
                                animation2(tv_costSMSN);

                                if(contorGOOG>0) {
                                    double tmp = contorGOOG*costGOOG-moneyInGOOG;
                                    if(contorGOOG*costGOOG>moneyInGOOG) tv_moneyInGOOG.setTextColor(Color.GREEN);
                                    else if(contorGOOG*costGOOG<moneyInGOOG) tv_moneyInGOOG.setTextColor(Color.RED);
                                    else tv_moneyInGOOG.setTextColor(Color.BLACK);
                                    tv_moneyInGOOG.setText(format_money_display(tmp));
                                }

                                if(contorFB>0) {
                                    double tmp = contorFB*costFB-moneyInFB;
                                    if(contorFB*costFB>moneyInFB) tv_moneyInFB.setTextColor(Color.GREEN);
                                    else if(contorFB*costFB<moneyInFB) tv_moneyInFB.setTextColor(Color.RED);
                                    else tv_moneyInFB.setTextColor(Color.BLACK);
                                    tv_moneyInFB.setText(format_money_display(tmp));
                                }

                                if(contorAAPL>0) {
                                    double tmp = contorAAPL*costAAPL-moneyInAAPL;
                                    if(contorAAPL*costAAPL>moneyInAAPL) tv_moneyInAAPL.setTextColor(Color.GREEN);
                                    else if(contorAAPL*costAAPL<moneyInAAPL) tv_moneyInAAPL.setTextColor(Color.RED);
                                    else tv_moneyInAAPL.setTextColor(Color.BLACK);
                                    tv_moneyInAAPL.setText(format_money_display(tmp));
                                }

                                if(contorSMSN>0) {
                                    double tmp = contorSMSN*costSMSN-moneyInSMSN;
                                    if(contorSMSN*costSMSN>moneyInSMSN) tv_moneyInSMSN.setTextColor(Color.GREEN);
                                    else if(contorSMSN*costSMSN<moneyInSMSN) tv_moneyInSMSN.setTextColor(Color.RED);
                                    else tv_moneyInSMSN.setTextColor(Color.BLACK);
                                    tv_moneyInSMSN.setText(format_money_display(tmp));
                                }
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

    private void animation2(TextView textView) {
        textView.startAnimation(scaleUp);
        textView.startAnimation(scaleDown);
    }

    private void animation(Button button) {
        button.startAnimation(scaleUp);
        button.startAnimation(scaleDown);
    }



    private void openActivity4() {
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    private void update_text_file() {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write((costGOOG+"x"+costFB+"x"+costAAPL+"x"+
                    costSMSN+"x"+contorGOOG+"x"+contorFB+"x"+
                    contorAAPL+ "x"+contorSMSN+"x"+moneyInGOOG
                    +"x"+moneyInFB+"x"+moneyInAAPL+"x"+moneyInSMSN).getBytes());
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

}