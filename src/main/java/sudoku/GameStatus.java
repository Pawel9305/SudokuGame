package sudoku;

import java.util.ArrayList;
import java.util.List;

public final class GameStatus {
    private final SudokuBoard currentStatus;
    private final List<Integer> coordinates;
    private final int guessedValue;


    public GameStatus(SudokuBoard currentStatus, int guessedValue) {
        this.currentStatus = currentStatus;
        this.coordinates = new ArrayList<>();
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getCurrentStatus() {
        return currentStatus;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
