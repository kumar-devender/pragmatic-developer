package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MaxCountersTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 4, 6, 1, 4, 4}, 5, new int[]{3, 2, 2, 4, 2}),
                Arguments.of(new int[]{2, 1, 2}, 3, new int[]{1, 2, 0}),
                Arguments.of(new int[]{2, 1, 2, 2, 1, 2}, 3, new int[]{2, 4, 0}),
                Arguments.of(new int[]{2, 1, 3, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{2, 1, 3, 2, 3, 1, 2}, 2, new int[]{3, 3}),
                Arguments.of(new int[]{2, 1, 2}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMaxCounter(int[] input, int counter, int[] expected) {
        MaxCounters maxCounters = new MaxCounters();
        var result = maxCounters.maxCount(counter, input);
        assertThat(result, equalTo(expected));
    }
}
