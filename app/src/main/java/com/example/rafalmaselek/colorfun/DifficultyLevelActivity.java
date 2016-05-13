package com.example.rafalmaselek.colorfun;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DifficultyLevelActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);
    }

    public void easy(View view)
    {
        Intent easyGame = new Intent(this, EasyActivity.class);
        startActivity(easyGame);
    }

    public void normal(View view)
    {
        Intent normalGame = new Intent(this, NormalActivity.class);
        startActivity(normalGame);
    }

    public void hard(View view)
    {
        Intent hardGame = new Intent(this, HardActivity.class);
        startActivity(hardGame);
    }

}
