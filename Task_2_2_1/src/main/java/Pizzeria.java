import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            stockQueue.notifyAll();
        }
    }

    public static List<Order> takePizzaFromStock(int baggageSize) throws InterruptedException {
        synchronized (stockQueue) {
            while (stockQueue.isEmpty()) {
                stockQueue.wait();
            }
            List<Order> currentOrders = new ArrayList<>();
            Order order;
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