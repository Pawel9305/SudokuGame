package sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuLogics {

    private List<GameStatus> backTrack;

    public SudokuLogics() {
        this.backTrack = new ArrayList<>();
    }

    public SudokuBoard resolveSudoku(SudokuBoard board) {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().get(i).getFields().size(); j++) {
                SudokuElement currentElement = board.getBoard().get(i).getFields().get(j);
                if (currentElement.getValue() == SudokuElement.EMPTY) {
                    preparePossibilities(i, j, currentElement, board);
                    if (!currentElement.getPossibilities().isEmpty()) {
                        currentElement.getPossibilities().stream().findAny().ifPresent(currentElement::setValue);
                        try {
                            backTrack.add(new GameStatus(board.deepCopy(), i, j, currentElement.getValue()));
                        } catch (CloneNotSupportedException e) {
                            System.err.println(e);
                        }
                    } else {
                        board = loadAndModifyPrevField(backTrack);
                        currentElement.getPossibilities().stream().findAny().ifPresent(currentElement::setValue);
                    }
                }
            }
        }
        System.out.println(board);
        return board;
    }


    public void preparePossibilities(int row, int column, SudokuElement element, SudokuBoard board) {
        element.getPossibilities().removeAll(rowValues(row, board));
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

    public SudokuBoard loadAndModifyPrevField(List<GameStatus> backTrack) {

        for (int i = 1; i < backTrack.size(); i++) {
            SudokuBoard savedBoard = backTrack.get(backTrack.size() - i).getCurrentStatus();
            int row = backTrack.get(backTrack.size() - i).getRow();
            int column = backTrack.get(backTrack.size() - i).getColumn();
            int guessedValue = backTrack.get(backTrack.size() - i).getGuessedValue();
            SudokuElement loadedElement = savedBoard.getBoard().get(row).getFields().get(column);
            loadedElement.getPossibilities().remove(guessedValue);
            loadedElement.setValue(SudokuElement.EMPTY);
            if (!loadedElement.getPossibilities().isEmpty()) {
                loadedElement.getPossibilities().stream()
                        .findAny()
                        .ifPresent(loadedElement::setValue);
                return savedBoard;
            }
        }
        return null;
    }

    public List<GameStatus> getBackTrack() {
        return backTrack;
    }
}


