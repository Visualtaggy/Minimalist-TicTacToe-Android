package com.example.minimalisttic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    public void fadeIn(View view){
        //increasing counter to keep a track of the game
        counter++;
        if(counter % 2 == 0){
            ImageView circle = (ImageView) view;
            circle.setImageResource(R.drawable.circle);


        }
        else {
            ImageView cross = (ImageView) view;
            cross.setImageResource(R.drawable.cross);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}