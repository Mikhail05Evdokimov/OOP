public class Cook extends Person {

    Order currentOrder;

    public Cook(int workSpeed) {
        this.workSpeed = workSpeed;
    }

    private boolean takeOrder() {
        if (Pizzeria.checkOrderQueue()) {
            return false;
        }
        synchronized (this){
            currentOrder = Pizzeria.getNextOrder();
        }
        System.out.println("C: Order " + currentOrder.orderName + " accepted.");
        return true;
    }

    @Override
    public void run() {
        while (true) {
            if (takeOrder()) {
                while (true) {
                    try {
                        if (workDone()) break;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private boolean workDone() throws InterruptedException {
        if (Pizzeria.stockIsFree()) {
            sleep(workSpeed);
            System.out.println("C: Order " + currentOrder.orderName + " cooked.");
            Pizzeria.movePizzaToStock(currentOrder);
            return true;
        }
        return false;
    }
}