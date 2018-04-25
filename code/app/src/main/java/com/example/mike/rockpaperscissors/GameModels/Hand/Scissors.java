package com.example.mike.rockpaperscissors.GameModels.Hand;

public class Scissors extends Hand{

    public Scissors(){
        super(HandType.SCISSORS);
        getTrumps().add(HandType.PAPER);
        getTrumps().add(HandType.LIZARD);

    }
}
