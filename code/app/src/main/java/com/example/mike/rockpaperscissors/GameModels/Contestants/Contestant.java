package com.example.mike.rockpaperscissors.GameModels.Contestants;

import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;

public abstract class Contestant {
    private String name;
    private int winCount;
    private Hand hand;

    public Contestant(String name) {
        this.name = name;
        this.winCount = 0;
        this.hand = null;
    }

    public String getName() {
        return name;
    }

    public String getWinCount() {
        return (": " + winCount);
    }

    public void incrementWinCount() {
        winCount++;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
