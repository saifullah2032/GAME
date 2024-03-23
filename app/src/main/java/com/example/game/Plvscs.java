package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Plvscs extends AppCompatActivity {

    private Button buttonRock, buttonPaper, buttonScissors;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plvscs);
        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        textResult = findViewById(R.id.textResult);

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame("Rock");
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame("Paper");
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame("Scissors");
            }
        });
    }

    private void playGame(String userChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String computerChoice = choices[new Random().nextInt(choices.length)];

        String result = determineWinner(userChoice, computerChoice);

        textResult.setText("Result:\n"+"You chose " + userChoice + ".\nComputer chose " + computerChoice + ".\n" + result);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "WOW 🫂🫂: It's a tie!";
        } else if (
                (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                        (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                        (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            return "CONGRATULATIONS🎉🎊 : You win!";
        } else {
            return "BETTER LUCK NEXT TIME🫠🥺 : Computer wins!";
        }
    }
}