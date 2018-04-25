package com.example.mike.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView playerName;
    private TextView playerWinCount;
    private TextView cpuName;
    private TextView cpuWinCount;

    private TextView playerHand;
    private TextView cpuHand;
    private TextView gameResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Initial variable settings
        this.playerName = findViewById(R.id.playerNameTextViewID);
        this.playerWinCount = findViewById(R.id.playerWinCountTextViewID);
        this.playerHand = findViewById(R.id.playerHandTextViewID);

        this.cpuName = findViewById(R.id.cpuNameTextViewID);
        this.cpuWinCount = findViewById(R.id.cpuWinCountTextViewID);
        this.cpuHand = findViewById(R.id.cpuHandTextViewID);

        this.gameResult = findViewById(R.id.resultTextViewID);

        //Call the intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //Set the extras into the correct spot
        String humanName = extras.getString("humanName");
        String humanWinCount = extras.getString("humanWinCount");
        String humanHand = extras.getString("humanHand");

        String cpuName = extras.getString("cpuName");
        String cpuWinCount = extras.getString("cpuWinCount");
        String cpuHand = extras.getString("cpuHand");

        String result = extras.getString("result");

        //Refresh the screen with the new info
        this.playerName.setText(humanName);
        this.playerWinCount.setText(humanWinCount);
        this.playerHand.setText(humanHand);

        this.cpuName.setText(cpuName);
        this.cpuWinCount.setText(cpuWinCount);
        this.cpuHand.setText(cpuHand);

        this.gameResult.setText(result);
    }

}
