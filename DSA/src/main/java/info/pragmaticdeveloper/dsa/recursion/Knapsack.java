package info.pragmaticdeveloper.dsa.recursion;

import java.util.Map;
import java.util.stream.Collectors;

public class Knapsack {
    int knapsackValue(Map<Integer, Integer> knapsack, int limit) {
        return 0;
    }

    private void countFrequency() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> charFrequency = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));

    }
}
