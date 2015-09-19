package com.tw.gameoflife;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOfLifeDemoTest {

    @Test
    public void shouldStartGameOfLife() {
        GameOfLifeDemo gameOfLifeDemo = mock(GameOfLifeDemo.class);
        gameOfLifeDemo.start();
        verify(gameOfLifeDemo, times(1)).start();
    }


}