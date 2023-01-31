package info.pragmaticdeveloper.dsa.recursion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RaisingNumberToPowerTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testRaisingNumberToPower(int number, int power, int expected) {
        RaisingNumberToPower raisingNumberToPower = new RaisingNumberToPower();
        int result = raisingNumberToPower.pow(number, power);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(2, 5, 32),
                Arguments.of(2, 8, 256),
                Arguments.of(2, 9, 512),
                Arguments.of(2, 10, 1024),
                Arguments.of(2, 11, 2048)
        );
    }
}
