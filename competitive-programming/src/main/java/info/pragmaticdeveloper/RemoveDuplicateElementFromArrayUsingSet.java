package info.pragmaticdeveloper;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RemoveDuplicateElementFromArrayUsingSet {
    public Integer[] removeDuplicate(int[] arr) {
        Set<Integer> filterElement = IntStream.of(arr)
                .boxed()
                .collect(LinkedHashSet::new, Set::add, Set::addAll);
        Integer nonDuplicate[] = new Integer[filterElement.size()];
        filterElement.toArray(nonDuplicate);
        return nonDuplicate;
    }
}
