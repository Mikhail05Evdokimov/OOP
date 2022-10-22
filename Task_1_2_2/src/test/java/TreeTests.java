import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeTests {

    @Test
    public void initTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.CreateTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.CreateTree(1);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void addTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.CreateTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.CreateTree(1);
        tree2.add(2);
        tree1.add(2);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void removeTest() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.CreateTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.CreateTree(1);
        tree2.add(2);
        tree1.add(2);
        MyTree<Integer> del1 = tree1.add(3);
        MyTree<Integer> del2 = tree2.add(4);
        Integer a = tree1.remove(del1);
        Integer b = tree2.remove(del2);
        Assertions.assertEquals(tree1, tree2);
    }

    @Test
    public void removeTest2() {
        MyTree<Integer> tree1 = new MyTree<>();
        tree1.CreateTree(1);
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.CreateTree(1);
        tree2.add(2);
        tree1.add(2);
        MyTree<Integer> del1 = tree1.add(3);
        MyTree<Integer> del2 = tree2.add(4);
        Integer a = del1.remove();
        Integer b = del2.remove();
        Assertions.assertEquals(tree1, tree2);
    }

}
