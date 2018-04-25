package com.example.mike.rockpaperscissors.GameModels.Hand;

public class Lizard extends Hand {

    public Lizard(){
        super(HandType.LIZARD);
        getTrumps().add(HandType.SPOCK);
        getTrumps().add(HandType.PAPER);
    }


}
