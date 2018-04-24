package com.example.mike.rockpaperscissors.GameModels;

import com.example.mike.rockpaperscissors.GameModels.Contestants.CPU;
import com.example.mike.rockpaperscissors.GameModels.Contestants.Contestant;
import com.example.mike.rockpaperscissors.GameModels.Contestants.Player;
import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;
import com.example.mike.rockpaperscissors.GameModels.Hand.HandType;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private Player human;
    private CPU cpu;
    private ArrayList<Hand> cpuChoices;


    public Game(Player human, CPU machine, ArrayList<Hand> cpuChoices) {
        this.human = human;
        this.cpu = machine;
        this.cpuChoices = cpuChoices;
    }

    public Player getHuman() {
        return human;
    }

    public CPU getCpu() {
        return cpu;
    }

    public ArrayList<Hand> getCpuChoices() {
        return cpuChoices;
    }

    public void cpuChoice(){
        cpu.chooseHand(cpuChoices);
    }

    private Contestant comparePlayers() {
        if (human.getHand().getType() == cpu.getHand().getType()) {
            return null;
        } else {
            return comparePlayerTrumps();
        }
    }

    private Contestant comparePlayerTrumps() {
        for (HandType type: human.getHand().getTrumps()
             ) {
            if (cpu.getHand().getType() == type) {
                human.incrementWinCount();
                return human;
            }
        }
        cpu.incrementWinCount();
        return cpu;
    }

    public String getResult() {
        Contestant winner = comparePlayers();
        if (winner == null) return "Draw!";
        return winner.getName() + " wins!";
    }

}

