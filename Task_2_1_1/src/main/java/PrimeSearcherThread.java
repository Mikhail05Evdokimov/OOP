import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.sqrt;

public class PrimeSearcherThread {
    static boolean flag = false;
    private static class MyThread extends Thread {
        List<Integer> numbers;

        @Override
        public void run() {
            for (int i : numbers) {
                //for (int j = 2; j <= sqrt(i); j++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        synchronized (this) {
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
