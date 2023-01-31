package info.pragmaticdeveloper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutationsGenerator {
    public List<String> generate(String input) {
        return doGenerate(input);
    }

    private List<String> doGenerate(String input) {
        List<String> permutations = new ArrayList<>();
        permutations.add(String.valueOf(input.charAt(0)));
        char[] charArray = input.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            permutations = insertCharToEachItem(charArray[i], permutations);
        }
        return permutations;
    }

    private List<String> insertCharToEachItem(char c, List<String> items) {
        int length = items.get(0).length();
        return items.stream()
                .map(item -> generatePermutations(c, length, item))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> generatePermutations(char c, int length, String item) {
        List<String> newItem = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            newItem.add(insertChar(item, i, c));
        }
        return newItem;
    }

    private String insertChar(String item, int position, char c) {
        return new StringBuilder(item).insert(position, c).toString();
    }
}
