package info.pragmaticdeveloper;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FibonacciSeriesIterativeTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(5, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSeries(int term, int expected) {
        FibonacciSeriesIterative fibonacciSeriesIterative = new FibonacciSeriesIterative();
        int result = fibonacciSeriesIterative.generateSeries(term);
        assertThat(result, is(expected));
    }
}