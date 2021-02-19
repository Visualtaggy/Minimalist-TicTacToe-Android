package com.example.minimalisttic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    // 0: circle, 1: cross
    int currentPlayer = 0;
    //2: blank
    int[] gameState = {2,2,2,2,2,2,2,2,2};


    public void fadeIn(View view){
        ImageView circle_cross = (ImageView) view;

        int index = Integer.parseInt(circle_cross.getTag().toString());
        gameState[index] = currentPlayer;

        //Using counter to track turns b/w p1 and p2
        if(currentPlayer == 0){
            //Adding Animations
            circle_cross.setTranslationY(-1500);
            //setting image resource
            circle_cross.setImageResource(R.drawable.circle);
            circle_cross.animate().translationYBy(1500).setDuration(300);
            //Giving next player chance to play
            currentPlayer = 1;
        }
        else {
            circle_cross.setTranslationY(-1500);
            circle_cross.setImageResource(R.drawable.cross);
            circle_cross.animate().translationYBy(1500).setDuration(300);
            currentPlayer = 0;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}