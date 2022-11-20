import java.util.*;

/**
 * Generic class Graph which support three methods of initialisation and can be sorted by DeykstraAlgorithm.
 *
 * @param <T> - type of vertex's value and HashMap key.
 */
public class Graph<T> implements Comparable<T> {
    public final Map<T, Vertex<T>> vArray;
    public final Map<Integer, Edge<T>> eArray;

    /**
     * Graph constructor which works with a List of Vertexes (each vertex has to know it's FROM edges).
     *
     * @param vertexes - List of vertexes.
     */
    public Graph(List<Vertex<T>> vertexes) {
        this.vArray = new HashMap<>();
        this.eArray = new HashMap<>();
        int eCnt = 0;
        for(Vertex<T> i : vertexes) {
            vArray.put(i.getValue(), i);
            for(Edge<T> j : i.getWays()) {
                eArray.put(eCnt, j);
                eCnt++;
            }
        }
    }

    /**
     * Graph constructor which works with a way's matrix.
     *    v1 v2 v3
     * v1 0  2  5
     * v2 1  0  3
     * v3 7  4  0
     *
     * @param arrayOfValues - array of values for vertexes.
     * @param waysMatrix - double array of ways between vertexes.
     */
    public Graph(T[] arrayOfValues, int[][] waysMatrix) {
        vArray = new HashMap<>();
        eArray = new HashMap<>();
        for (T i : arrayOfValues) {
            vArray.put(i, new Vertex<>(i));
        }
        int eCnt = 0;
        for (int i = 0; i < waysMatrix.length; i++) {
            int x = 0;
            for (int j : waysMatrix[i]) {
                if (j != 0 && i != x) {
                    eArray.put(eCnt, new Edge<>(j, vArray.get(arrayOfValues[i]), vArray.get(arrayOfValues[x])));
                    vArray.get(arrayOfValues[i]).addWay(eArray.get(eCnt));
                    eCnt++;
                }
                x++;
            }
        }
    }

    /**
     * Graph constructor which works with an incident matrix.
     *    v1 v2 v3
     * e1 0  1  -1
     * e2 1  0  -1
     * e3 -1  0  1
     *
     * @param arrayOfValues - array of values for vertexes.
     * @param arrayOfWeights - array of edge's weights.
     * @param waysMatrix - double array of connections between vertexes and edges.
     */
    public Graph(T[] arrayOfValues, int[] arrayOfWeights, int[][] waysMatrix) {
        vArray = new HashMap<>();
        eArray = new HashMap<>();
        for (T i : arrayOfValues) {
            vArray.put(i, new Vertex<>(i));
        }

        for (int i = 0; i < waysMatrix.length; i++) {
            int fromBuff = 0, toBuff = 0;
            for (int j = 0; j < waysMatrix[i].length; j++) {
                if (waysMatrix[i][j] != 0) {
                    if (waysMatrix[i][j] == 1) {
                        toBuff = j;
                    }
                    else {
                        fromBuff = j;
                    }
                }
            }
            if(fromBuff != 0 || toBuff != 0) {
                eArray.put(i, new Edge<>(arrayOfWeights[i], vArray.get(arrayOfValues[fromBuff]), vArray.get(arrayOfValues[toBuff])));
                vArray.get(arrayOfValues[fromBuff]).addWay(eArray.get(i));
            }
            else {
               System.out.println("Warning: There is a vertex from void to void");
            }
        }
    }

    /**
     * Deykstra algorithm for searching shortest ways from start vertex to others.
     * It uses BFS and compare the shortest way of current vertex with ways of current vertex's neighbors and choose the best one.
     *
     * @param start - start vertex.
     * @return - sorted list of vertexes in order from short way to long way.
     */
    public List<Vertex<T>> deykstraAlgorithm(Vertex<T> start){
        for (Vertex<T> i : vArray.values()) {
          i.setShortestWay(-1);
          i.setColor(true);
         }
         start.setShortestWay(0);
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        queue.add(start);
        while (!(queue.isEmpty())) {
            Vertex<T> current = queue.remove();
            current.setColor(false);
            for (Edge<T> i : current.getWays()) {
                if (i.getTo().getColor()) {
                    if (i.getTo().getShortestWay() == -1 || (i.getTo().getShortestWay() != -1 && i.getTo().getShortestWay() > (current.getShortestWay() + i.getWeight()))) {
                        i.getTo().setShortestWay(current.getShortestWay() + i.getWeight());
                    }
                    queue.add(i.getTo());
                }
            }
        }
        List<Vertex<T>> sortedVertexes = new ArrayList<>();
        for(Vertex<T> i : vArray.values()) {
            int j = 0;
            while(j < sortedVertexes.size() && i.getShortestWay() > sortedVertexes.get(j).getShortestWay()) {
                j++;
            }
            sortedVertexes.add(j, i);
        }
        return(sortedVertexes);
    }

    /**
     * Adds a new vertex to graph by its object link.
     *
     * @param vertex - new vertex to add.
     */
    public void addVertex(Vertex<T> vertex) {
        this.vArray.put(vertex.getValue(), vertex);
    }

    /**
     * Creates a new vertex by its value and adds it to graph.
     *
     * @param value - new vertex's value.
     */
    public void addVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        this.vArray.put(vertex.getValue(), vertex);
    }

    /**
     * Removes vertex from graph by its key and removes it's TO edges from other's vertexes ways lists.
     *
     * @param key - key of vertex to delete.
     */
    public void removeVertex(T key) {
        for (Edge<T> i : this.eArray.values()) {
            if(i.getTo() == this.vArray.get(key)) {
                i.getFrom().getWays().remove(i);
            }
        }
        this.vArray.get(key).getWays().clear();
        this.vArray.remove(key);
    }

    /**
     * Adds a new edge to graph using its key(it must be a free edge's number), object link and keys of incident vertexes.
     *
     * @param key - number of a new edge. (User can use graph.eArray.size() to know the closest free number).
     * @param edge - edge to add.
     * @param from - From vertex's key.
     * @param to - To vertex's key.
     */
    public void addEdge(Integer key, Edge<T> edge, T from, T to) {
        edge.setFrom(this.vArray.get(from));
        edge.setTo(this.vArray.get(to));
        this.eArray.put(key,edge);
        this.vArray.get(from).addWay(edge);
    }

    /**
     * Removes an edge by key.
     *
     * @param key - edge's key.
     */
    public void removeEdge(T key) {
        this.eArray.get(key).getFrom().getWays().remove(eArray.get(key));
        this.eArray.remove(key);
    }

    /**
     * Removes an edge by object link.
     *
     * @param edge - edge to delete.
     */
    public void removeEdge(Edge<T> edge) {
        edge.getFrom().getWays().remove(edge);
        this.eArray.values().remove(edge);
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

}