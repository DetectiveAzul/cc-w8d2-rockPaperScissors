package com.example.mike.rockpaperscissors.GameModels.Hand;

public class Paper extends Hand {

    public Paper(){
        super(HandType.PAPER);
        getTrumps().add(HandType.ROCK);
        getTrumps().add(HandType.SPOCK);
    }


}
