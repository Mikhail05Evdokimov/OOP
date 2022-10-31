import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my tree with unit and random tests.
 */
public class TreeTests {

    @Test
    public void initTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void addTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree2.add(2);
        tree1.add(2);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void addTest2() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree2.add(2);
        vert1.add(3);
        tree2.add(vert2, 3);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void removeTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree2.add(2);
        tree1.add(2);
        MyTree<Integer> del1 = tree1.add(3);
        MyTree<Integer> del2 = tree2.add(4);
        Integer a = tree1.remove(del1);
        Integer b = tree2.remove(del2);
        if (!Objects.equals(a, b)) {
            Assertions.assertEquals(tree1, tree2);
        }
    }

    @Test
    public void removeTest2() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree2.add(2);
        tree1.add(2);
        MyTree<Integer> del1 = tree1.add(3);
        MyTree<Integer> del2 = tree2.add(4);
        Integer a = del1.remove();
        Integer b = del2.remove();
        if (!Objects.equals(a, b)) {
            Assertions.assertEquals(tree1, tree2);
        }
    }

    @Test
    public void getValTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        Integer a = vert1.getValue();
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree2.add(a);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void setValTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> vert1 = tree1.add(3);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree2.add(2);
        vert1.setValue(2);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void newBranchTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree2.add(2);
        vert1.add(3);
        vert2.add(3);
        MyTree<Integer> del1 = vert1.add(4);
        MyTree<Integer> del2 = vert2.add(5);
        del1.remove();
        del2.remove();
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void removeCentralVertexTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree2.add(2);
        vert1.add(3);
        vert2.add(3);
        vert1.add(4);
        vert2.add(4);
        vert1.remove();
        vert2.remove();
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void removeCentralVertexTest2() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree2.add(2);
        vert1.add(3);
        vert2.add(3);
        vert1.add(4);
        vert2.add(4);
        tree1.remove(vert1);
        tree2.remove(vert2);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void bfsTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree1.add(3);
        vert1.add(4);
        MyTree<Integer> vert3 = vert1.add(5);
        vert3.add(7);
        vert2.add(6);
        ArrayList<Integer> arr1;
        arr1 = tree1.bfsIterator(tree1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            arr2.add(i);
        }
        Assertions.assertEquals(arr1, arr2);
    }

    @Test
    public void dfsTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> vert1 = tree1.add(2);
        MyTree<Integer> vert2 = tree1.add(3);
        vert1.add(4);
        MyTree<Integer> vert3 = vert1.add(5);
        vert3.add(7);
        vert2.add(6);
        DeepFirstSearch<Integer> dfs = new DeepFirstSearch<>(tree1.root);
        ArrayList<Integer> arr1 = new ArrayList<>();
        while (dfs.hasNext()) {
            arr1.add(dfs.next());
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(3);
        arr2.add(6);
        arr2.add(2);
        arr2.add(5);
        arr2.add(7);
        arr2.add(4);
        Assertions.assertEquals(arr1, arr2);
    }

    @Test
    public void removeTheRootTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree1.add(2);
        tree2.add(2);
        tree1.remove();
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void currentModExceptionTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.createTree(8);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.createTree(1);
        tree1.add(2);
        tree2.add(3);
        tree1.add(2);
        MyTree<Integer> vert = tree2.add(3);
        tree1.remove();
        tree2.remove(vert);
        int m1 = tree1.getModificationCounter();
        int m2 = tree2.getModificationCounter();
        Assertions.assertEquals(m1, m2);
    }
}
