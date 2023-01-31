package info.pragmaticdeveloper;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AnagramChecker {
    boolean checkByFrequency(String s1, String s2) {
        if (!hasSameLength(s1, s2)) {
            return false;
        }
        Map<Character, Integer> map1 = frequencyCounter(s1);
        Map<Character, Integer> map2 = frequencyCounter(s2);
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!Objects.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    boolean checkBySort(String s1, String s2) {
        if (!hasSameLength(s1, s2)) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    private boolean hasSameLength(String s1, String s2) {
        return s1.length() == s2.length();
    }

    private Map<Character, Integer> frequencyCounter(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }
}
