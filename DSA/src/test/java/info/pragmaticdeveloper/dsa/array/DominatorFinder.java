package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class DominatorFinder {
    int findDominator(int[] arr) {
        if (arr.length < 1) {
            return -1;
        }
        var maxFeq = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        if (maxFeq.getValue() > arr.length / 2) {
            for (int i = 0; i < arr.length; i++) {
                if (maxFeq.getKey() == arr[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
