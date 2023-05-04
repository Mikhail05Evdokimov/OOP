import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my Thread Parallel Prime searcher.
 */
public class ThreadTests {

    Integer[] brr = {2, 3, 5, 7, 11};
    @Test
    public void parallelTestTrue() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(11);
        arr.add(13);
        arr.add(17);
        arr.add(19);
        arr.add(19);
        arr.add(19);
        arr.add(10);
        Assertions.assertTrue(PrimeSearcherThread.searcher(arr, 3));
    }

    @Test
    public void parallelTestBig4() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 4));
    }

    @Test
    public void parallelTestBig2() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 2));
    }

    @Test
    public void parallelTestBig6() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 6));
    }

    @Test
    public void parallelTestBig8() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 8));
    }

    @Test
    public void parallelTestBig16() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 16));
    }

    @Test
    public void parallelTestBig32() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 32));
    }

    @Test
    public void parallelTestBig100() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        Assertions.assertFalse(PrimeSearcherThread.searcher(arr, 100));
    }
}