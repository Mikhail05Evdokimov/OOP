import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
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
        }
    }

    public static boolean stockIsEmpty() {
        synchronized (stockQueue) {
            return stockQueue.isEmpty();
        }
    }

    public static Order takePizzaFromStock() {
        synchronized (stockQueue) {
            if (!(stockQueue.isEmpty())) {
                currentNumber--;
                return stockQueue.remove();
            }
            else {
                throw new ConcurrentModificationException("Склад пуст");
            }
        }
    }
}