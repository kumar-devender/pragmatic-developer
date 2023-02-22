package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaxDoubleSliceFinderTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void maximalSum(int[] arr, int expect) {
        var result = new MaxDoubleSliceFinder().maximalSum(arr);
        assertThat(result, is(expect));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 6, -1, 4, 5, - 1, 2}, 17)
        );
    }
}
