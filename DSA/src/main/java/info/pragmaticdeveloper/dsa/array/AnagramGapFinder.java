package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class AnagramGapFinder {
    private static int NUMBER_LETTER = 26;

    public int findGapWithArray(String s1, String s2) {
        int[] s1Freq = getFrequency(s1);
        int[] s2Freq = getFrequency(s2);
        return delta(s1Freq, s2Freq);
    }

    private int delta(int[] s1Freq, int[] s2Freq) {
        int delta = 0;
        for (int i = 0; i < s1Freq.length; i++) {
            int difference = Math.abs(s1Freq[i] - s2Freq[i]);
            delta += difference;
        }
        return delta;
    }

    private int[] getFrequency(String s) {
        int[] frequency = new int[NUMBER_LETTER];
        int offSet = 'a';
        for (int i = 0; i < s.length(); i++) {
            int code = s.charAt(i) - offSet;
            frequency[code]++;
        }
        return frequency;
    }

    public int findGap(String s1, String s2) {
        Map<String, Long> s1Counting = Arrays.stream(s1.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        Map<String, Long> s2Counting = Arrays.stream(s2.split(""))
                .collect(groupingBy(Function.identity(), counting()));

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
