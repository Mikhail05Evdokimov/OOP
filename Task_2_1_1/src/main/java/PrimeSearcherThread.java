import java.util.ArrayList;
import java.util.List;

public class PrimeSearcherThread {
    //private static System.Logger log = System.Logger.getLogger(PrimeSearcherThread.class.getName());
    static boolean flag = false;

    private static final Object lockObject = new Object();
    private static class MyThread extends Thread {
        List<Integer> numbers;

        @Override
        public void run() {
            for (int i : numbers) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        synchronized (lockObject) {
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }
    }

    public static boolean Searcher(List<Integer> arr, int threadsCount) {
        if (threadsCount < 1 || threadsCount > arr.size()) {
            throw new IllegalArgumentException("Bad threads number");
        }
        MyThread[] myThreads = new MyThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            myThreads[i] = new MyThread();
            myThreads[i].numbers = new ArrayList<>();
        }
        int currentThread = 0;
        int block = arr.size() / threadsCount;
        for (MyThread i : myThreads) {
            i.numbers.addAll(arr.subList(currentThread * block,
                currentThread * block + block));
            currentThread++;
            i.start();
        }

        for (MyThread i : myThreads) {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}