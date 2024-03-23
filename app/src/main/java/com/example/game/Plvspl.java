package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Plvspl extends AppCompatActivity {

    private Button player1Button, player2Button;
    private TextView resultTextView;
    private TextView playerMovesTextView;
    private String player1Move = "-";
    private String player2Move = "-";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plvspl);

        player1Button = findViewById(R.id.player1Button);
        player2Button = findViewById(R.id.player2Button);
        playerMovesTextView = findViewById(R.id.playerMovesTextView);
        resultTextView = findViewById(R.id.resultTextView);

        player1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(1);
            }
        });

        player2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(2);
            }
        });
    }

    private void playGame(int player) {
        int opponent = (player == 1) ? 2 : 1;

        String[] moves = {"Rock", "Paper", "Scissors"};

        int playerMoveIndex = (int) (Math.random() * 3);
        int opponentMoveIndex = (int) (Math.random() * 3);

        String playerMove = moves[playerMoveIndex];
        player1Move=playerMove;
        String opponentMove = moves[opponentMoveIndex];
        player2Move=opponentMove;
        String result;

        if (playerMove.equals(opponentMove)) {
            result = "OOH! ^0^ U_U 🫂🫂It's a tie!";
        } else if ((playerMove.equals("Rock") && opponentMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && opponentMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && opponentMove.equals("Paper"))) {
            result = "CONGRATULATIONS 🎉🎉🎊"+"Player " + player + " wins!"+"\nPlayer "+opponent+"🥺BETTER LUCK NEXT TIME";
        } else {
            result = "CONGRATULATIONS 🎉🎉🎊"+"Player " + opponent + " wins!"+"\nPLAYER "+player+"🥺BETTER LUCK NEXT TIME";
        }

        playerMovesTextView.setText("Player 1: " + player1Move + "\nPlayer 2: " + player2Move);
        resultTextView.setText(result);

    }
}