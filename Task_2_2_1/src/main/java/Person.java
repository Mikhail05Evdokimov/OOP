public class Person extends Thread{
    int workSpeed;

    @Override
    public void run() {
        try {
            wait(workSpeed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.workDone();
    }

    private void workDone(){}
}