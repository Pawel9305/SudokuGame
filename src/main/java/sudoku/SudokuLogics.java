package sudoku;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuLogics {

    public void resolveSudoku(SudokuBoard board) {
        Random randomValueFromPossibilities = new Random();
        boolean isSolved = false;
        while(isSolved) {
            for (int i = 0; i < board.getBoard().size(); i++) {
                for (int j = 0; j < board.getBoard().size(); j++) {

                    SudokuElement currentElement = board.getBoard().get(i).getFields().get(j);
                    if (currentElement.getValue() == SudokuElement.EMPTY) {
                        if (currentElement.getPossibilities().size() == 0) {

                        }
                        preparePossibilities(i, j, currentElement, board);
                        currentElement.setValue(

                    }
                    System.out.println(board);
                }
            }
        }
    }

    public void preparePossibilities(int row, int column, SudokuElement element, SudokuBoard board) {
        element.getPossibilities().removeAll(rowValues(row,board));
        element.getPossibilities().removeAll(columnValues(column, board));
        element.getPossibilities().removeAll(sectionValues(row, column, board));

    }

    public Set<Integer> rowValues(int row, SudokuBoard board) {
        return board.getBoard().get(row).getFields().stream()
                .map(SudokuElement::getValue)
                .filter(value -> value != SudokuElement.EMPTY)
                .collect(Collectors.toSet());
    }

    public Set<Integer> columnValues(int column, SudokuBoard board) {
        Set<Integer> columnValuesInserted = new HashSet<>();
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (j == column) {
                    int value = board.getBoard().get(i).getFields().get(column).getValue();
                    if (value != SudokuElement.EMPTY) {
                        columnValuesInserted.add(value);
                    }
                }
            }
        }
        return columnValuesInserted;
    }

    public Set<Integer> sectionValues(int row, int column, SudokuBoard board) {
        Set<Integer> sectionValuesInserted = new HashSet<>();
        for (int i = 0; i < board.getBoard().size(); i += 3) {
            for (int j = 0; j < board.getBoard().size(); j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        int sectionNumber = board.getBoard().get(k).getFields().get(l).getValue();
                        if (sectionNumber != SudokuElement.EMPTY) {
                            sectionValuesInserted.add(sectionNumber);
                        }
                    }
                }
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (k == row && l == column) {
                            return sectionValuesInserted;
                        }
                    }
                }
                sectionValuesInserted.clear();
            }
        }
        return Collections.emptySet();
    }
}


