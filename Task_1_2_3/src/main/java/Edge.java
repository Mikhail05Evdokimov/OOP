/**
 * Class Edge for storing ways in graph.
 *
 * @param <T> - Generic type of values in graph.
 */
public class Edge<T> {
    private int weight;
    private Vertex<T> from;
    private Vertex<T> to;

    /**
     * Constructor to create an edge as its weight and incident vertexes.
     *
     * @param weight - edge's weight.
     * @param from - incident FROM vertex.
     * @param to - incident TO vertex.
     */
    public Edge(int weight, Vertex<T> from, Vertex<T> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    /**
    * Constructor to create an edge when we know only weight.
    */
    public Edge(int weight) {
        this.weight = weight;
        this.to = null;
        this.from = null;
    }

    /**
     * Method for setting a weight.
     *
     * @param weight - new weight for edge.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Changes a FROM vertex of edge.
     *
     * @param vertex - new From vertex.
     */
    public void setFrom(Vertex<T> vertex) {
        this.from = vertex;
    }

    /**
     * Changes a TO vertex of edge.
     *
     * @param vertex - new To vertex.
     */
    public void setTo(Vertex<T> vertex) {
        this.to = vertex;
    }

    /**
     * Weight getter.
     *
     * @return - edge's weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * From getter.
     *
     * @return - from vertex of edge.
     */
    public Vertex<T> getFrom() {
        return from;
    }

    /**
     * To getter.
     *
     * @return - to vertex of edge.
     */
    public Vertex<T> getTo() {
        return to;
    }

}
