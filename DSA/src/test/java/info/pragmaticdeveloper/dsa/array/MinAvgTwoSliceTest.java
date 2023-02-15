package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


class MinAvgTwoSliceTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getMinAvgTwoSlice(int[] input, int expected) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
        int result = minAvgTwoSlice.getMinAvgTwoSlice(input);
        assertThat(result, equalTo(expected));
    }
}