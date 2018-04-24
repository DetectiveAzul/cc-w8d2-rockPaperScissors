package com.example.mike.rockpaperscissors;

import com.example.mike.rockpaperscissors.GameModels.Contestants.CPU;
import com.example.mike.rockpaperscissors.GameModels.Contestants.Player;
import com.example.mike.rockpaperscissors.GameModels.Game;
import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;
import com.example.mike.rockpaperscissors.GameModels.Hand.Paper;
import com.example.mike.rockpaperscissors.GameModels.Hand.Rock;
import com.example.mike.rockpaperscissors.GameModels.Hand.Scissors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;
    private ArrayList<Hand> cpuChoices = new ArrayList<>();

    public GameTest() {
    }

    @Before
    public void setUp() {
        cpuChoices.add(new Rock());
        cpuChoices.add(new Scissors());
        cpuChoices.add(new Paper());
        game = new Game(new Player(), new CPU(), cpuChoices);
    }

    @Test
    public void hasPlayer() {
        assertEquals("Human", game.getHuman().getName());

    }

    @Test
    public void hasCPU(){
        assertEquals("Machine", game.getCpu().getName());
    }

    @Test
    public void hasHands(){
        assertEquals(3, game.getCpuChoices().size());
    }

    @Test
    public void canWin(){
        game.getHuman().setHand(new Rock());
        game.getCpu().setHand(new Scissors());
        assertEquals("Human wins!", game.getResult());
    }

    @Test
    public void canDraw() {
        game.getHuman().setHand(new Rock());
        game.getCpu().setHand(new Rock());
        assertEquals("Draw!", game.getResult());
    }

    @Test
    public void canLose() {
        game.getHuman().setHand(new Paper());
        game.getCpu().setHand(new Scissors());
        assertEquals("Machine wins!", game.getResult());
    }


}
