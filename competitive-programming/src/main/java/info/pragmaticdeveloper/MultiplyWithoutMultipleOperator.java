package info.pragmaticdeveloper;

import java.util.HashMap;
import java.util.Map;

public class MultiplyWithoutMultipleOperator {
    public int multiply(int num1, int num2) {
        int smaller = Math.min(num1, num2);
        int larger = Math.max(num1, num2);
        return sum(larger, smaller, new HashMap<>());
    }

    private int sum(int larger, int smaller, Map<Integer, Integer> memo) {
        if (memo.containsKey(smaller)) {
            return memo.get(smaller);
        }
        if (smaller == 0) {
            return 0;
        }

        if (smaller == 1) {
            return larger;
        }
        int left = smaller / 2;
        int right = smaller % 2 == 0 ? smaller / 2 : (smaller / 2) + 1;
        int result = sum(larger, left, memo) + sum(larger, right, memo);
        memo.put(smaller, result);
        return result;
    }
}
