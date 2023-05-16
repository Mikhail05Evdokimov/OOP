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
            ordersQueue.notifyAll();
        }
    }

    public static boolean checkOrderQueue() {
        synchronized (ordersQueue) {
            return ordersQueue.isEmpty();
        }
    }

    public static Order getNextOrder() throws InterruptedException {
        synchronized (ordersQueue) {
            while (ordersQueue.isEmpty()) {
                ordersQueue.wait();
            }
            return ordersQueue.remove();
        }
    }

    private static boolean stockIsFree() {
        return (capacity > currentNumber);
    }

    public static void movePizzaToStock(Order order) throws InterruptedException {
        synchronized (stockQueue) {
            while (!(stockIsFree())) {
                stockQueue.wait();
            }
            stockQueue.add(order);
            currentNumber++;
            System.out.println("C: Order " + order.orderName + " cooked.");
            stockQueue.notifyAll();
        }
    }

    public static List<Order> takePizzaFromStock(int baggageSize) throws InterruptedException {
        List<Order> currentOrders = new ArrayList<>();
        synchronized (stockQueue) {
            while (stockQueue.isEmpty()) {
                stockQueue.wait();
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