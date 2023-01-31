package info.pragmaticdeveloper;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public int maxMove(int row, int column) {
        final Map<String, Integer> memo = new HashMap<>();
        return maxPossibleWayToReachTarget(row, column, memo);
    }

    private int maxPossibleWayToReachTarget(int row, int column, Map<String, Integer> memo) {
        String key = String.format("%d_%d", row, column);
        String reverseKey = String.format("%d_%d", column, row);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (memo.containsKey(reverseKey)) {
            return memo.get(reverseKey);
        }
        if (row == 1 && column == 1) {
            return 1;
        }
        if (row == 0 || column == 0) {
            return 0;
        }
        int result = maxPossibleWayToReachTarget(row - 1, column, memo) +
                maxPossibleWayToReachTarget(row, column - 1, memo);
        memo.put(key, result);
        return result;
    }
}
