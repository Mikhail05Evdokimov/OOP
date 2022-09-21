package ru.nsu.mevdokimov1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

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

   /*     {   //snd test
            int[] arr = {1, 2, 3, 4, 5, 6};
            int[] arr1 = {1, 2, 3, 4, 5, 6};
            heapsort ob = new heapsort();
            ob.sort(arr1);
            for (int i = 0; i < 6; i++)
                assert arr[i] == arr1[i];
        }
        {   //trd test
            int[] arr1 = {1};
            heapsort ob = new heapsort();
            ob.sort(arr1);
            assert arr1[0] == 1;
        }
        {   //4th test
            int[] arr = {0, 0, 0, 0, 0, 0};
            int[] arr1 = {0, 0, 0, 0, 0, 0};
            heapsort ob = new heapsort();
            ob.sort(arr1);
            for (int i = 0; i < 6; i++)
                assert arr[i] == arr1[i];
        }
    }
*/
}
