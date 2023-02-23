import java.util.List;
import static java.lang.Math.sqrt;

public class PrimeSearcher {
    public static boolean Searcher(List<Integer> arr) {
        while (!(arr.isEmpty())) {
            int number = arr.remove(0);
            if (!(checker(number))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checker(int number) {
        //for (int i = 2; i <= sqrt(number); i++) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
