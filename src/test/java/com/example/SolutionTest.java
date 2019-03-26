package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SolutionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testEasyGame() {
        Game game = new Game();
        game.p1Points = 0;
        game.p2Points = 1;
        game.status = 0;
        int rand =1;
        GameProcessor.process(game, rand);
        assertEquals(game.p1Points, 1);
        assertEquals(game.p2Points, 1);
        assertEquals(game.status, 0);
        assertEquals("Player 1 scores one point.\n" +
                "fifteen fifteen\n", outContent.toString());
    }

    @Test
    public void testDeuce() {
        Game game = new Game();
        game.p1Points = 2;
        game.p2Points = 3;
        game.status = 0;
        int rand =1;
        GameProcessor.process(game, rand);
        assertEquals(game.p1Points, 3);
        assertEquals(game.p2Points, 3);
        assertEquals(game.status, 0);
        assertEquals("Player 1 scores one point.\n" +
                "Deuce.\n", outContent.toString());
    }

    @Test
    public void testAdvantage() {
        Game game = new Game();
        game.p1Points = 3;
        game.p2Points = 3;
        game.status = 0;
        int rand =1;
        GameProcessor.process(game, rand);
        assertEquals(game.p1Points, 4);
        assertEquals(game.p2Points, 3);
        assertEquals(game.status, 0);
        assertEquals("Player 1 scores one point.\n" +
                "Advantage P1.\n", outContent.toString());
    }

    @Test
    public void testWin() {
        Game game = new Game();
        game.p1Points = 4;
        game.p2Points = 3;
        game.status = 0;
        int rand =1;
        GameProcessor.process(game, rand);
        assertEquals(game.p1Points, 5);
        assertEquals(game.p2Points, 3);
        assertEquals(game.status, 1);
        assertEquals("Player 1 scores one point.\n" +
                "P1 wins.\n", outContent.toString());
    }
}
