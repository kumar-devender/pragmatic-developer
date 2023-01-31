package info.pragmaticdeveloper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

    public int[] bestSum(int targetSum, int[] input) {
        final Map<Integer, int[]> memo = new HashMap<>();
        return bestSum(targetSum, input, memo);
    }

    private int[] bestSum(int targetSum, int[] input, Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new int[0];
        }

        if (targetSum < 0) {
            return null;
        }

        int[] shortestCombination = null;

        for (int item : input) {
            int remainder = targetSum - item;
            int[] remainderCombination = bestSum(remainder, input, memo);
            if (remainderCombination != null) {
                int[] current = Arrays.copyOf(remainderCombination, remainderCombination.length + 1);
                current[current.length - 1] = item;
                if (shortestCombination == null || current.length < shortestCombination.length) {
                    shortestCombination = current;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
