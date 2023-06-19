/**
 * Cook's class extends Person.
 * Cook can get order, finish it and move pizza to the stock.
 */

public class Cook extends Person {

    private Order currentOrder;

    /**
     * Class constructor.
     *
     * @param workTime - cook's working time for one pizza.
     * @param name - cook's name.
     */
    public Cook(int workTime, String name) {
        this.workSpeed = workTime;
        this.name = name;
        goHome = false;
    }

    /**
     * Gets an order from the orders queue.
     *
     * @return true if success, else return false.
     * @throws InterruptedException - if cook is waiting on orders queue.
     */
    private boolean takeOrder() throws InterruptedException {
        currentOrder = Pizzeria.getNextOrder();
        if (currentOrder != null) {
            System.out.println("C: Order " + currentOrder.orderName + " accepted.");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void run() {
        while (!(goHome)) {
            try {
                if (takeOrder()) {
                    while (!(goHome)) {
                        try {
                            if (workDone()) {
                                break;
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " Went home");
    }

    @Override
    protected boolean workDone() throws InterruptedException {
        try {
            sleep(workSpeed);
        }
        catch (InterruptedException e) {
            System.out.println("Cooker's thread has been interrupted");
        }
        Pizzeria.movePizzaToStock(currentOrder);
        return true;
    }
}