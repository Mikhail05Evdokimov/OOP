package ru.nsu.mevdokimov1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Class with tests for my project.
 */
public class Tests {

    /**
     *Test number one with common list of numbers.
     */

    @Test
    public void CommonTest() {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int[] arr1 = {5, 4, 6, 1, 2, 3};
            Heapsort ob = new Heapsort();
            ob.sort(arr1);
            assertArrayEquals(arr1, arr);
    }

    /**
     *Test number two with sorted list of numbers.
     */

    @Test
    public void SortedArrayTest() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        Heapsort ob = new Heapsort();
        ob.sort(arr1);
        assertArrayEquals(arr1, arr);
    }

    /**
     *Test number three with one element.
     */

    @Test
    public void OneElementTest() {
        int[] arr1 = {1};
        int[] arr = {1};
        Heapsort ob = new Heapsort();
        ob.sort(arr1);
        assertArrayEquals(arr1, arr);
    }
    /**
     *Test number four with empty list.
     */

    @Test
    public void VoidArrayTest() {
        int[] arr1 = {};
        int[] arr = {};
        Heapsort ob = new Heapsort();
        ob.sort(arr1);
        assertArrayEquals(arr1, arr);
    }
}
