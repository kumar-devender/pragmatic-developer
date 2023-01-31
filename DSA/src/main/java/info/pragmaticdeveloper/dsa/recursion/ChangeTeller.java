package info.pragmaticdeveloper.dsa.recursion;

import java.util.HashMap;
import java.util.Map;

public class ChangeTeller {
    public int waysToMakeChange(int targetSum, int arr[]) {
        return waysToMakeChange(targetSum, arr, new HashMap<>());
    }

    private int waysToMakeChange(int targetSum, int arr[], Map<Integer, Integer> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return 1;
        }

        if (targetSum < 0) {
            return 0;
        }

        int ways = 0;

        for (int denomination : arr) {
            int remaining = targetSum - denomination;
            ways += waysToMakeChange(remaining, arr, memo);
        }
        memo.put(targetSum, ways);
        return ways;
    }
}
