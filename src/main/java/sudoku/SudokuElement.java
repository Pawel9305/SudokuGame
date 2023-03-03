package sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {

    protected static final int EMPTY = -1;
    private int value;
    private Set<Integer> possibilities;

    public SudokuElement() {
        this.value = EMPTY;
        possibilities = new HashSet<>();
    }

    public static SudokuElement createEmptyElement(int size) {
        SudokuElement element = new SudokuElement();
        for (int i = 0; i < size; i++) {
            element.getPossibilities().add(i + 1);
        }
        return element;
    }

    public int getValue() {
        return value;
    }

    public Set<Integer> getPossibilities() {
        return possibilities;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
