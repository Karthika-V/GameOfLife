package com.tw.gameoflife;

import java.util.Scanner;

public class GameOfLifeDemo {

    public static void main(String[] args) {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();
        gameOfLifeDemo.getSizeOfGrid();
    }

    public String getSizeOfGrid() {
        System.out.println("Enter size of square grid (Enter 2 for 2 X 2):");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
