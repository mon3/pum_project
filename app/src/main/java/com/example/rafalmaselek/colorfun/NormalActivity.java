package com.example.rafalmaselek.colorfun;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class NormalActivity extends Activity
{
    int[] colorRefList;
    protected int numberOfColors;
    String[] colorList;
    ArrayList<Integer> currentColors;
    String currentSolution;
    int result;
    View contentView;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int timer_i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        result = 0;
        setContentView(R.layout.activity_normal);
        colorList = new String[]{"brown", "black", "yellow", "red", "blue", "green", "pink", "purple", "orange", "beige"};
        numberOfColors = colorList.length;
        colorRefList = new int[]{R.color.brown, R.color.black, R.color.yellow, R.color.red, R.color.blue, R.color.green,
        R.color.pink, R.color.purple, R.color.orange, R.color.beige};
        contentView = this.findViewById(android.R.id.content);
        randomizeColors();
        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);
        mProgressBar.setProgress(timer_i);
        mCountDownTimer=new CountDownTimer(30000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + timer_i + millisUntilFinished);
                timer_i++;
                mProgressBar.setProgress(timer_i);

            }
            @Override
            public void onFinish() {
                //Do what you want
                timer_i++;
                mProgressBar.setProgress(timer_i);
            }
        };
        mCountDownTimer.start();

    }

    public void nextQuestion(View view)
    {
        TextView t = (TextView)view;
        if(currentSolution == t.getText())
            result +=1;
        randomizeColors();
    }

    private void randomizeColors()
    {
        Random r = new Random();
        int colorNo;
        currentColors = new ArrayList<Integer>(numberOfColors); //lista kolorow uzywanych w danej chwili na ekranie
        for(int ii=0; ii<9; ii++)
        {
            colorNo = (r.nextInt(numberOfColors));
            do
            {
                colorNo = (r.nextInt(numberOfColors));
            }
            while(currentColors.contains(colorNo));
            currentColors.add(colorNo);
        }

        int solution = currentColors.get(r.nextInt(3)+1);
        currentSolution = colorList[solution];  //rozwiazaniem jest jeden z pierwszych 4 kolorow
        View square = findViewById(R.id.squareView);
        square.setBackgroundColor(getResources().getColor(colorRefList[solution]));//colorRefList[solution]); //ustawiamy kolor kwadratu
        //ustawiamy napisy na przyciskach
        TextView t1=(TextView)findViewById(R.id.answ1);
        t1.setText(colorList[currentColors.get(0)]);
        TextView t2=(TextView)findViewById(R.id.answ2);
        t2.setText(colorList[currentColors.get(1)]);
        TextView t3=(TextView)findViewById(R.id.answ3);
        t3.setText(colorList[currentColors.get(2)]);
        TextView t4=(TextView)findViewById(R.id.answ4);
        t4.setText(colorList[currentColors.get(3)]);
        //ustawiamy kolory obramowan przyciskow, inne niz napisy
        View bt1bd1 = findViewById(R.id.bt1bdUP);
        View bt1bd2 = findViewById(R.id.bt1bdRI);
        View bt1bd3 = findViewById(R.id.bt1bdLE);
        View bt1bd4 = findViewById(R.id.bt1bdDO);
        bt1bd1.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(5)]));
        bt1bd2.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(5)]));
        bt1bd3.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(5)]));
        bt1bd4.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(5)]));
        //////////////////
        View bt2bd1 = findViewById(R.id.bt2bdUP);
        View bt2bd2 = findViewById(R.id.bt2bdRI);
        View bt2bd3 = findViewById(R.id.bt2bdLE);
        View bt2bd4 = findViewById(R.id.bt2bdDO);
        bt2bd1.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(6)]));
        bt2bd2.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(6)]));
        bt2bd3.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(6)]));
        bt2bd4.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(6)]));
        View bt3bd1 = findViewById(R.id.bt3bdUP);
        View bt3bd2 = findViewById(R.id.bt3bdRI);
        View bt3bd3 = findViewById(R.id.bt3bdLE);
        View bt3bd4 = findViewById(R.id.bt3bdDO);
        bt3bd1.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(7)]));
        bt3bd2.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(7)]));
        bt3bd3.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(7)]));
        bt3bd4.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(7)]));
        View bt4bd1 = findViewById(R.id.bt4bdUP);
        View bt4bd2 = findViewById(R.id.bt4bdRI);
        View bt4bd3 = findViewById(R.id.bt4bdLE);
        View bt4bd4 = findViewById(R.id.bt4bdDO);
        bt4bd1.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(8)]));
        bt4bd2.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(8)]));
        bt4bd3.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(8)]));
        bt4bd4.setBackgroundColor(getResources().getColor(colorRefList[currentColors.get(8)]));

        //ustawiamy kolory tekstu na przyciskach, inne niz kolor rozwiazania
        currentColors = new ArrayList<Integer>(4);
        for(int ii=0; ii<4; ii++)
        {
            do
            {
                colorNo = (r.nextInt(numberOfColors));
            }
            while(colorNo == solution || currentColors.contains((colorRefList[colorNo])));//currentColors.isEmpty() || !currentColors.contains(colorNo));
            currentColors.add(colorRefList[colorNo]);
        }
        t1.setTextColor(getResources().getColor(currentColors.get(0)));
        t2.setTextColor(getResources().getColor(currentColors.get(1)));
        t3.setTextColor(getResources().getColor(currentColors.get(2)));
        t4.setTextColor(getResources().getColor(currentColors.get(3)));


    }
}
