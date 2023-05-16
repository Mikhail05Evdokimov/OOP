import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my Parallel Stream Prime searcher.
 */
public class StreamTests {

    @Test
    public void smallTestFalse() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        Assertions.assertFalse(StreamSearcher.searcher(arr));
    }

    @Test
    public void smallTestTrue() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        Assertions.assertTrue(StreamSearcher.searcher(arr));
    }

    @Test
    public void bigTest() {
        List<Integer> arr = new ArrayList<>();
        InputStream file = getClass().getClassLoader().getResourceAsStream("input.txt");
        assert file != null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        long date1 = System.currentTimeMillis();
        Assertions.assertFalse(StreamSearcher.searcher(arr));
        long date2 = System.currentTimeMillis();
        System.out.println(date2 - date1);
    }
}