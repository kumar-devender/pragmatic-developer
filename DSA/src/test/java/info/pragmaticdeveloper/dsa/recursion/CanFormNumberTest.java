package info.pragmaticdeveloper.dsa.recursion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CanFormNumberTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testCanForNumber(int targetSum, int[] arr, boolean expected) {
        CanFormNumber canFormNumber = new CanFormNumber();
        boolean result = canFormNumber.canFormNumber(targetSum, arr);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3}, true),
                Arguments.of(300, new int[]{7, 14}, false));
    }
}