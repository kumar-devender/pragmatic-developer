package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;

class ReverseNumberTest {
    private ReverseNumber reverseNumber;

    @BeforeEach
    public void setUp() {
        reverseNumber = new ReverseNumber();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void reverseNumber(int input, int expected) {
        int actual = reverseNumber.reverseNumber(input);
        MatcherAssert.assertThat(actual, is(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(43664, 46634),
                Arguments.of(76565, 56567),
                Arguments.of(90867, 76809),
                Arguments.of(1232, 2321),
                Arguments.of(10, 1)
        );
    }
}