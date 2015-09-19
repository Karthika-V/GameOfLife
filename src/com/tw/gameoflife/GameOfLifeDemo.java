package com.tw.gameoflife;

import java.util.Scanner;

public class GameOfLifeDemo {

    public static void main(String[] args) {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();
        int size = gameOfLifeDemo.getSizeOfGrid();
        gameOfLifeDemo.displayGrid(gameOfLifeDemo.createGridMatrixOfAliveCells(size), size);
    }

    public int getSizeOfGrid() {
        System.out.println("Enter size of square grid (Enter 2 for 2 X 2):");
        Scanner in = new Scanner(System.in);
        return Integer.parseInt(in.nextLine());
    }

    public String[][] createGridMatrixOfAliveCells(int size) {
        String[][] grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for(int j=0; j<size;j++) {
                grid[i][j] = "x";
            }
        }
        return grid;
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
