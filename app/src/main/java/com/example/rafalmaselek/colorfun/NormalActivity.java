package com.example.rafalmaselek.colorfun;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class NormalActivity extends Activity
{
    int[] colorRefList;
    String[] colorList;
    ArrayList<Integer> currentColors;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        colorList = new String[]{"brown", "black", "yellow", "red", "blue", "green", "pink", "purple", "orange", "beige"};
        colorRefList = new int[]{R.color.brown, R.color.black, R.color.yellow, R.color.red, R.color.blue, R.color.green,
        R.color.pink, R.color.purple, R.color.orange, R.color.beige};
        currentColors = new ArrayList<Integer>(4);

        Random r = new Random();
        int colorNo;
        for(int ii=0; ii<4; ii++)
        {
            colorNo = (r.nextInt(9) + 1);
            do
            {
                colorNo = (r.nextInt(9) + 1);
            }
            while(currentColors.contains(colorNo));
            currentColors.add(colorNo);
        }
        int solution = currentColors.get(r.nextInt(3)+1);
        TextView t1=(TextView)findViewById(R.id.answ1);
        t1.setText(colorList[currentColors.get(0)]);
        TextView t2=(TextView)findViewById(R.id.answ2);
        t2.setText(colorList[currentColors.get(1)]);
        TextView t3=(TextView)findViewById(R.id.answ3);
        t3.setText(colorList[currentColors.get(2)]);
        TextView t4=(TextView)findViewById(R.id.answ4);
        t4.setText(colorList[currentColors.get(3)]);

        currentColors = new ArrayList<Integer>(4);
        for(int ii=0; ii<4; ii++)
        {
            do
            {
                colorNo = (r.nextInt(9) + 1);
            }
            while(colorNo == solution || currentColors.contains((colorRefList[colorNo])));//currentColors.isEmpty() || !currentColors.contains(colorNo));
            currentColors.add(colorRefList[colorNo]);
        }
        t1.setTextColor(getResources().getColor(currentColors.get(0)));
        t2.setTextColor(getResources().getColor(currentColors.get(1)));
        t3.setTextColor(getResources().getColor(currentColors.get(2)));
        t4.setTextColor(getResources().getColor(currentColors.get(3)));
        //t2.setTextColor(getResources().);
        /*
        t1.setTextColor(colorList[currentColors.get(0)], Color.class));
        t2.setTextColor(getStringResourceByName(colorList[currentColors.get(1)]));
        t3.setTextColor(getStringResourceByName(colorList[currentColors.get(2)]));
        t4.setTextColor(getStringResourceByName(colorList[currentColors.get(3)]));
        */

    }

    public void nextQuestion(View view)
    {

    }
}
