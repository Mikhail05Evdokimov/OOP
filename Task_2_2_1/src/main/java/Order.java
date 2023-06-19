/**
 * Class for orders with names and distances.
 */
public class Order {
    String orderName;
    int distance;

    /**
     * Class constructor.
     * @param name - new order's name.
     * @param dist - order's distance.
     */
    public Order(String name, int dist) {
        orderName = name;
        distance = dist;
    }
}
