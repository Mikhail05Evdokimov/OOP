public class Field {
    private final int xSize;
    private final int ySize;
    private Cell[][] field;

    public Field(int xSize, int ySize) {
        field = new Cell[ySize][xSize];
        this.xSize = xSize;
        this.ySize = ySize;
        for (int i = 0; i < this.ySize; i++ ) {
            for (int j = 0; j < this.xSize; j++) {
                field[i][j] = new Cell(j, i);
            }
        }
    }
}
