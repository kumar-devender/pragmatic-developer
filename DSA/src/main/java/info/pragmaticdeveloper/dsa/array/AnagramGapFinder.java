package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramGapFinder {
    public int findGap(String s1, String s2) {
        Map<String, Long> s1Counting = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> s2Counting = Arrays.stream(s2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int charToBeRemovedFromS1OrS2 = s1Counting.entrySet()
                .stream()
                .map(entry ->
                        {
                            if (!s2Counting.containsKey(entry.getKey())) {
                                return entry.getValue();
                            }
                            return Math.abs(s2Counting.get(entry.getKey()) - entry.getValue());
                        }
                ).reduce(0L, Long::sum).intValue();

        int charsToBeRemovedFromS2 = s2Counting.entrySet()
                .stream()
                .filter(entry -> !s1Counting.containsKey(entry.getKey()))
                .map(Map.Entry::getValue)
                .reduce(0L, Long::sum).intValue();
        return charToBeRemovedFromS1OrS2 + charsToBeRemovedFromS2;
    }
}
