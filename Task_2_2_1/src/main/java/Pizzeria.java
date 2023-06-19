import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Pizzeria static class with stock and orders queues and
 * methods to work with it.
 */
public class Pizzeria {

    private static Queue<Order> stockQueue;
    private static Queue<Order> ordersQueue;
    private static int capacity;
    private static int currentNumber;

    /**
     * Class constructor.
     *
     * @param cap - stock capacity.
     */
    public Pizzeria(int cap) {
        capacity = cap;
        ordersQueue = new ArrayDeque<>();
        stockQueue = new ArrayDeque<>();
        currentNumber = 0;
    }

    /**
     * Creates new order and adds it to orders queue.
     *
     * @param orderName - new order's name.
     * @param distance - how long a delivery should run.
     */
    public static void newOrder(String orderName, int distance) {
        synchronized (ordersQueue) {
            ordersQueue.add(new Order(orderName, distance));
            ordersQueue.notifyAll();
        }
    }

    /**
     * Gives next order to cook.
     *
     * @return - next order from orders queue.
     */
    public static Order getNextOrder() {
        synchronized (ordersQueue) {
            try {
                while (ordersQueue.isEmpty()) {
                    ordersQueue.wait();
                }
                return ordersQueue.remove();
            }
            catch (InterruptedException e) {
                System.out.println("Cooker's thread has been interrupted");
            }
            return null;
        }
    }

    private static boolean stockIsFree() {
        return (capacity > currentNumber);
    }

    public static void movePizzaToStock(Order order) throws InterruptedException {
        synchronized (stockQueue) {
            try {
                while (!(stockIsFree())) {
                    stockQueue.wait();
                }
            }
            catch (InterruptedException e) {
                System.out.println("Cooker's thread has been interrupted");
            }
            stockQueue.add(order);
            currentNumber++;
            System.out.println("C: Order " + order.orderName + " cooked.");
            stockQueue.notifyAll();
        }
    }

    public static List<Order> takePizzaFromStock(int baggageSize) {
        List<Order> currentOrders = new ArrayList<>();
        synchronized (stockQueue) {
            try {
                while (stockQueue.isEmpty() && !(Thread.currentThread().isInterrupted())) {
                    stockQueue.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Delivery's thread has been interrupted");
            }
            Order order;
            while (!(stockQueue.isEmpty()) && currentOrders.size() < baggageSize) {
                currentNumber--;
                order = stockQueue.remove();
                System.out.println("D: Order " + order.orderName + " in a way.");
                currentOrders.add(order);
            }
            stockQueue.notifyAll();
            return currentOrders;
        }
    }
}