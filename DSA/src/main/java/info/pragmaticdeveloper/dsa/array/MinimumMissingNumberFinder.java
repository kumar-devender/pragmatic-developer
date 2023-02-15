package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumMissingNumberFinder {
    public int findingMinMissingNumber(int[] arr) {
        Set<Integer> integers = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());
        int i = 1;
        for (; i <= arr.length; i++) {
            if (!integers.contains(i)) {
                return i;
            }
        }
        return i;
    }
}
