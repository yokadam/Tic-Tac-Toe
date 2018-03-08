package com.game.component;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link Board} class.
 *
 * @author yogesh.kadam
 */
public class BoardTest {

    Board boardInstance;

    @Before
    public void setup() {
        boardInstance = Board.getInstance();
        boardInstance.initializeBoard(3);
    }

    @Test
    public void checkRowsForWin_allCellsOfAnyRowAreEqual_returnTrue() {
        Character[][] board = {
                {'X', 'X', 'X'},
                {'X', ' ', 'O'},
                {'C', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertTrue(boardInstance.checkForWin());
    }

    @Test
    public void checkRowsForWin_allCellsOfAnyRowAreNotEqual_returnFalse() {
        Character[][] board = {
                {'X', 'O', 'X'},
                {' ', 'C', 'O'},
                {'C', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertFalse(boardInstance.checkForWin());
    }

    @Test
    public void checkColumnsForWin_allCellsOfAnyColumnAreEqual_returnTrue() {
        Character[][] board = {
                {'C', 'X', 'O'},
                {'C', 'X', ' '},
                {'O', 'X', 'C'}
        };
        boardInstance.setBoard(board);
        assertTrue(boardInstance.checkForWin());
    }

    @Test
    public void checkColumnsForWin_allCellsOfAnyColumnAreNotEqual_returnFalse() {
        Character[][] board = {
                {'X', 'O', 'X'},
                {'X', 'C', ' '},
                {'C', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertFalse(boardInstance.checkForWin());
    }

    @Test
    public void checkTopLeftToBottomRightDiagonalForWin_DiagonalCellsAreEqual_returnTrue() {
        Character[][] board = {
                {'X', ' ', ' '},
                {'O', 'X', 'O'},
                {'C', 'O', 'X'}
        };
        boardInstance.setBoard(board);
        assertTrue(boardInstance.checkForWin());
    }

    @Test
    public void checkTopLeftToBottomRightDiagonalForWin_DiagonalCellsAreNotEqual_returnFalse() {
        Character[][] board = {
                {'O', 'C', 'C'},
                {'X', 'X', 'O'},
                {'C', ' ', 'X'}
        };
        boardInstance.setBoard(board);
        assertFalse(boardInstance.checkForWin());
    }

    @Test
    public void checkTopRightToBottomLeftDiagonalForWin_DiagonalCellsAreEqual_returnTrue() {
        Character[][] board = {
                {' ', 'C', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertTrue(boardInstance.checkForWin());
    }

    @Test
    public void checkTopRightToBottomLeftDiagonalForWin_DiagonalCellsAreNotEqual_returnFalse() {
        Character[][] board = {
                {'O', 'C', ' '},
                {'O', 'X', 'X'},
                {'X', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertFalse(boardInstance.checkForWin());
    }

    @Test
    public void checkForDraw_NoEmptyCells_returnTrue() {
        Character[][] board = {
                {'O', 'C', 'X'},
                {'C', 'O', 'X'},
                {'X', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertTrue(boardInstance.checkForDraw());
    }

    @Test
    public void checkForDraw_someCellsAreEmpty_returnFalse() {
        Character[][] board = {
                {' ', 'C', 'X'},
                {'C', ' ', ' '},
                {'X', 'O', 'C'}
        };
        boardInstance.setBoard(board);
        assertFalse(boardInstance.checkForDraw());
    }
}
