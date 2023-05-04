public class Main {
    public static void main(String[] args) {
        new Pizzeria(10);
        var cook1 = new Cook(300);
        var cook2 = new Cook(400);
        var del1 = new Delivery(1, 2);
        var del2 = new Delivery(2, 3);
        cook2.start();
        cook1.start();
        del2.start();
        del1.start();
        Pizzeria.newOrder("1", 1000);
        Pizzeria.newOrder("2", 600);
        Pizzeria.newOrder("3", 400);
        Pizzeria.newOrder("4", 200);
        Pizzeria.newOrder("5", 300);
        Pizzeria.newOrder("last", 500);
        //while (true) {

        //} //подумать над аккуратным завершением
    }
}
