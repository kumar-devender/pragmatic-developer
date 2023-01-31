package info.pragmaticdeveloper.dsa.recursion;

import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {
    public int getKnapSack(int weight[], int value[], int maxWeight) {
        return knapSack(weight, value, maxWeight, weight.length, new HashMap<>());
    }

    private int knapSack(int[] weight, int[] value, int remainingWeight, int n, Map<String, Integer> memo) {
        String key = String.format("%d_%d", remainingWeight, n);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (n == 0 || remainingWeight == 0) {
            return 0;
        }

        if (weight[n - 1] > remainingWeight) {
            int partialResult = knapSack(weight, value, remainingWeight, n - 1, memo);
            memo.put(key, partialResult);
            return partialResult;
        }

        int partialResult = Math.max(value[n - 1] + knapSack(weight, value, remainingWeight - weight[n - 1], n - 1, memo),
                knapSack(weight, value, remainingWeight, n - 1, memo));
        memo.put(key, partialResult);
        return partialResult;
    }
}
