package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaxBlockWithPeakTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findMaxBlock(int[] arr, int expected) {
        int result = new MaxBlockWithPeak().findMaxBlock(arr);
        assertThat(result, is(expected));
    }
}