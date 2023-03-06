package sudoku;

import java.util.Scanner;

public class GameCourse {

    public void gameplay() {
        SudokuLogics logics = new SudokuLogics();
        Scanner scanner = new Scanner(System.in);
        SudokuBoard playingBoard = SudokuBoard.createTheBoard();
        String answer = "";
        int boardSize = playingBoard.getBoard().size();
        boolean isGameFinished = false;

        while (!isGameFinished) {
            System.out.println("Insert row: ");
            int row = scanner.nextInt();
            System.out.println("Insert column: ");
            int column = scanner.nextInt();
            System.out.println("Insert desired value: ");
            int value = scanner.nextInt();
            if (row > boardSize || column > boardSize) {
                System.out.println("Inserted number is too large! The maximum value is 9.");
            } else {
                SudokuElement usersElement = playingBoard.getBoard().get(row - 1).getFields().get(column - 1);
                logics.preparePossibilities(row - 1, column - 1, usersElement, playingBoard);
                if (usersElement.getPossibilities().contains(value)) {
                    usersElement.setValue(value);
                    System.out.println(playingBoard);
                } else {
                    System.out.println("This number is unavailable in this field! Try another one.");
                }
            }
            System.out.println("Type 'Sudoku' to solve Sudoku puzzles or anything else to continue playing: ");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("Sudoku")) {
                boolean isEnoughFilled = playingBoard.checkFillings();
                if (isEnoughFilled) {
                    System.out.println(logics.solveSudoku(playingBoard) +
                            "\nSudoku solved! Do you want to restart? [y/n]");
                    answer = scanner.next();
                    if (answer.equalsIgnoreCase("n")) {
                        isGameFinished = true;
                    }
                } else {
                    System.out.println("There are not enough numbers inserted!");
                }
            }
        }
    }
}


