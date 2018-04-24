package com.example.mike.rockpaperscissors;

import com.example.mike.rockpaperscissors.GameModels.Contestants.CPU;
import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;
import com.example.mike.rockpaperscissors.GameModels.Hand.Paper;
import com.example.mike.rockpaperscissors.GameModels.Hand.Rock;
import com.example.mike.rockpaperscissors.GameModels.Hand.Scissors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CPUTest {
    private CPU cpu;
    private Rock rock;
    private Scissors scissors;
    private Paper paper;
    private ArrayList<Hand> hands;

    @Before
    public void setUp() {
        cpu = new CPU();
        rock = new Rock();
        paper = new Paper();
        scissors = new Scissors();
        hands = new ArrayList<>();
        hands.add(rock);
        hands.add(paper);
        hands.add(scissors);

    }

    @Test
    public void hasName() {
        assertEquals("Machine", cpu.getName());
    }

    @Test
    public void hasWinCount() {
        assertEquals(0, cpu.getWinCount());
    }

    @Test
    public void canIncrementWinCount() {
        cpu.incrementWinCount();
        cpu.incrementWinCount();
        cpu.incrementWinCount();
        assertEquals(3, cpu.getWinCount());
    }

    @Test
    public void canSetHand() {
        assertEquals(null, cpu.getHand());
        cpu.setHand(rock);
        assertEquals(rock, cpu.getHand());
    }

    @Test
    public void canRandomChooseHand() {
        cpu.chooseHand(hands);
        assertEquals(true, (cpu.getHand().getName() == "Rock" ||
                cpu.getHand().getName() == "Paper" || cpu.getHand().getName() == "Scissors") );
    }
}
