package info.pragmaticdeveloper.dsa.recursion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class HowToSumTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testHowToSum(int targetSum, int[] arr, int[] expected) {
        final HowToSum howToSum = new HowToSum();
        int[] result = howToSum.howCanFormTargetSum(targetSum, arr);
        assertThat(result, equalTo(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3}, new int[]{3, 2, 2}),
                Arguments.of(300, new int[]{7, 14}, null)
        );
    }
}
