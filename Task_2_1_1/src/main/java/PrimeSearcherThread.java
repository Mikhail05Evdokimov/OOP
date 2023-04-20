import java.util.ArrayList;
import java.util.List;

/**
 * Class for checking an integers array for not-prime number.
 * Here I use threads for parallel calculations.
 */
public class PrimeSearcherThread {
    static boolean flag = false;

    private static final Object lockObject = new Object();

    /**
     * Subclass, which is responsible for threads creating and using.
     */
    private static class MyThread extends Thread {
        private List<Integer> numbers;

        /**
         * Override run method, now it checks either number prime either not.
         */
        @Override
        public void run() {
            for (int i : numbers) {
                primeNumberOrNotChecking(i);
            }
        }

        private void createNumbersArray(int block, int currentThread, List<Integer> arr) {
            numbers = new ArrayList<>();
            if (currentThread * block + block > arr.size()) {
                numbers.addAll(arr.subList(currentThread * block,
                    arr.size()));
            }
            else {
                numbers.addAll(arr.subList(currentThread * block,
                    currentThread * block + block));
            }
        }
    }

    private static void primeNumberOrNotChecking(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                synchronized (lockObject) {
                    flag = true;
                }
                break;
            }
        }
    }

    /**
     * Class constructor.
     *
     * @param arr - input array.
     * @param threadsCount - number of wishing threads.
     * @return true if there is a not-prime number, false otherwise.
     */
    public static boolean searcher(List<Integer> arr, int threadsCount) {
        if (threadsCount < 1 || threadsCount > arr.size()) {
            throw new IllegalArgumentException("Bad threads number");
        }
        MyThread[] myThreads = new MyThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            myThreads[i] = new MyThread();
        }
        int currentThreadNumber = 0;
        int block = arr.size() / threadsCount + 1;
        for (MyThread i : myThreads) {
            if (!(currentThreadNumber * block > arr.size())) {
                i.createNumbersArray(block, currentThreadNumber, arr);
                currentThreadNumber++;
                i.start();
            }
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