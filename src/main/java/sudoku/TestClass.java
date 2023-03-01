package sudoku;

public class TestClass {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = SudokuBoard.createTheBoard();
        SudokuLogics sudokuLogics = new SudokuLogics();

        sudokuBoard.setElement(1, 0, 0);
        sudokuBoard.setElement(2, 0, 1);
        sudokuBoard.setElement(7, 0, 4);
        sudokuBoard.setElement(4, 0, 7);
        sudokuBoard.setElement(5, 0, 8);
        sudokuBoard.setElement(5, 1, 4);
        sudokuBoard.setElement(4, 2, 2);
        sudokuBoard.setElement(1, 2, 5);
        sudokuBoard.setElement(2, 2, 8);
        sudokuBoard.setElement(3, 3, 1);
        sudokuBoard.setElement(1, 3, 3);
        sudokuBoard.setElement(2, 3, 4);
        sudokuBoard.setElement(7, 3, 6);
        sudokuBoard.setElement(9, 3, 8);
        sudokuBoard.setElement(9, 4, 2);
        sudokuBoard.setElement(5, 4, 7);
        sudokuBoard.setElement(6, 5, 0);
        sudokuBoard.setElement(4, 5, 5);
        sudokuBoard.setElement(8, 6, 0);
        sudokuBoard.setElement(2, 6, 5);
        sudokuBoard.setElement(3, 6, 8);
        sudokuBoard.setElement(7, 7, 1);
        sudokuBoard.setElement(6, 7, 3);
        sudokuBoard.setElement(1, 7, 4);
        sudokuBoard.setElement(8, 7, 6);
        sudokuBoard.setElement(5, 8, 0);
        sudokuBoard.setElement(6, 8, 7);
        sudokuBoard.setElement(7, 1, 0);
        System.out.println(sudokuBoard);
        sudokuLogics.resolveSudoku(sudokuBoard);
        System.out.println(sudokuBoard);

        System.out.println(sudokuBoard);


    }
}
