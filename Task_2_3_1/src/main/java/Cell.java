public class Cell {
    private final int x;
    private final int y;
    private State state;
    private int snakeTimer;
    public enum State {EMPTY, SNAKE, HEAD, APPLE};

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        snakeTimer = 0;
        state = State.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void update(boolean changeTimer){
        if (changeTimer && snakeTimer > 0){
            snakeTimer--;
            if (snakeTimer == 0) {
                state = State.EMPTY;
            }
        }
    }



}
