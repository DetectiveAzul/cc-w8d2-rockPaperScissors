package com.example.mike.rockpaperscissors.GameModels.Contestants;

import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CPU extends Contestant {
    public CPU() {
        super("Machine");
    }

    public void chooseHand(ArrayList<Hand> hands) {
        Collections.shuffle(hands);
        setHand(hands.get(0));
    }
}
