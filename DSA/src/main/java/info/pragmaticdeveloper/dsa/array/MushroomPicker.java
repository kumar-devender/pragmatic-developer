package info.pragmaticdeveloper.dsa.array;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class MushroomPicker {

    public int collectMaxPossible(int[] arr, int k, int m) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int length = arr.length;
        prefixSum.put(0, arr[0]);
        for (int i = 1; i < arr.length; i++) {
            prefixSum.put(i, arr[i] + prefixSum.get(i - 1));
        }
        int result = 0;
        for (int p = 0; p < Math.min(m, k) + 1; p++) {
            int left_pos = k - p;
            int right_pos = Math.min(length - 1, Math.max(k, k + m - 2 * p));
            result = Math.max(result, countTotal(prefixSum, left_pos, right_pos));
            System.out.println(format("p=%d, left=%d, right=%d, result=%d", p, left_pos, right_pos, result));
        }
        System.out.println();
        System.out.println();
        for (int p = 0; p < Math.min(m + 1, length - k); p++) {
            int left_pos = k + p;
            int right_pos = Math.max(0, Math.max(k, m - 2 * p));
            result = Math.max(result, countTotal(prefixSum, left_pos, right_pos));
            System.out.println(format("p=%d, left=%d, right=%d, result=%d", p, left_pos, right_pos, result));
        }
        return result;
    }

    private int countTotal(Map<Integer, Integer> prefixSum, int left, int right) {
        left = Math.max(left - 1, 0);
        return prefixSum.get(right) - prefixSum.getOrDefault(left, 0);
    }
}
