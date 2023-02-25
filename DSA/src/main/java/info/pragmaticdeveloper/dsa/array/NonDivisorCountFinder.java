package info.pragmaticdeveloper.dsa.array;

import java.util.stream.IntStream;

public class NonDivisorCountFinder {
    public int[] getNonDivisorCount(int[] arr) {
        int maxElement = IntStream.of(arr).max().getAsInt();
        int[] counts = new int[maxElement + 1];
        for (int k : arr) {
            counts[k]++;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int divisorCount = 0;
            for (int j = 1; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    divisorCount += counts[j];
                    if (arr[i] / j != j) {
                        divisorCount += counts[arr[i] / j];
                    }
                }
            }
            result[i] = arr.length - divisorCount;
        }
        return result;
    }
}
