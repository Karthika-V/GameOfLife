package com.tw.gameoflife;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GridOfCellsTest {

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
        GridOfCells gridOfCells = new GridOfCells();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals(2, gridOfCells.getSizeOfGrid());
    }

    @Test
    public void shouldTakeInputFromUserAsGrid() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "x\nx\nx\nx";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        gridOfCells.displayGrid(gridOfCells.inputGrid(2), 2);

        assertEquals("[x][x]\n[x][x]\n", outContent.toString());
    }

}