import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Delivery extends Person{
    int baggage;
    Queue<Order> currentOrders;

    public Delivery(int bag, int speed) {
        currentOrders = new ArrayDeque<>();
        baggage = bag;
        workSpeed = speed;
    }

    private boolean takeOrders() { //wait + notify
        List<Order> orders = Pizzeria.takePizzaFromStock(baggage);
        currentOrders.addAll(orders);
        return currentOrders.size() != 0;
    }

    private void workDone() throws InterruptedException { //обработкa исключений
        sleep(currentOrders.element().distance / workSpeed);
        System.out.println("D: Order " + currentOrders.remove().orderName + " delivered.");
    }

    @Override
    public void run() {
        while (true) {
            if (takeOrders()) {
                while (!(currentOrders.isEmpty())) {
                    try {
                        workDone();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
