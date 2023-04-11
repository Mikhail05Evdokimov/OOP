public class Cell {
    int x;
    int y;
    State state;
    public enum State {EMPTY, SNAKE, HEAD, APPLE};

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        state = State.EMPTY;
    }
}
