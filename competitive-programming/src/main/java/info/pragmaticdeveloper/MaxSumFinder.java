package info.pragmaticdeveloper;

public class MaxSumFinder {
    public int findMaxSum(int arr[], int count) {
        if (arr.length < count) {
            return -1;
        }
        int maxSum = 0;
        int maxSumIndexes[] = new int[count];
        for (int i = 0; i <= arr.length - count; i++) {
            int sum = 0;
            for (int j = i; j < i + count; j++) {
                sum += arr[j];
            }

            if (sum > maxSum) {
                maxSum = sum;
                for (int j = 0; j < count; j++) {
                    maxSumIndexes[j] = i + j;
                }
            }
        }
        return maxSum;
    }
}
