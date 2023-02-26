package info.pragmaticdeveloper.dsa.gcd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ChocolateTableTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(12, 2, 6),
                Arguments.of(10, 4, 5),
                Arguments.of(12, 8, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void countEatenChocolate(int n, int m, int expected) {
        var result = new ChocolateTable().countEatenChocolate(n, m);
        assertThat(result, is(expected));
    }
}