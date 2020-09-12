package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

class MaxSumFinderTest {
    private MaxSumFinder maxSumFinder;

    @BeforeEach
    public void setUp() {
        maxSumFinder = new MaxSumFinder();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findMaxSum(int inputArray[], int count, int expected) {
        int result = maxSumFinder.findMaxSum(inputArray, count);
        MatcherAssert.assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 2, 3, 5}, 10, -1),
                Arguments.of(new int[]{3, 4, 5, 2, 3, 5}, 3, 12),
                Arguments.of(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4, 39),
                Arguments.of(new int[]{3, 4, 5, 2, 3, 15}, 3, 20),
                Arguments.of(new int[]{3, 4, 5, 5, 2, 5}, 3, 14)
        );
    }
}