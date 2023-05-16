public abstract class Person extends Thread {
    int workSpeed;
    String name;
    boolean goHome;

    protected abstract boolean workDone() throws InterruptedException;
}