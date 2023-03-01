package sudoku;

import java.util.ArrayList;
import java.util.List;

public final class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> board;
    public static final int BOARD_SIZE = 9;

    public SudokuBoard() {
        board = new ArrayList<>();
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public static SudokuBoard createTheBoard() {
        SudokuBoard playingBoard = new SudokuBoard();
        for (int i = 0; i < BOARD_SIZE; i++) {
            playingBoard.getBoard().add(new SudokuRow());
            for (int j = 0; j < BOARD_SIZE; j++) {
                playingBoard.getBoard().get(i).getFields().add(SudokuElement.createEmptyElement(BOARD_SIZE));
            }
        }
        return playingBoard;
    }

    public void setElement(int value, int row, int column) {
        board.get(row).getFields().get(column).setValue(value);
        board.get(row).getFields().get(column).getPossibilities().remove(value);
    }

    public SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow iterator : board) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : iterator.getFields()) {
                SudokuElement clonedElement = new SudokuElement();
                clonedElement.setValue(element.getValue());
                clonedRow.getFields().add(clonedElement);
                for (Integer possibility : element.getPossibilities()) {
                    clonedElement.getPossibilities().add(possibility);
                }
            }

            clonedBoard.getBoard().add(clonedRow);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        String result = "";
        for (SudokuRow row : board) {
            for (int i = 0; i < row.getFields().size(); i++) {
                int columnContent = row.getFields().get(i).getValue();
                if (columnContent == -1) {
                    result += "| ";
                } else {
                    result += "|" + columnContent;
                }
            }
            result += "|\n";
        }
        return result;
    }
}
