import java.util.ArrayList;
import java.util.List;
import  java.util.Objects;

/**
 * Class Vertex for storing vertexes in Graph.
 *
 * @param <T> - type of vertex's value and key in HashMap.
 */
public class Vertex<T> {
    private int shortestWay;
    private final List<Edge<T>> ways;
    private T value;
    private boolean color;

    /**
     * Constructor for vertex as its value, white(false) color,
     * infinity the shortest way and list of incident edges.
     *
     * @param value - vertex's start value and its key in HashMap.
     */
    public Vertex(T value) {
        color = true;
        this.value = value;
        shortestWay = -1;
        ways = new ArrayList<>();
    }

    /**
     * List of incident edges getter.
     *
     * @return - list of incident edges.
     */
    public List<Edge<T>> getWays() {
        return ways;
    }

    /**
     * Adds a new edge to the list of incident edges.
     *
     * @param way - edge to add.
     */
    public void addWay(Edge<T> way) {
        ways.add(way);
    }

    /**
     * Vertex's value getter.
     *
     * @return value of vertex.
     */
    public T getValue() {
        return value;
    }

    /**
     * Vertex's shortest way getter.
     *
     * @return value of the shortest way to this vertex from start vertex.
     */
    public int getShortestWay() {
        return shortestWay;
    }

    /**
     * Vertex's shortest way setter.
     *
     * @param value - new shortest way value.
     */
    public void setShortestWay(int value) {
        shortestWay = value;
    }

    /**
     * Vertex's color getter.
     * Returns true if we didn't invite this vertex yet, else returns false.
     *
     * @return color of current vertex.
     */
    public boolean getColor() {
        return color;
    }

    /**
     * Vertex's value setter.
     *
     * @param value - a new value for this vertex.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Vertex's color setter.
     *
     * @param color - new color for this vertex.
     */
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
