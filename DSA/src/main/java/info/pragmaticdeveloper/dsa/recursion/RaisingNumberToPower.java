package info.pragmaticdeveloper.dsa.recursion;

import java.util.HashMap;
import java.util.Map;

public class RaisingNumberToPower {
    int pow(int number, int pow) {
        return pow(number, pow, new HashMap<>());
    }

    private int pow(int number, int pow, Map<Integer, Integer> memo) {
        if (memo.containsKey(pow)) {
            return memo.get(pow);
        }
        if (pow == 0) {
            return 1;
        }

        if (pow == 1) {
            return number;
        }
        int left = pow / 2;
        int right = pow % 2 == 0 ? pow / 2 : (pow / 2) + 1;
        int result = pow(number, left, memo) * pow(number, right, memo);
        memo.put(pow, result);
        return result;
    }
}
