package info.pragmaticdeveloper.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {8, 2, 5, 1, 7, 4};
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("Pass " + (i + 1) + "  Array " + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
