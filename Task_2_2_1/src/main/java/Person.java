public abstract class Person extends Thread {
    int workSpeed;
    String name;

    protected abstract boolean workDone() throws InterruptedException;
}