package edu.uc.mail.hollanjk.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String whoseTurn="X";
    String whoseNext="O";
    GameBoard gameBoard;

    public void clickButton(View v){
        Button thisButton = (Button)v;
        int cellNum=Character.getNumericValue(thisButton.getText().charAt(1));
        if (gameBoard.getCell(cellNum)==' ') {
            TextView turnMessage = (TextView) findViewById(R.id.turn);
            PlaySound();
            turnMessage.setText("Next Turn: " + NextTurn(thisButton.getText().toString()));
            String upNext = NextXO(thisButton.getText().toString());
            thisButton.setText(upNext);
            gameBoard.setBoard(cellNum,upNext.charAt(0));

        } else {
            Toast tryAnother = Toast.makeText(MainActivity.this, "Try a Different Square", Toast.LENGTH_SHORT);
            tryAnother.show();
        }


    }

    public void rulesButton(View v){
        Intent i = new Intent(MainActivity.this,RulesActivity.class);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameBoard= new GameBoard();
    }

    @NonNull
    private String NextXO(String currText){
        whoseTurn = (whoseTurn == "X") ? "O" : "X";
        return whoseTurn;
    }

    @NonNull
    private String NextTurn(String currText){
        whoseNext = (whoseNext == "O") ? "X" : "O";
        return whoseNext;
    }

    public void PlaySound(){
        MediaPlayer sound = MediaPlayer.create(this,R.raw.woosh_mark_diangelo);
        sound.start();
    }
}
