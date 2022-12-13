import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class with tests for my searcher.
 */
public class SearchTests {

    @Test
    public void simpleTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(6L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input1.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }

    @Test
    public void noSubstringTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input2.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }

    @Test
    public void atTheBeginningTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(0L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input3.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }

    @Test
    public void someSubstringsTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(6L);
        arr.add(16L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input4.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }

    @Test
    public void russianTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(7L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input5.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "мир"), arr);
        }
    }

    @Test
    public void myTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input6.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }

    @Test
    public void vladTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(2L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input7.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "ggi"), arr);
        }
    }

    @Test
    public void doubleLetterTest() throws IOException {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(1L);
        try (InputStream file = getClass().getClassLoader().getResourceAsStream("input8.txt")) {
            Assertions.assertEquals(FileSearcher.search(file, "world"), arr);
        }
    }
}
