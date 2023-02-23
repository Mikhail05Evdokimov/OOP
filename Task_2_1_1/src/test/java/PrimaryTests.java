import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimaryTests {

    @Test
    public void noParallelTestFalse() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        System.out.println(PrimeSearcher.Searcher(arr));
    }

    @Test
    public void noParallelTestTrue() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(8);
        arr.add(5);
        System.out.println(PrimeSearcher.Searcher(arr));
    }

    @Test
    public void noParallelTestBig() {
        Integer[] brr = {6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039, 6997901, 6997927, 6997937, 6997967, 6998009,
            6998029, 6998039};
        List<Integer> arr = new ArrayList<>(List.of(brr));
        long date1 = System.currentTimeMillis();
        System.out.println(PrimeSearcher.Searcher(arr));
        long date2 = System.currentTimeMillis();
        System.out.println(date2 - date1);
    }

}
