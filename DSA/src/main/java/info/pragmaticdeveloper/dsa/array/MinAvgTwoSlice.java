package info.pragmaticdeveloper.dsa.array;

public class MinAvgTwoSlice {
    public int getMinAvgTwoSlice(int[] arr) {
        float min = Integer.MAX_VALUE;
        int minPairIndex = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            float twosAvg = (float) (arr[i] + arr[i + 1]) / 2;
            float threesAvg = (float) (arr[i] + arr[i + 1] + arr[i + 2]) / 3;
            float minOfCurrentPair = Math.min(twosAvg, threesAvg);
            if (min > minOfCurrentPair) {
                min = minOfCurrentPair;
                minPairIndex = i;
            }
        }
        if (min > (float) (arr[arr.length - 1] + arr[arr.length - 2]) / 2) {
            return arr.length - 2;
        }
        return minPairIndex;
    }
}
