package ru.nsu.mevdokimov1;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Arrays;

/**
 * Class with tests for my project.
 */
public class tests {

    /**
     *Test number one with common list of numbers.
     */
    @Test
    public void firstTest()
    {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int[] arr1 = {5, 4, 6, 1, 2, 3};
            heapsort ob = new heapsort();
            ob.sort(arr1);
            for (int i = 0; i < 6; i++)
                assert arr[i] == arr1[i];
    }

    /**
     *Test number two with sorted list of numbers.
     */
    @Test
    public void secondTest()
    {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        heapsort ob = new heapsort();
        ob.sort(arr1);
        for (int i = 0; i < 6; i++)
            assert arr[i] == arr1[i];
    }

    /**
     *Test number three with one element.
     */
    @Test
    public void thirdTest()
    {
        int[] arr1 = {1};
        heapsort ob = new heapsort();
        ob.sort(arr1);
        assert arr1[0] == 1;
    }
    /**
     *Test number four with random elements.
     */
    @Test
    public void fourthTest()
    {
        int[] arr1;
        arr1 = new int [6];
        int[] arr;
        arr = new int [6];
        final Random random = new Random();
        for(int i = 0; i < 6; i++){
            arr1[i] = random.nextInt();
            arr[i] = arr1[i];
        }
        Arrays.sort(arr);
        heapsort ob = new heapsort();
        ob.sort(arr1);
        for (int i = 0; i < 6; i++)
            assert arr[i] == arr1[i];
    }
}
