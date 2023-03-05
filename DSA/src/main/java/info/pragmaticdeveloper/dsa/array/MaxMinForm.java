package info.pragmaticdeveloper.dsa.array;

public class MaxMinForm {
    public int[] arrangeUsingTempArray(int[] arr) {
        int[] result = new int[arr.length];
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int resultIndex = 0;
        while (minIndex < maxIndex) {
            result[resultIndex++] = arr[maxIndex--];
            result[resultIndex++] = arr[minIndex++];
        }
        //copy odd pos element
        if (arr.length % 2 != 0) {
            result[resultIndex] = arr[minIndex];
        }
        System.arraycopy(result, 0, arr, 0, result.length);
        return arr;
    }
}
