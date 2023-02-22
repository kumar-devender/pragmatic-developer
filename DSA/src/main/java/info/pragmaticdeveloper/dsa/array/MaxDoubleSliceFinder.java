package info.pragmaticdeveloper.dsa.array;

public class MaxDoubleSliceFinder {
    public int maximalSum(int[] arr) {
        int maxDoubleSliceSum = 0;

        if (arr.length <= 3) {
            return maxDoubleSliceSum;
        }
        int[] LR = new int[arr.length];
        int[] RL = new int[arr.length];

        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            LR[i] = sum;
        }
        sum = 0;
        for (int i = arr.length - 2; i >= 1; i--) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            RL[i] = sum;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, LR[i] + RL[i + 2]);
        }

        return maxDoubleSliceSum;
    }
}
