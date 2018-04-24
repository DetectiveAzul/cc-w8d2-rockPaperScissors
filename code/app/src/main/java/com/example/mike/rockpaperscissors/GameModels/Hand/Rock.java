package com.example.mike.rockpaperscissors.GameModels.Hand;

public class Rock extends Hand{

    public Rock(){
        super(HandType.ROCK);
        getTrumps().add(HandType.SCISSORS);

    }
}
