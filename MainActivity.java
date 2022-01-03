package com.example.supermarket;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView progressBarPercentage;
    public static final String FILE_NAME = "example.txt";
    public static long elapsedMinutes;
    public static long elapsedSeconds;
    public static double gainedMoney;
    boolean check_date;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
    Date dateOut = null;
    Date dateIn = null;
    static MediaPlayer mediaPlayer;
    static Boolean sound_on = true;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        //Starting background music
        mediaPlayer = mediaPlayer.create(MainActivity.this,R.raw.theme_song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        //Reading from file storage and assigning values
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            text = br.readLine();
            String[] arrOfStr = text.split("x");

            MainActivity2.contor_produce_dept=Integer.parseInt(arrOfStr[0]);
            MainActivity2.mps_produce_dept=Double.parseDouble(arrOfStr[1]);
            MainActivity2.cost_produce_dept=Double.parseDouble(arrOfStr[2]);

            MainActivity2.contor_bakery=Integer.parseInt(arrOfStr[3]);
            MainActivity2.mps_bakery=Double.parseDouble(arrOfStr[4]);
            MainActivity2.cost_bakery=Double.parseDouble(arrOfStr[5]);

            MainActivity2.contor_butcher=Integer.parseInt(arrOfStr[6]);
            MainActivity2.mps_butcher=Double.parseDouble(arrOfStr[7]);
            MainActivity2.cost_butcher=Double.parseDouble(arrOfStr[8]);

            MainActivity2.contor_seafood=Integer.parseInt(arrOfStr[9]);
            MainActivity2.mps_seafood=Double.parseDouble(arrOfStr[10]);
            MainActivity2.cost_seafood=Double.parseDouble(arrOfStr[11]);

            MainActivity2.contor_clothing=Integer.parseInt(arrOfStr[12]);
            MainActivity2.mps_clothing=Double.parseDouble(arrOfStr[13]);
            MainActivity2.cost_clothing=Double.parseDouble(arrOfStr[14]);

            MainActivity2.contor_perfume=Integer.parseInt(arrOfStr[15]);
            MainActivity2.mps_perfume=Double.parseDouble(arrOfStr[16]);
            MainActivity2.cost_perfume=Double.parseDouble(arrOfStr[17]);

            MainActivity2.contor_electronics=Integer.parseInt(arrOfStr[18]);
            MainActivity2.mps_electronics=Double.parseDouble(arrOfStr[19]);
            MainActivity2.cost_electronics=Double.parseDouble(arrOfStr[20]);

            MainActivity2.contor_jewelry=Integer.parseInt(arrOfStr[21]);
            MainActivity2.mps_jewelry=Double.parseDouble(arrOfStr[22]);
            //MainActivity2.cost_jewelry=Double.parseDouble(arrOfStr[23]);
            MainActivity2.cost_jewelry = 9;

            MainActivity2.money=Double.parseDouble(arrOfStr[24]);

            check_date = true;

            if(MainActivity2.cost_jewelry<10)
            {
                MainActivity2.contor_produce_dept=1;
                MainActivity2.mps_produce_dept=0.1;
                MainActivity2.cost_produce_dept=0.4;

                MainActivity2.contor_bakery=0;
                MainActivity2.mps_bakery=0;
                MainActivity2.cost_bakery=6.0;

                MainActivity2.contor_butcher=0;
                MainActivity2.mps_butcher=0;
                MainActivity2.cost_butcher=72.0;

                MainActivity2.contor_seafood=0;
                MainActivity2.mps_seafood=0;
                MainActivity2.cost_seafood=864.0;

                MainActivity2.contor_clothing=0;
                MainActivity2.mps_clothing=0;
                MainActivity2.cost_clothing=10368.0;

                MainActivity2.contor_perfume=0;
                MainActivity2.mps_perfume=0;
                MainActivity2.cost_perfume=124416.0;

                MainActivity2.contor_electronics=0;
                MainActivity2.mps_electronics=0;
                MainActivity2.cost_electronics=1492992.0;

                MainActivity2.contor_jewelry=0;
                MainActivity2.mps_jewelry=0;
                MainActivity2.cost_jewelry=17915904.0;

                //21490840 -- 1.08
                //2579890176 -- 1.07

                MainActivity2.money=1000000;

                check_date = false;
            }
            try {
                dateOut = simpleDateFormat.parse(arrOfStr[25]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Checking offline hours and giving gained money
        if(check_date)
        {
            String date = new SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault()).format(new Date());
            try {
                dateIn = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long different = dateIn.getTime() - dateOut.getTime();
            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;
            elapsedSeconds = different / secondsInMilli;
            MainActivity2.money_per_second=MainActivity2.mps_produce_dept+MainActivity2.mps_bakery+MainActivity2.mps_butcher+MainActivity2.mps_seafood+MainActivity2.mps_clothing+MainActivity2.mps_perfume+MainActivity2.mps_electronics+MainActivity2.mps_jewelry;
            if(elapsedMinutes<=119)
            {
                gainedMoney = MainActivity2.money_per_second*(double)elapsedMinutes*60 + MainActivity2.money_per_second*(double)elapsedSeconds;
            }
            else
            {
                gainedMoney = MainActivity2.money + MainActivity2.money_per_second*120*60;
            }
            MainActivity2.money = MainActivity2.money + gainedMoney;
        }



        //Showing progress bar
        progressBar = findViewById(R.id.progressBar);
        progressBarPercentage = findViewById(R.id.textView4);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#0014FF"), android.graphics.PorterDuff.Mode.SRC_IN);
        progressAnimation();

    }

    public void progressAnimation()
    {
        ProgressBarAnimation anim = new ProgressBarAnimation(this,progressBar,progressBarPercentage,0f,100f);
        anim.setDuration(3000);
        progressBar.setAnimation(anim);
    }

    public void onBackPressed(){
    }


}