import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Queue;

/**
 * Breadth First Search iterator for my tree.
 *
 * @param <T> - type of elements in tree.
 */
public class BreadthFirstSearch<T> implements Iterator<T> {
    private final int modCounter;
    private final Queue<MyTree<T>> queue = new ArrayDeque<>();

    /**
     * Constructor for BFS iterator.
     * @param root - the root of the current tree.
     */
    public BreadthFirstSearch(MyTree<T> root) {
        modCounter = root.getModificationCounter();
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !(queue.isEmpty());
    }

    @Override
    public T next() {
        MyTree<T> currentVertex = queue.remove();
        if (modCounter != currentVertex.getModificationCounter()) {
            throw new ConcurrentModificationException();
        }
        queue.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
