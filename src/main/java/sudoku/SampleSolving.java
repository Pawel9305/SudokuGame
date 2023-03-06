package sudoku;

public class SampleSolving {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = SudokuBoard.createTheBoard();
        SudokuLogics sudokuLogics = new SudokuLogics();
        sudokuBoard.setElement(8, 0, 2);
        sudokuBoard.setElement(9, 0, 3);
        sudokuBoard.setElement(6, 0, 4);
        sudokuBoard.setElement(4, 0, 7);
        sudokuBoard.setElement(4, 1, 0);
        sudokuBoard.setElement(9, 1, 2);
        sudokuBoard.setElement(3, 1, 8);
        sudokuBoard.setElement(5, 2, 0);
        sudokuBoard.setElement(6, 2, 1);
        sudokuBoard.setElement(1, 2, 2);
        sudokuBoard.setElement(3, 2, 3);
        sudokuBoard.setElement(7, 2, 4);
        sudokuBoard.setElement(9, 2, 7);
        sudokuBoard.setElement(8, 2, 8);
        sudokuBoard.setElement(1, 3, 0);
        sudokuBoard.setElement(9, 3, 1);
        sudokuBoard.setElement(7, 3, 3);
        sudokuBoard.setElement(5, 3, 4);
        sudokuBoard.setElement(3, 3, 5);
        sudokuBoard.setElement(4, 3, 8);
        sudokuBoard.setElement(2, 4, 3);
        sudokuBoard.setElement(1, 4, 4);
        sudokuBoard.setElement(5, 5, 6);
        sudokuBoard.setElement(7, 5, 8);
        sudokuBoard.setElement(9, 6, 0);
        sudokuBoard.setElement(8, 6, 1);
        sudokuBoard.setElement(4, 6, 2);
        sudokuBoard.setElement(5, 6, 3);
        sudokuBoard.setElement(7, 6, 6);
        sudokuBoard.setElement(6, 6, 7);
        sudokuBoard.setElement(4, 7, 4);
        sudokuBoard.setElement(9, 7, 5);
        sudokuBoard.setElement(8, 7, 7);
        sudokuBoard.setElement(1, 8, 1);
        sudokuBoard.setElement(3, 8, 2);
        sudokuBoard.setElement(8, 8, 3);
        sudokuBoard.setElement(2, 8, 4);
        sudokuBoard.setElement(4, 8, 6);

        System.out.println(sudokuLogics.solveSudoku(sudokuBoard));

    }
}
