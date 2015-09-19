package com.tw.gameoflife;

import java.util.Scanner;

public class GameOfLifeDemo {

    public static void main(String[] args) {
        GameOfLifeDemo gameOfLifeDemo = new GameOfLifeDemo();
        GridOfCells gridOfCells = new GridOfCells();
        gridOfCells.createGridMatrixOfAliveCells(gridOfCells.getSizeOfGrid());
    }


}
