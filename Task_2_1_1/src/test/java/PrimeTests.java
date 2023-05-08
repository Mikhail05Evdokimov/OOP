import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my primeSearcher.
 */
public class PrimeTests {

    @Test
    public void noParallelTestFalse() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        Assertions.assertFalse(PrimeSearcher.searcher(arr));
    }

    @Test
    public void noParallelTestTrue() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(8);
        arr.add(5);
        Assertions.assertTrue(PrimeSearcher.searcher(arr));
    }

    @Test
    public void noParallelTestBig() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        long date1 = System.currentTimeMillis();
        Assertions.assertFalse(PrimeSearcher.searcher(arr));
        long date2 = System.currentTimeMillis();
        System.out.println(date2 - date1);
    }
}