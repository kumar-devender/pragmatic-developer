package info.pragmaticdeveloper.dsa.array;

public class MaximalSliceFinder {
    public int findMaxSlicePrefixSumBruteforce(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] prefixSum = prefixSum(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    public int findMaxSlice(int[] arr) {
        int maxEnding = 0, maxSlice = 0;
        for (int a : arr) {
            maxEnding = Math.max(0, maxEnding + a);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }

    public int findMaxSliceBruteforce(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    private int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        return prefixSum;
    }
}
