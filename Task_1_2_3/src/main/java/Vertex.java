import  java.util.Objects;

public class Vertex<T> {
    private T value;
    private  int number;
    private boolean color;
    private int vertexCounter = 0;

    public Vertex<T> createVertex(T value) {
        this.color = false;
        this.value = value;
        this.number = vertexCounter;
        vertexCounter++;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public T getValue() {
        return value;
    }

    public boolean getColor() {
        return color;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (ob == null || getClass() != ob.getClass()) {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) ob;
        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
