package info.pragmaticdeveloper.dsa.recursion;


import info.pragmaticdeveloper.dsa.sorting.MergeSort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MergeSortTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMergeSort(int[] source, int[] expected) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortSort(source, 0, source.length - 1);
        assertThat(source, equalTo(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 1, 3, 0, 5}, new int[]{0, 1, 2, 3, 5, 7}),
                Arguments.of(new int[]{38, 27, 43, 3, 9, 82, 10}, new int[]{3, 9, 10, 27, 38, 43, 82}),
                Arguments.of(new int[]{64, 21, 33, 70, 12, 85, 44, 3, 99, 0, 108, 36}, new int[]{0, 3, 12, 21, 33, 36, 44, 64, 70, 85, 99, 108})
        );
    }
}