import java.util.Iterator;
public class DFSearch<T> implements Iterator<T> {

    MyStack<MyTree<T>> stack = new MyStack<>();

    public DFSearch(MyTree<T> root) {
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