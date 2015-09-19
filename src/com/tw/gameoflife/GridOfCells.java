package com.tw.gameoflife;

import java.util.Scanner;
//GridOfCells manages the grid
public class GridOfCells {

    private String stateOfCell;

    public int getSizeOfGrid() {
        Scanner in = new Scanner(System.in);
        return Integer.parseInt(in.nextLine());
    }

    public String[][] inputGrid(int size) {
        Scanner in = new Scanner(System.in);
        String[][] inputGrid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for(int j=0; j<size;j++) {
                inputGrid[i][j] = in.nextLine();
            }
        }
        return inputGrid;
    }

    public void displayGrid(String[][] grid, int size) {
        for (int i=0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("[" + grid[i][j] + "]");
            }
            System.out.println();
        }
    }
}
