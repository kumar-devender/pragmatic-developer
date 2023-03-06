package info.pragmaticdeveloper.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 7, 4};
        for (int i = 0; i < arr.length; i++) {
            /** after pass(arr.length - i - 1) is already sorted
             * If for a particular iteration, no swapping took place,
             * it means the array has been sorted and we can jump out of the for loop,
             * instead of executing all the iterations.
             * This happened in case last few elements are not sorted.
             * Those element will be sorted after first few pass and we don't need more iteration after that.
             */
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
                System.out.println("      Inner pass Array " + Arrays.toString(arr));
            }
            if (isSorted) {
                break;
            }
            System.out.println("Pass " + (i) + "  Array " + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
