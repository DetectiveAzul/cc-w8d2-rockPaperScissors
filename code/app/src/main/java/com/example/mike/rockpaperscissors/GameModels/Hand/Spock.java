package com.example.mike.rockpaperscissors.GameModels.Hand;

public class Spock extends Hand {

    public Spock(){
        super(HandType.SPOCK);
        getTrumps().add(HandType.SCISSORS);
        getTrumps().add(HandType.ROCK);
    }


}
