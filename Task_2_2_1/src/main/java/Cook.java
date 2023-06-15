public class Cook extends Person {

    Order currentOrder;

    public Cook(int workSpeed, String name) {
        this.workSpeed = workSpeed;
        this.name = name;
        goHome = false;
    }

    private boolean takeOrder() throws InterruptedException {
        if (Pizzeria.checkOrderQueue()) {
            return false;
        }
        currentOrder = Pizzeria.getNextOrder();
        System.out.println("C: Order " + currentOrder.orderName + " accepted.");
        return true;
    }

    @Override
    public void run() {
        while (!(goHome)) {
            try {
                if (takeOrder()) {
                    while (!(goHome)) {
                        try {
                            if (workDone()) break;
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
        sleep(workSpeed);
            Pizzeria.movePizzaToStock(currentOrder);
            return true;
    }
}