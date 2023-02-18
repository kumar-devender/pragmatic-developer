package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class DiskIntersectionCounterTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMaxIntersection(int[] input, int expected) {
        DiskIntersectionCounter intersectionCounter = new DiskIntersectionCounter();
        var result = intersectionCounter.getMaxIntersectionBruteForce(input);
        assertThat(result, equalTo(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 1, 4, 0}, 11)
        );
    }
}