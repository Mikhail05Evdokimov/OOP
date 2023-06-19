import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Delivery's class extends Person.
 * Delivery can take pizza from the stock and deliver it.
 */
public class Delivery extends Person {
    private final int baggage;
    private final Queue<Order> currentOrders;

    /**
     * Class constructor.
     *
     * @param bagSize - baggage capacity.
     * @param speed - delivery's moving speed.
     * @param name - his name.
     */
    public Delivery(int bagSize, int speed, String name) {
        currentOrders = new ArrayDeque<>();
        baggage = bagSize;
        workSpeed = speed;
        this.name = name;
        goHome = false;
    }

    /**
     * Gets pizza from stock queue,
     * while he has place in bag and there are some pizza in stock.
     *
     * @return - true if got some pizza in bag.
     * @throws InterruptedException - while waiting on stock queue.
     */
    private boolean takeOrders() throws InterruptedException {
        List<Order> orders = Pizzeria.takePizzaFromStock(baggage);
        currentOrders.addAll(orders);
        return currentOrders.size() != 0;
    }

    @Override
    protected boolean workDone() throws InterruptedException {
        try {
            sleep(currentOrders.element().distance / workSpeed);
        }
        catch (InterruptedException e) {
            System.out.println("Delivery's thread has been interrupted");
        }
        System.out.println("D: Order " + currentOrders.remove().orderName + " delivered.");
        return true;
    }

    @Override
    public void run() {
        while (!goHome) {
            try {
                if (takeOrders()) {
                    while (!currentOrders.isEmpty()) {
                        workDone();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " Went home");
    }
}
