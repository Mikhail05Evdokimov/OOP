public abstract class Person extends Thread {
    protected int workSpeed;
    protected String name;
    protected volatile boolean goHome;

    /**
     * Thread imitates stuff work and reports it to the console.
     *
     * @return true in case of success, false else.
     * @throws InterruptedException - if thread is interrupted while sleeping.
     */
    protected abstract boolean workDone() throws InterruptedException;
}