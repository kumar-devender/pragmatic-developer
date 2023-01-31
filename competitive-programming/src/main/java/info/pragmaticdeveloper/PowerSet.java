package info.pragmaticdeveloper;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    List<List<String>> powerSet(String[] arr) {
        List<List<String>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for (String item : arr) {
            powerSet.addAll(generateNewSet(powerSet, item));
        }
        return powerSet;
    }

    private List<List<String>> generateNewSet(List<List<String>> existingAllSet, String item) {
        List<List<String>> newAllSet = new ArrayList<>();
        for (List<String> set : existingAllSet) {
            List<String> newSet = new ArrayList<>(set);
            newSet.add(item);
            newAllSet.add(newSet);
        }
        return newAllSet;
    }
}
