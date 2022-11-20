import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Testing module for my Graph realization.
 * For example, I use the graph:
 *   <---------<
 *  /           \
 * 1 -->  2  --> 4
 *  \     |     /
 *   \   V    /
 *    -> 3 ->
 *    and it's variations.
 */

public class GraphTests {

    /**
     * Test with incident matrix initialization.
     */
    @Test
    public void incidentMatrixTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 2},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 5};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Test with ways matrix initialization.
     */
    @Test
    public void waysMatrixTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[] edges = {1, 100, 2, 200, 2, 10};
        int[][] matrix = {{-1, 1, 0, 0},
                        {-1, 0, 1, 0},
                        {0, -1, 1, 0},
                        {0, -1, 0, 1},
                        {0, 0, -1, 1},
                        {1, 0, 0, -1}};
        Graph<Integer> graph = new Graph<>(vertexes, edges, matrix);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 5};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Test with incident list initialization.
     */
    @Test
    public void incidentListTest() {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Edge<Integer> e1 = new Edge<>(1, v1, v2);
        Edge<Integer> e2 = new Edge<>(100, v1, v3);
        Edge<Integer> e3 = new Edge<>(2, v2, v3);
        Edge<Integer> e4 = new Edge<>(200, v2, v4);
        Edge<Integer> e5 = new Edge<>(2, v3, v4);
        Edge<Integer> e6 = new Edge<>(10, v4, v1);
        v1.addWay(e1);
        v1.addWay(e2);
        v2.addWay(e3);
        v2.addWay(e4);
        v3.addWay(e5);
        v4.addWay(e6);
        List<Vertex<Integer>> vertexesList = new ArrayList<>();
        vertexesList.add(v1);
        vertexesList.add(v2);
        vertexesList.add(v3);
        vertexesList.add(v4);
        Graph<Integer> graph = new Graph<>(vertexesList);
        List<Vertex<Integer>> sorted = graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 5};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
        for (Vertex<Integer> i : sorted) {
            System.out.print(i.getValue());
            System.out.print("(");
            System.out.print(i.getShortestWay());
            System.out.println(")");
        }
    }

    /**
     * Tries to change vertex's value.
     */
    @Test
    public void setValueTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
                        {0, 0, 2, 200},
                        {0, 0, 0, 2},
                        {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        graph.vArray.get(1).setValue(11);
        Assertions.assertEquals(graph.vArray.get(1).getValue(), 11);
    }

    /**
     * Checks getFrom method return value.
     */
    @Test
    public void getFromTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
                         {0, 0, 2, 200},
                        {0, 0, 0, 2},
                        {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        Vertex<Integer> v1 = graph.eArray.get(1).getFrom();
        Assertions.assertEquals(graph.vArray.get(1), v1);
    }

    /**
     * Tries to change edge's weight.
     */
    @Test
    public void setWeightTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 2},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        graph.eArray.get(4).setWeight(4);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 7};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Adds a new vertex.
     */
    @Test
    public void addVertexTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 2},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        graph.addVertex(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        graph.addVertex(v6);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 5, -1, -1};
        for (int i = 1; i < 7; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Adds a new edge.
     */
    @Test
    public void addEdgeTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 0},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        Edge<Integer> e5 = new Edge<>(2);
        graph.addEdge(5, e5, 3, 4);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 5};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Remove edge by its object link.
     */
    @Test
    public void removeEdgeTest1() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 0},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        Edge<Integer> e5 = new Edge<>(2);
        graph.addEdge(5, e5, 3, 4);
        graph.removeEdge(e5);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 201};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Remove edge by its key.
     */
    @Test
    public void removeEdgeTest2() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 0},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        Edge<Integer> e5 = new Edge<>(2);
        graph.addEdge(5, e5, 3, 4);
        graph.removeEdge(5);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 3, 201};
        for (int i = 1; i < 5; i++){
            Assertions.assertEquals(graph.vArray.get(i).getShortestWay(), arr[i-1]);
        }
    }

    /**
     * Remove vertex by its key.
     */
    @Test
    public void removeVertexTest() {
        Integer[] vertexes = {1, 2, 3, 4};
        int[][] matrix = {{0, 1, 100, 0},
            {0, 0, 2, 200},
            {0, 0, 0, 2},
            {10, 0, 0, 0}};
        Graph<Integer> graph = new Graph<>(vertexes, matrix);
        graph.removeVertex(3);
        graph.deykstraAlgorithm(graph.vArray.get(1));
        int[] arr = {0, 1, 201};
        int cnt = 0;
        for (Vertex<Integer> i : graph.vArray.values()){
            Assertions.assertEquals(i.getShortestWay(), arr[cnt]);
            cnt++;
        }
    }

}
