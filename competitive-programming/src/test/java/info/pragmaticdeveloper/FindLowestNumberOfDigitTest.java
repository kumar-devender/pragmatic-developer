package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

class FindLowestNumberOfDigitTest {
    private FindLowestNumberOfDigit lowestNumberOfDigit;

    @BeforeEach
    public void setUp() {
        lowestNumberOfDigit = new FindLowestNumberOfDigit();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void findLowestNumber(int input, int expected) {
        int actual = lowestNumberOfDigit.findLowestNumber(input);
        MatcherAssert.assertThat(actual, is(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(500, 100),
                Arguments.of(10, 10),
                Arguments.of(9, 0),
                Arguments.of(440, 100),
                Arguments.of(1000, 1000),
                Arguments.of(1001, 1000),
                Arguments.of(547901, 100000)
        );
    }
}