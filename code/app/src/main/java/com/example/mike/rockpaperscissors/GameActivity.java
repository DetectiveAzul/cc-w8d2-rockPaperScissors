package com.example.mike.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mike.rockpaperscissors.GameModels.Contestants.CPU;
import com.example.mike.rockpaperscissors.GameModels.Contestants.Player;
import com.example.mike.rockpaperscissors.GameModels.Game;
import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;
import com.example.mike.rockpaperscissors.GameModels.Hand.Lizard;
import com.example.mike.rockpaperscissors.GameModels.Hand.Paper;
import com.example.mike.rockpaperscissors.GameModels.Hand.Rock;
import com.example.mike.rockpaperscissors.GameModels.Hand.Scissors;
import com.example.mike.rockpaperscissors.GameModels.Hand.Spock;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private Game game;
    private TextView playerName;
    private TextView playerWinCount;
    private TextView cpuName;
    private TextView cpuWinCount;
    private ImageButton scissorsButton;
    private ImageButton paperButton;
    private ImageButton rockButton;
    private ImageButton spockButton;
    private ImageButton lizardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initializing all the views
        this.playerName = findViewById(R.id.playerNameTextViewID);
        this.playerWinCount = findViewById(R.id.playerWinCountTextViewID);

        this.cpuName = findViewById(R.id.cpuNameTextViewID);
        this.cpuWinCount = findViewById(R.id.cpuWinCountTextViewID);

        this.scissorsButton = findViewById(R.id.scissorsButtonID);
        this.paperButton = findViewById(R.id.paperButtonID);
        this.rockButton = findViewById(R.id.rockButtonID);
        this.spockButton = findViewById(R.id.spockButtonID);
        this.lizardButton = findViewById(R.id.lizzardButtonID);

        //Creating the game
        ArrayList<Hand> cpuChoices = new ArrayList<>();
        cpuChoices.add(new Rock());
        cpuChoices.add(new Scissors());
        cpuChoices.add(new Paper());
        cpuChoices.add(new Lizard());
        cpuChoices.add(new Spock());
        this.game = new Game(new Player(), new CPU(), cpuChoices);

        //Refreshing the screen
        refresh();
    }

    public void refresh(){
        refreshHuman();
        refreshCPU();
    }

    public void refreshHuman(){
        playerName.setText(game.getHuman().getName());
        playerWinCount.setText(game.getHuman().getWinCount());
    }

    public void refreshCPU(){
        cpuName.setText(game.getCpu().getName());
        cpuWinCount.setText(game.getCpu().getWinCount());
    }


    public void onScissorsButtonClicked(View view) {
        game.getHuman().setHand(new Scissors());
        playGame();
    }
    public void onRockButtonClicked(View view) {
        game.getHuman().setHand(new Rock());
        playGame();

    }
    public void onPaperButtonClicked(View view) {
        game.getHuman().setHand(new Paper());
        playGame();
    }

    public void onSpockButtonClicked(View view) {
        game.getHuman().setHand(new Spock());
        playGame();
    }

    public void onLizardButtonClicked(View view) {
        game.getHuman().setHand(new Lizard());
        playGame();
    }

    public void cpuChoice() {
        game.cpuChoice();
    }


    public void playGame() {
        //CPU choose hand
        cpuChoice();
        //Get the result
        String result = game.getResult();
        //Refresh the stats
        refresh();
        //Call the intent
        goResultScreen(result);
    }

    public void goResultScreen(String result) {
        //Create intent for new activity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("humanName", game.getHuman().getName());
        intent.putExtra("humanWinCount", game.getHuman().getWinCount());
        intent.putExtra("humanHand", game.getHuman().getHand().getName());

        intent.putExtra("cpuName", game.getCpu().getName());
        intent.putExtra("cpuWinCount", game.getCpu().getWinCount());
        intent.putExtra("cpuHand", game.getCpu().getHand().getName());

        intent.putExtra("result", result);

        //Start new activity
        startActivity(intent);
    }


}
