package info.pragmaticdeveloper.dsa.sorting;

//https://www.youtube.com/watch?v=SLauY6PpjW4&ab_channel=HackerRank
public class QuickSort {

    void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (pivot > arr[left]) {
                left++;
            }
            while (pivot < arr[right]) {
                right++;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;

            }
        }
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
