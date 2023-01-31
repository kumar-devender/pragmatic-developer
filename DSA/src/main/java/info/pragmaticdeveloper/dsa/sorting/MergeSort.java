package info.pragmaticdeveloper.dsa.sorting;

/**
 * for an array of size 8 sortSort will be called 3 times(log n)
 * for an array of size 8 merge will compare 8 elements(n)
 * Since merge is called within sortSort so total time complexity is  O(n log n)
 */
public class MergeSort {
    public void sortSort(int[] arr, int low, int high) {
        // for an array of size 8 this block will be called 3 times
        if (low < high) {
            int mid = (low + high) / 2;
            sortSort(arr, low, mid);
            sortSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    //https://www.youtube.com/watch?v=IJDJ0kBx2LM
    private void merge(int[] data, int start, int mid, int end) {
        // for an array of size 8 merge will compare 8 elements
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (i = 0; i < temp.length; i++) {
            data[i + start] = temp[i];
        }
//        for (i = start; i <= end; i++) {
//            data[i] = temp[i - start];
//        }
    }
}
