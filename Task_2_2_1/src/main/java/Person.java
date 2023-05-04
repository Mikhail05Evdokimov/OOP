public abstract class Person extends Thread {
    int workSpeed;


    protected abstract boolean workDone() throws InterruptedException;
}