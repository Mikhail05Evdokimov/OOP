import java.util.List;

/**
 * Class for checking an integers array for not-prime number.
 * Here I use parallel stream for parallel calculations.
 */
public class StreamSearcher {

    /**
     * Class constructor.
     *
     * @param arr - input array.
     * @return true if there is a not-prime number, false otherwise.
     */
    public static boolean Searcher(List<Integer> arr){
        return arr.stream().parallel().anyMatch(StreamSearcher::checker);
    }

    /**
     * Method which checks a number for prime.
     *
     * @param i - number to check.
     * @return - false if number is prime, true otherwise.
     */
    private static boolean checker(Object i) {
        for (int j = 2; j <(Integer) i; j++) {
            if ((int)i % j == 0) {
                return true;
            }
        }
        return false;
    }
}