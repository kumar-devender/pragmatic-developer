package info.pragmaticdeveloper.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 7, 4};
        for (int i = 0; i < arr.length; i++) {
            boolean sortFinished = true;
            /** after pass(arr.length - i - 1) is already sorted
             * If for a particular iteration, no swapping took place,
             * it means the array has been sorted and we can jump out of the for loop,
             * instead of executing all the iterations.
             * This happened in case last few elements are not sorted.
             * Those element will be sorted after first few pass and we don't need more iteration after that.
             */
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sortFinished = false;
                }
                System.out.println("      Inner pass Array " + Arrays.toString(arr));
                if (sortFinished) {
                    break;
                }
            }
            System.out.println("Pass " + (i) + "  Array " + Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void bubbleSort(int[] arr) {
        boolean sorted = false;
        int unsortedLength = arr.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedLength; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
            unsortedLength--;
        }
    }
}
