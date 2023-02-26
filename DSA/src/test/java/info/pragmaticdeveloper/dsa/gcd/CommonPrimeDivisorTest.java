package info.pragmaticdeveloper.dsa.gcd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class CommonPrimeDivisorTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{15, 10, 3}, new int[]{75, 30, 5}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getCommonPrimeDivisor(int[] a, int[] b, int expected) {
        var result = new CommonPrimeDivisor().getCommonPrimeDivisor(a, b);
        assertThat(result, is(expected));
    }
}