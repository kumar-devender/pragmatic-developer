package info.pragmaticdeveloper.dsa.array;


public class MaxCounters {
    public int[] maxCount(int n, int[] input) {
        int[] counters = new int[n];
        int maxValue = 0;
        int lastMaxValue = 0;
        for (int j : input) {
            if (j <= n) {
                counters[j - 1] = Math.max(lastMaxValue, counters[j - 1]) + 1;
                maxValue = Math.max(maxValue, counters[j - 1]);
            } else {
                lastMaxValue = maxValue;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMaxValue) {
                counters[i] = lastMaxValue;
            }
        }
        return counters;
    }
}
