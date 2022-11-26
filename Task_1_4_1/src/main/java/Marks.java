import java.util.HashMap;
import java.util.Map;

/**
 * Class Marks, which stores student's marks
 * as Map (Subject name, Mark).
 */
public class Marks {
    public final Map<String, Integer> marks;

    public Marks() {
        this.marks = new HashMap<>();
    }
}
