import java.util.Iterator;

/**
 * Deep First Search iterator for my tree.
 * I use my own stack from the previous project here just for fun.
 *
 * @param <T> - generic type of elements from tree.
 */
public class DeepFirstSearch<T> implements Iterator<T> {

    MyStack<MyTree<T>> stack = new MyStack<>();

    public DeepFirstSearch(MyTree<T> root) {
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
        for (MyTree<T> i : currentVertex.getChildren()) {
            stack.push(i);
        }
        return currentVertex.getValue();
    }
}