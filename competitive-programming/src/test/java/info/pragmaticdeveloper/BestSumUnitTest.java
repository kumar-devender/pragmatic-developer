package info.pragmaticdeveloper;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class BestSumUnitTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testBestSum(int targetSum, int[] input, int[] expected) {
        BestSum bestSum = new BestSum();
        int[] result = bestSum.bestSum(targetSum, input);
        assertThat(result, equalTo(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(100, new int[]{1, 2, 5, 25}, new int[]{25, 25, 25, 25}),
                Arguments.of(7, new int[]{5, 3, 4, 7}, new int[]{7}),
                Arguments.of(8, new int[]{2, 3, 5}, new int[]{5, 3}),
                Arguments.of(8, new int[]{1, 4, 5}, new int[]{4, 4})
        );
    }
}
