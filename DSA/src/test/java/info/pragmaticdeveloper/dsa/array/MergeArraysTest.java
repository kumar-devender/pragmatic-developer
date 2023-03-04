package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MergeArraysTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 5}, new int[]{2, 6, 7, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new int[]{1, 3, 3, 4, 4, 5}, new int[]{3, 5, 6, 7, 8}, new int[]{1, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMergeArrays(int[] arr1, int[] arr2, int[] expected) {
        var result = new MergeArrays().mergeArrays(arr1, arr2);
        assertThat(result, equalTo(expected));
    }
}