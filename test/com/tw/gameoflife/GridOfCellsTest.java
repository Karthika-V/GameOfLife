package com.tw.gameoflife;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        gridOfCells.displayGrid(gridOfCells.inputGrid(2));

        assertEquals("[x][x]\n[x][x]\n", outContent.toString());
    }

    @Test
    public void shouldTakeInputFromUserAsGridWhenSizeOfGridIsThree() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "1\n2\n3\n4\n5\n6\n7\n8\n9";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        gridOfCells.displayGrid(gridOfCells.inputGrid(3));

        assertEquals("[1][2][3]\n[4][5][6]\n[7][8][9]\n", outContent.toString());
    }

    @Test
    public void shouldFindAdjacentCellsOfCellAtSecondRowAndSecondColumn() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "1\n2\n3\n4\n5\n6\n7\n8\n9";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ArrayList<String> adjacentCellsList = gridOfCells.findAdjacentCellsOfCell(gridOfCells.inputGrid(3), 1, 1);

        assertEquals("[1, 2, 3, 4, 6, 7, 8, 9]", adjacentCellsList.toString());
    }

    @Test
    public void shouldHaveDeadCellIfCountOfAliveCellsInAdjacentCellsAreLessThanTwo() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "x\n-\n-\n-";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        String[][] inputGrid = gridOfCells.inputGrid(2);
        String[][] outputGrid = gridOfCells.applyRulesToInputGrid(inputGrid);
        gridOfCells.displayGrid(outputGrid);

        assertEquals("[-][-]\n[-][-]\n", outContent.toString());
    }

    @Test
    public void shouldHaveDeadCellIfCountOfAliveCellsInAdjacentCellsAreGreaterThanThree() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "x\nx\n-\nx\n-\nx\n-\nx\n-";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        String[][] inputGrid = gridOfCells.inputGrid(3);
        String[][] outputGrid = gridOfCells.applyRulesToInputGrid(inputGrid);
        gridOfCells.displayGrid(outputGrid);

        assertEquals("[x][-][-]\n[-][-][-]\n[-][-][-]\n", outContent.toString());
    }

    @Test
    public void shouldHaveAliveCellIfItIsADeadCellAndCountOfAliveCellsIsEitherThreeOrTwo() {
        GridOfCells gridOfCells = new GridOfCells();
        String input = "-\nx\n-\n-\nx\n-\n-\nx\n-";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        String[][] inputGrid = gridOfCells.inputGrid(3);
        String[][] outputGrid = gridOfCells.applyRulesToInputGrid(inputGrid);
        gridOfCells.displayGrid(outputGrid);

        assertEquals("[x][-][-]\n[-][-][-]\n[-][-][-]\n", outContent.toString());
    }

}