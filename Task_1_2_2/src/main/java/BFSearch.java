import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BFSearch<T> implements Iterator<T> {

    private final Queue<MyTree<T>> queue = new ArrayDeque<>();

    public BFSearch(MyTree<T> root) {
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !(queue.isEmpty());
    }

    @Override
    public T next() {
        MyTree<T> currentVertex = queue.remove();
        queue.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
