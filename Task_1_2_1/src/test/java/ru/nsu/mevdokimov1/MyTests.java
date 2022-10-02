package ru.nsu.mevdokimov1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Testing module for my stack project.
 */
public class MyTests {

    /**
     * first simple test with integers.
     */
    @Test
    public void IntTest() {
        MyStack<Integer> Stack = new MyStack<>();
        Stack.CreateStack();
        Stack.push(1);
        Stack.push(2);
        Integer[] arr = {3, 4};
        Stack.pushStack(arr);
        Integer a = Stack.pop();
        Assertions.assertEquals(a,4);
        a = Stack.count();
        Assertions.assertEquals(a,3);
        Integer[] arr2 = Stack.popStack(2);
        Integer[] arr3 = {2, 3};
        assertArrayEquals(arr2, arr3);
    }

    /**
     * second test with stack overflow.
     */
    @Test
    public void OverflowTest() {
        MyStack<Integer> Stack = new MyStack<>();
        Stack.CreateStack();
        Stack.push(1);
        Stack.push(2);
        Integer[] arr = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Stack.pushStack(arr);
        Integer a = Stack.pop();
        Assertions.assertEquals(a,13);
        a = Stack.count();
        Assertions.assertEquals(a,12);
        Integer[] arr2 = Stack.popStack(5);
        Integer[] arr3 = {8, 9, 10, 11, 12};
        assertArrayEquals(arr2, arr3);
    }

    /**
     * third test with empty stack.
     */
    @Test
    public void EmptyTest() {
        MyStack<Integer> Stack = new MyStack<>();
        Stack.CreateStack();
        Stack.push(1);
        Integer a = Stack.pop();
        Assertions.assertEquals(a,1);
        a = Stack.count();
        Assertions.assertEquals(a,0);
        Integer[] arr2 = Stack.popStack(3);
        Integer[] arr3 = {null, null ,null};
        assertArrayEquals(arr2, arr3);
    }

    /**
     * fourth test with string stack.
     */
    @Test
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
        String[] arr2 = Stack.popStack(2);
        String[] arr3 = {"three", "four"};
        assertArrayEquals(arr2, arr3);
    }
}