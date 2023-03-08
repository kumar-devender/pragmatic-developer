package info.pragmaticdeveloper.dsa.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class RunningMedianFinderTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{12, 4, 5, 3, 8, 7}, new double[]{12.0d, 8.0d, 5.0d, 4.5d, 5.0d, 6.0d}),
                Arguments.of(new int[]{7, 3, 5, 2}, new double[]{7.0d, 5.0d, 5.0d, 4.0d})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getRunningMedian(int[] arr, double[] expected) {
        var result = new RunningMedianFinder().getRunningMedian(arr);
        assertThat(result, equalTo(expected));
    }
}