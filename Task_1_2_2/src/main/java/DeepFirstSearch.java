import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Deep First Search iterator for my tree.
 * I use my own stack from the previous project here just for fun.
 *
 * @param <T> - generic type of elements from tree.
 */
public class DeepFirstSearch<T> implements Iterator<T> {
    private final int modCounter;
    MyStack<MyTree<T>> stack = new MyStack<>();

    /**
     * Constructor for DFS iterator.
     * @param root - the root of the current tree.
     */
    public DeepFirstSearch(MyTree<T> root) {
        modCounter = root.getModificationCounter();
        stack.createStack();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return stack.count() != 0;
    }

    @Override
    public T next() {
        MyTree<T> currentVertex = stack.pop();
        if (modCounter != currentVertex.getModificationCounter()) {
            throw new ConcurrentModificationException();
        }
        for (MyTree<T> i : currentVertex.getChildren()) {
            stack.push(i);
        }
        return currentVertex.getValue();
    }
}