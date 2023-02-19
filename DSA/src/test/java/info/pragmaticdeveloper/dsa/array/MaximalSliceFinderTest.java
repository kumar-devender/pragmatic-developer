package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaximalSliceFinderTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, -7, 3, 5, -2, 4, -1}, 10),
                Arguments.of(new int[]{5, -7, 3, 5}, 8),
                Arguments.of(new int[]{5, -2, 4, -1}, 7),
                Arguments.of(new int[]{-5, -2, 15, -1}, 15),
                Arguments.of(new int[]{5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findMaxSlicePrefixSumBruteforce(int[] arr, int expected) {
        int result = new MaximalSliceFinder().findMaxSlicePrefixSumBruteforce(arr);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findMaxSliceBruteforce(int[] arr, int expected) {
        int result = new MaximalSliceFinder().findMaxSliceBruteforce(arr);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findMaxSlice(int[] arr, int expected) {
        int result = new MaximalSliceFinder().findMaxSlice(arr);
        assertThat(result, is(expected));
    }
}