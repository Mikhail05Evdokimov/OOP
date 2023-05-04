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

    private boolean takeOrders() throws InterruptedException {
        List<Order> orders = Pizzeria.takePizzaFromStock(baggage);
        currentOrders.addAll(orders);
        return currentOrders.size() != 0;
    }

    @Override
    protected boolean workDone() throws InterruptedException { //обработкa исключений
        sleep(currentOrders.element().distance / workSpeed);
        System.out.println("D: Order " + currentOrders.remove().orderName + " delivered.");
        return true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (takeOrders()) {
                    while (!(currentOrders.isEmpty())) {
                        try {
                            workDone();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
