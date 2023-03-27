import java.util.ArrayDeque;
import java.util.Queue;

public class Delivery extends Person{
    int baggage;
    Queue<Order> currentOrders;

    public Delivery(int bag, int speed) {
        currentOrders = new ArrayDeque<>();
        baggage = bag;
        workSpeed = speed;
    }

    private boolean takeOrders() {
        if (Pizzeria.stockIsEmpty()) {
            return  false;
        }
        //синхрнизировать проверку в цикле
        while (baggage > currentOrders.size() && !(Pizzeria.stockIsEmpty())) {
            Order order = Pizzeria.takePizzaFromStock();
            System.out.println("D: Order " + order.orderName + " in a way.");
            currentOrders.add(order);
        }
        return true;
    }

    private void workDone() throws InterruptedException {
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
