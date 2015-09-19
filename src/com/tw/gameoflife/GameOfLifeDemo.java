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
        System.out.println("Enter size of square grid (Enter 2 for 2 X 2):");
        int size = gridOfCells.getSizeOfGrid();
        System.out.println("Input grid Cells (one per line):");
        String[][] grid = gridOfCells.inputGrid(size);
        System.out.println("Grid of cells entered by user:");
        gridOfCells.displayGrid(grid, size);
    }

}
