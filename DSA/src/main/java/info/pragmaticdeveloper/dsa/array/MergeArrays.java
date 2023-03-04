package info.pragmaticdeveloper.dsa.array;

public class MergeArrays {
    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int a1 = 0;
        int a2 = 0;
        int resultIndex = 0;
        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] <= arr2[a2]) {
                result[resultIndex++] = arr1[a1++];
            } else {
                result[resultIndex++] = arr2[a2++];
            }
        }

        while (a1 < arr1.length) {
            result[resultIndex++] = arr1[a1++];
        }

        while (a2 < arr2.length) {
            result[resultIndex++] = arr2[a2++];
        }
        return result;
    }
}
