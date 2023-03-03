package sudoku;


public final class GameStatus {
    private final SudokuBoard currentStatus;
    private final int row;
    private final int column;
    private int guessedValue;


    public GameStatus(SudokuBoard currentStatus, int row, int column, int guessedValue) {
        this.currentStatus = currentStatus;
        this.row = row;
        this.column = column;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getCurrentStatus() {
        return currentStatus;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
