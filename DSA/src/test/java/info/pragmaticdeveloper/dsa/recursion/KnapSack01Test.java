package info.pragmaticdeveloper.dsa.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class KnapSack01Test {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getKnapSack(int[] weight, int[] value, int capacity, int expected) {
        KnapSack01 knapSack01 = new KnapSack01();
        int result = knapSack01.getKnapSack(weight, value, capacity);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 8, 7, 4}, new int[]{20, 5, 10, 40, 15, 25}, 10, 60),
                Arguments.of(new int[]{3, 3, 5, 6}, new int[]{1, 4, 8, 5}, 10, 12),
                Arguments.of(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50, 220),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, new int[]{2, 2, 4, 5, 3}, 7, 10)
        );
    }
}