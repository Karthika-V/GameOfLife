package com.tw.gameoflife;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameOfLifeDemoTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldGetTheGridSizeFromTheUserForGameOfLife() {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals("2", gameOfLifeDemo.getSizeOfGrid());
    }

    @Test
    public void shouldConvertGridSizeToInteger() {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();

        assertEquals(2, gameOfLifeDemo.convertGridSizeToInteger("2"));

    }


}