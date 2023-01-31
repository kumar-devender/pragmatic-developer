package info.pragmaticdeveloper.dsa.recursion;

import java.util.HashMap;
import java.util.Map;

public class CanFormNumber {
    boolean canFormNumber(int targetSum, int[] arr) {
        final Map<Integer, Boolean> memo = new HashMap<>();
        return canFormNumber(targetSum, arr, memo);
    }

    private boolean canFormNumber(int targetSum, int[] arr, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : arr) {
            int remainder = targetSum - num;
            if (canFormNumber(remainder, arr, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}
