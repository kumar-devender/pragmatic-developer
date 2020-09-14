package info.pragmaticdeveloper;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Find smallest positive integer not present in the array
 */
public class SmallestPositiveIntegerFinder {
    public int getSmallestPositiveInteger(int[] array) {
        Set<Integer> set = IntStream.of(array)
                .collect(TreeSet::new, Set::add, Set::addAll);
        int i;
        for (i = 1; i <= array.length; i++) {
            if (set.add(i)) {
                return i;
            }
        }
        return i;
    }
}
