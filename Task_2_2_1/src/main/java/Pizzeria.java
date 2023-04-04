import java.util.*;

public class Pizzeria {

    private static Queue<Order> stockQueue;
    private static Queue<Order> ordersQueue;
    private static int capacity;
    private static int currentNumber;

    public Pizzeria(int cap) {
        capacity = cap;
        ordersQueue = new ArrayDeque<>();
        stockQueue = new ArrayDeque<>();
        currentNumber = 0;
    }

    public static void newOrder(String orderName, int distance) {
        synchronized (ordersQueue) {
            ordersQueue.add(new Order(orderName, distance));
        }
    }

    public static boolean checkOrderQueue() {
        synchronized (ordersQueue) {
            return ordersQueue.isEmpty();
        }
    }

    public static Order getNextOrder() {
        synchronized (ordersQueue) {
            return ordersQueue.remove();
        }
    }

    public static boolean stockIsFree() {
        return (capacity > currentNumber);
    }

    public static void movePizzaToStock(Order order) {
        synchronized (stockQueue) {
            stockQueue.add(order);
            currentNumber++;
        }
    }

    public static boolean stockIsEmpty() {
        synchronized (stockQueue) {
            return stockQueue.isEmpty();
        }
    }

    public static List<Order> takePizzaFromStock(int baggageSize) {
        List<Order> currentOrders = new ArrayList<>();
        Order order;
        synchronized (stockQueue) {
            while (!(stockQueue.isEmpty()) && currentOrders.size() < baggageSize) {
                currentNumber--;
                order = stockQueue.remove();
                System.out.println("D: Order " + order.orderName + " in a way.");
                currentOrders.add(order);
            }
            return currentOrders;
        }
    }
}