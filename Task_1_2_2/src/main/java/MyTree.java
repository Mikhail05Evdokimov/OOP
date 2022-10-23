import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * My realisation of generic tree container with BFS and DFS iterators.
 *
 * @param <T> - generic type for my tree.
 */
public class MyTree<T> implements Iterable<T> {
    private T value;
    private MyTree<T> parent;
    public MyTree<T> root;
    private List<MyTree<T>> children;
    private int modificationCounter;

    @Override
    public Iterator<T> iterator() {
        return new BreadthFirstSearch<>(this);
    }

    /**
     * Initialisation of a tree as a root and it's children.
     *
     * @param val - value of the root.
     */
    public void createTree(T val) {
        root = this;
        this.parent = null;
        this.value = val;
        this.children = new ArrayList<>();
        modificationCounter = 0;
    }

    /**
     * Function that return the modificationCounter of current tree.
     * It is needed to catch errors with changing of the tree during iteration out of Iterator.
     *
     * @return modificationCounter - value of the counter.
     */
    public int getModificationCounter() {
        return root.modificationCounter;
    }

    /**
     * Function that changes the parent of current vertex.
     *
     * @param newParent - parent to set.
     */
    public void changeParent(MyTree<T> newParent) {
        this.parent = newParent;
    }

    /**
     * Function that returns the value of current vertex.
     *
     * @return value - the value of vertex
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Function that returns the list of children of current vertex.
     *
     * @return the list of children
     */
    public List<MyTree<T>> getChildren() {
        return this.children;
    }

    /**
     * Function that set the value of current vertex.
     *
     * @param val new value for current vertex.
     */
    public void setValue(T val) {
        this.value = val;
    }

    /**
     * Function that add a new vertex to list of children of current vertex.
     *
     * @param childVal - value of a new vertex to add.
     */
    public MyTree<T> add(T childVal) {
        root.modificationCounter++;
        MyTree<T> newSon = new MyTree<>();
        newSon.parent = this;
        newSon.value = childVal;
        newSon.children = new ArrayList<>();
        this.children.add(newSon);
        return newSon;
    }

    /**
     * Function that delete current vertex.
     * It's children will be added to parent's list of children.
     *
     * @param vertex - vertex to delete.
     * @return delValue - value of deleted vertex.
     */
    public T remove(MyTree<T> vertex) {
        root.modificationCounter++;
        if (vertex.parent == null) {
            return null;
        }
        for (MyTree<T> i : vertex.children) {
            i.changeParent(vertex.parent);
            vertex.parent.add(i.value);
        }
        vertex.children = null;
        vertex.parent = null;
        T delValue = vertex.value;
        vertex.value = null;
        return delValue;
    }

    /**
     * remove function with another way of using.
     * "vertexToDel.remove()" instead of "remove(vertexToDel)".
     *
     * @return - returns the value of removed vertex.
     */
    public T remove() {
        root.modificationCounter++;
        if (this.parent == null) {
            return null;
        }
        for (MyTree<T> i : this.children) {
            i.changeParent(this.parent);
            this.parent.add(i.value);
        }
        this.children = null;
        this.parent = null;
        T delValue = this.value;
        this.value = null;
        return delValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyTree<?> obj = (MyTree<?>) o;
        return Objects.equals(value, obj.value)
            && Objects.equals(children, obj.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }
}