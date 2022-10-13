import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my stack project.
 */
public class StackTests {

    /**
     * unit test with push integer.
     */
    @Test
    public void pushTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        stack.push(1);
        MyStack<Integer> arr = new MyStack<>();
        arr.createStack();
        arr.push(1);
        Assertions.assertEquals(arr, stack);
    }

    /**
     * unit test with count().
     */
    @Test
    public void countTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        stack.push(1);
        Integer a = stack.count();
        Assertions.assertEquals(a, 1);
    }

    /**
     * unit test with push_stack(Integers).
     */
    @Test
    public void pushStackTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        Integer[] arr = {1, 2, 3};
        stack.pushStack(arr);
        arr1.push(1);
        arr1.push(2);
        arr1.push(3);
        Assertions.assertEquals(stack, arr1);
    }

    /**
     * unit test with pop integer.
     */
    @Test
    public void popTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        stack.push(1);
        arr1.push(1);
        arr1.push(2);
        stack.push(3);
        stack.pop();
        arr1.pop();
        Assertions.assertEquals(stack, arr1);
    }

    /**
     * unit test with popStack(Integers).
     */
    @Test
    public void popStackTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        Integer[] arr = {1, 2, 3};
        stack.pushStack(arr);
        arr1.push(1);
        stack.popStack(2);
        Assertions.assertEquals(stack, arr1);
    }

    /**
     * pop return test.
     */
    @Test
    public void popReturnTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        stack.push(1);
        stack.push(1);
        Integer a = stack.pop();
        arr1.push(a);
        Assertions.assertEquals(stack, arr1);
    }

    /**
     *  test with empty stack and extra pop.
     */
    @Test
    public void emptyTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        stack.push(1);
        arr1.push(1);
        stack.pop();
        stack.pop();
        arr1.pop();
        Assertions.assertEquals(stack, arr1);
    }

    /**
     * test with string stack.
     */
    @Test
    public void stringTest() {
        MyStack<String> stack = new MyStack<>();
        stack.createStack();
        MyStack<String> arr1 = new MyStack<>();
        arr1.createStack();
        stack.push("one");
        arr1.push("one");
        stack.push("two");
        arr1.push("two");
        stack.push("three");
        arr1.push("four");
        stack.pop();
        arr1.pop();
        Assertions.assertEquals(stack, arr1);
    }

    /**
     *  overflow test.
     */
    @Test
    public void overflowTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.createStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.createStack();
        for (int i = 0; i < 16; i++) {
            stack.push(i);
            arr1.push(i);
        }
        stack.push(44);
        arr1.push(44);
        stack.pop();
        arr1.pop();
        Assertions.assertEquals(stack, arr1);
    }
}