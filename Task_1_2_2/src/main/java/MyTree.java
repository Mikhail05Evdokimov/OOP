import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class MyTree<T> implements Iterable<T>{
    private T value;
    private MyTree<T> parent;
    public MyTree<T> root;
    private List<MyTree<T>> children;

    @Override
    public Iterator<T> iterator() {
        return new BFSearch<>(this);
    }

    /**
     * Initialisation of a tree as a root and it's children
     *
     * @param val - value of the root
     */
    public void CreateTree(T val) {
        root = this;
        this.parent = null;
        this.value = val;
        this.children = new ArrayList<>();
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
        if(vertex.parent == null) {
            return null;
        }
        T delValue = vertex.value;
        for(MyTree<T> i: vertex.children) {
            i.changeParent(vertex.parent);
            vertex.parent.add(i.value);
        }
        vertex.value = null;
        vertex.children = null;
        vertex.parent = null;
        return delValue;
    }

    public T remove() {
        if(this.parent == null) {
            return null;
        }
        T delValue = this.value;
        for(MyTree<T> i: this.children) {
            i.changeParent(this.parent);
            this.parent.add(i.value);
        }
        this.value = null;
        this.children = null;
        this.parent = null;
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