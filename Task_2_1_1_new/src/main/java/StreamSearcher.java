import java.util.List;

public class StreamSearcher {

    public static boolean Searcher(List<Integer> arr){
        return arr.stream().parallel().anyMatch(StreamSearcher::checker);
    }

    private static boolean checker(Object i) {
        for (int j = 2; j <(Integer) i; j++) {
            if ((int)i % j == 0) {
                return true;
            }
        }
        return false;
    }
}