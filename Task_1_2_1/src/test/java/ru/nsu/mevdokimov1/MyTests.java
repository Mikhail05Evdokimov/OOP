package ru.nsu.mevdokimov1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my stack project.
 */
public class MyTests {

    /**
     * unit test with push integer.
     */
    @Test
    public void pushTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.CreateStack();
        stack.push(1);
        MyStack<Integer> arr = new MyStack<>();
        arr.CreateStack();
        arr.push(1);
        Assertions.assertEquals(arr, stack);
    }

    /**
     * unit test with count().
     */
    @Test
    public void countTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.CreateStack();
        stack.push(1);
        Integer a = stack.count();
        Assertions.assertEquals(a,1);
    }

    /**
     * unit test with push_stack(Integers).
     */
    @Test
    public void pushStackTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.CreateStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.CreateStack();
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
        stack.CreateStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.CreateStack();
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
        stack.CreateStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.CreateStack();
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
        stack.CreateStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.CreateStack();
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
        stack.CreateStack();
        MyStack<Integer> arr1 = new MyStack<>();
        arr1.CreateStack();
        stack.push(1);
        arr1.push(1);
        stack.pop();
        stack.pop();
        arr1.pop();
        Assertions.assertEquals(stack, arr1);
    }

 /*   /**
     * fourth test with string stack.
     */
 /*   @Test
    public void StringTest() {
        MyStack<String> Stack = new MyStack<>();
        Stack.CreateStack();
        Stack.push("one");
        Stack.push("two");
        String a = Stack.pop();
        Assertions.assertEquals(a,"two");
        Assertions.assertEquals(Stack.count(),1);
        String[] arr1 = {"two", "three", "four"};
        Stack.pushStack(arr1);
        Stack.popStack(2);
       /* Assertions.assertEquals(Stack.stack[0],"one");
        Assertions.assertNull(Stack.stack[3]);
        Assertions.assertNull(Stack.stack[2]);
    }
*/
}