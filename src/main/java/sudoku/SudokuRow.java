package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    protected List<SudokuElement> fields;

    public SudokuRow() {
        fields = new ArrayList<>();
    }

    public List<SudokuElement> getFields() {
        return fields;
    }
}
