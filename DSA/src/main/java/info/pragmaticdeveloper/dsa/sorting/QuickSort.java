package info.pragmaticdeveloper.dsa.sorting;

/**
 * Basic Idea:
 * 1 Pick pivot element
 * 2 Arrange array element using pivot element such that element smaller than pivot are on left of pivot
 * and element greater than pivot are on right of pivot by swapping elements greater than pivot and smaller than pivot
 * After every iteration pivot will be in its final position
 * 3 Base case reaches when left and right index of array crosses each other i.e (left >= right)
 */
//https://www.youtube.com/watch?v=SLauY6PpjW4&ab_channel=HackerRank
public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[(left + right) / 2];
        int partitionPoint = partition(arr, left, right, pivot);
        quickSort(arr, left, partitionPoint - 1);
        quickSort(arr, partitionPoint, right);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
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
