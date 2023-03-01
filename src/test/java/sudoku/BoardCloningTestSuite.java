package sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardCloningTestSuite {
    @Test
    void testBoardShallowCloning() {
        //Given
        SudokuBoard board = SudokuBoard.createTheBoard();
        SudokuBoard clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.err.println(e);
        }

        //When
        int size = board.getBoard().size();

        //Then
        assert clonedBoard != null;
        assertEquals(clonedBoard.getBoard().size(), size);
    }

    @Test
    void testBoardDeepCloning() {
        //Given
        SudokuBoard board = SudokuBoard.createTheBoard();
        SudokuBoard deepClonedBoard = null;

        try {
            deepClonedBoard = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.err.println(e);
        }

        //When
        board.getBoard().remove(0);
        int boardSize = board.getBoard().size();

        //Then
        assert deepClonedBoard != null;
        assertNotEquals(deepClonedBoard.getBoard().size(), boardSize);
    }

    @Test
    void testBoardCopyingPossibilities() {
        //Given
        SudokuBoard board = SudokuBoard.createTheBoard();

        SudokuBoard shallowClone = null;
        try {
            shallowClone = board.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.err.println(e);
        }

        SudokuBoard deepClone = null;
        try {
            deepClone = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.err.println(e);
        }

        //When
        board.setElement(4, 2, 3);
        int possibilitiesSize = board.getBoard().get(2).getFields().get(3).getPossibilities().size();
        int shallowPossibilitiesSize = shallowClone.getBoard().get(2).getFields().get(3).getPossibilities().size();
        int deepPossibilitiesSize = deepClone.getBoard().get(2).getFields().get(3).getPossibilities().size();

        //Then
        assertAll(() -> assertEquals(possibilitiesSize, shallowPossibilitiesSize),
                () -> assertNotEquals(shallowPossibilitiesSize, deepPossibilitiesSize));
    }
}
