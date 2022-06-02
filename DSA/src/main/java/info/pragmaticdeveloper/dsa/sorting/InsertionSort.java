package info.pragmaticdeveloper.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 7, 4};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("Pass " + (i + 1) + "  Array " + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
