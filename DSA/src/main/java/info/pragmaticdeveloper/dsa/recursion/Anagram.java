package info.pragmaticdeveloper.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
//https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/
public class Anagram {
    public List<String> getAnagram(String input) {
        List<String> anagram = new ArrayList<>();
        generate("", input, anagram);
        return anagram;
    }

    private void generate(String candidate, String remaining, List<String> anagram) {
        if (remaining.length() == 0) {
            anagram.add(candidate);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generate(newCandidate, newRemaining, anagram);
        }
    }
}
