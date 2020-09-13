package info.pragmaticdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberToWordTest {
    private NumberToWord numberToWord;

    @BeforeEach
    public void setUp() {
        numberToWord = new NumberToWord();
    }

    /**
     *
     * @param input
     * e.g:-
     * 13 : thirteen
     * 20 : twenty
     * 21 : twenty one
     * 33 : thirty three
     * 70 : seventy
     * 91 : ninety one
     * 991 : nine hundred ninety nine
     * 9991 : nine thousand nine hundred ninety nine
     * 99991 : ninety nine thousand nine hundred ninety nine
     */

    @ParameterizedTest
    @MethodSource("dataProvider")
    void convert(int input) {
        System.out.println(input + " : " + numberToWord.convert(input));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(13),
                Arguments.of(20),
                Arguments.of(21),
                Arguments.of(33),
                Arguments.of(70),
                Arguments.of(91),
                Arguments.of(991),
                Arguments.of(9991),
                Arguments.of(99991)
        );
    }
}