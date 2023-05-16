import java.util.List;
import static java.lang.Math.sqrt;

/**
 * Class for checking an integers array for not-prime number.
 * No parallel actions here.
 */
public class PrimeSearcher {

    /**
     * Class constructor.
     *
     * @param arr - input array.
     * @return - true if there is a not-prime number, false otherwise.
     */
    public static boolean searcher(List<Integer> arr) {
        for (int i : arr) {
            if (!(primeNumberOrNot(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method which checks a number for prime.
     *
     * @param number - number to check.
     * @return - false if number is prime, true otherwise.
     */
    private static boolean primeNumberOrNot(int number) {
        for (int i = 2; i < sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}