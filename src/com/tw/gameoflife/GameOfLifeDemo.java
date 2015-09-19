package com.tw.gameoflife;

import java.util.Scanner;

//GameOfLifeDemo starts the GameOfLife
public class GameOfLifeDemo {

    public static void main(String[] args) {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();
        gameOfLifeDemo.start();
    }

    public void start() {
        GridOfCells gridOfCells = new GridOfCells();
        int size = gridOfCells.getSizeOfGrid();
        String[][] grid = gridOfCells.createGridMatrixOfAliveCells(size);
        gridOfCells.displayGrid(grid, size);
    }


}
