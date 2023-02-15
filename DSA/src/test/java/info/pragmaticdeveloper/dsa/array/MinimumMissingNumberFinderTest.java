package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MinimumMissingNumberFinderTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{-1, -3}, 1),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{1}, 2),
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMissingNumber(int[] input, int expected) {
        MinimumMissingNumberFinder minimumMissingNumberFinder = new MinimumMissingNumberFinder();
        var result = minimumMissingNumberFinder.findingMinMissingNumber(input);
        assertThat(result, equalTo(expected));
    }
}