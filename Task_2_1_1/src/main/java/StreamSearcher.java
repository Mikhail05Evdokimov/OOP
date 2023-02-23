import java.util.List;
import static java.lang.Math.sqrt;

public class StreamSearcher {

    public StreamSearcher(List<Integer> arr){
        boolean result = arr.stream().parallel().anyMatch(this::checker);
        System.out.println(result);
    }

    private boolean checker(Object i) {
        for (int j = 2; j <= sqrt((Integer) i); j++) {
                if ((int)i % j == 0) {
                    return true;
                }
            }
        return false;
    }


}
