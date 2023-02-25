package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SieveOfEratosthenesTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getPrimeUpTo(int end, int[] expected) {
        var result = new SieveOfEratosthenes().getPrimeUpTo(end);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(2, new int[]{2}),
                Arguments.of(5, new int[]{2, 3, 5}),
                Arguments.of(20, new int[]{2, 3, 5, 7, 11, 13, 17, 19})
        );
    }
}