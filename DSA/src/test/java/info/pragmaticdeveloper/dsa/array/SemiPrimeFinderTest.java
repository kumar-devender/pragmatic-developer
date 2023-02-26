package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SemiPrimeFinderTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}, new int[]{10, 4, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getSemiPrime(int n, int[] P, int[] Q, int[] expected) {
        var result = new SemiPrimeFinder().getSemiPrime(n, P, Q);
        assertThat(result, is(expected));
    }
}