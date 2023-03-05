package info.pragmaticdeveloper.dsa.array;

/*
 *Re-arrange its elements in such a way that the negative elements
 * appear at one side and positive elements appear at the other
 * Sample Input arr = {10, -1, 20, 4, 5, -9, -6}
 * Sample Output arr = {-1, -9, -6, 10, 20, 4, 5}
 * Order of the numbers doesn’t matter.
 * {-1, -9, -6, 10, 20, 4, 5} = {-9, -1, -6, 10, 4, 20, 5}
 */
public class GroupRearrange {
    public int[] arrange(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    swap(i, j, arr);
                }
                j++;
            }
        }
        return arr;
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
