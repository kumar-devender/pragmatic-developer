package info.pragmaticdeveloper.dsa.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowToSum {
    int[] howCanFormTargetSum(int targetSum, int[] arr) {
        return howCanFormTargetSum(targetSum, arr, new HashMap<>());
    }

    private int[] howCanFormTargetSum(int targetSum, int[] arr, Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new int[0];
        }
        if (targetSum < 0) {
            return null;
        }
        for (int num : arr) {
            int remainder = targetSum - num;
            int[] partialResult = howCanFormTargetSum(remainder, arr, memo);
            if (partialResult != null) {
                int[] finalResult = Arrays.copyOf(partialResult, partialResult.length + 1);
                finalResult[partialResult.length] = num;
                memo.put(targetSum, finalResult);
                return finalResult;
            }
        }
        memo.put(targetSum, null);
        return null;
    }
}
