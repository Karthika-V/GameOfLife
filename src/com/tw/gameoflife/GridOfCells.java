package com.tw.gameoflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//GridOfCells manages the grid
public class GridOfCells {

    private ArrayList<String> adjacentCells = new ArrayList<String>();

    public int getSizeOfGrid() {
        Scanner in = new Scanner(System.in);
        return Integer.parseInt(in.nextLine());
    }

    public String[][] inputGrid(int size) {
        Scanner in = new Scanner(System.in);
        String[][] inputGrid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inputGrid[i][j] = in.nextLine();
            }
        }
        return inputGrid;
    }

    public ArrayList findAdjacentCellsOfCell(String[][] grid, int row, int column) {
        for (int j = row - 1; j <= row + 1; j++)
            for (int i = column - 1; i <= column + 1; i++)
                if (i >= 0 && j >= 0 && i < grid.length && j < grid.length && !(j == row && i == column))
                    adjacentCells.add(grid[j][i]);
        return adjacentCells;
    }

    public String[][] applyRulesToInputGrid(String[][] grid) {
        ArrayList<String> adjacentCellsOfCell;
        int countOfAliveCells =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                adjacentCellsOfCell = findAdjacentCellsOfCell(grid, i, j);
                countOfAliveCells = Collections.frequency(adjacentCellsOfCell, "x");
                System.out.println("Count Of Alive cells for " + i + j + ":" + countOfAliveCells);
                if (grid[i][j] == "x" && countOfAliveCells < 2) {
                    grid[i][j] = "-";
                }
            }
        }
        return grid;
    }

    public void displayGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print("[" + grid[i][j] + "]");
            }
            System.out.println();
        }
    }
}
