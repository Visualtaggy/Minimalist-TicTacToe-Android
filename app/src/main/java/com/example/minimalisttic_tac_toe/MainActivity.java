package com.example.minimalisttic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {

    // 0: circle, 1: cross
    public int currentPlayer = 1;

    //2: blank
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    //All possible indexes needed to win a game
    int[][] winPossibilities = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //Game Status
    boolean gameRunning = true;

        public void fadeIn (View view){
        ImageView circle_cross = (ImageView) view;
        int index = Integer.parseInt(circle_cross.getTag().toString());

        if (gameState[index] == 2 && gameRunning) {
            gameState[index] = currentPlayer;

            //Hides X or O from screen
            circle_cross.setTranslationY(-1500);

            //Using counter to track turns b/w p1 and p2
            if (currentPlayer == 0) {
                circle_cross.setImageResource(R.drawable.circle);
                currentPlayer = 1;
            } else {
                circle_cross.setImageResource(R.drawable.cross);
                currentPlayer = 0;
            }

            // Drops X or O down
            circle_cross.animate().translationYBy(1500).setDuration(300);

            //loop to check if player has won or not
            for (int[] winningPosition : winPossibilities) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    String winner;
                    if (currentPlayer == 0) {
                        winner = "X";
                    } else {
                        winner = "O";
                    }
                    gameRunning = false;
                    Toast.makeText(this, winner + " WON the game!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}