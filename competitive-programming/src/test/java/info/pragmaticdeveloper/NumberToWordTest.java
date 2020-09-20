package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
     * @param input e.g:-
     *              13 : thirteen
     *              20 : twenty
     *              21 : twenty one
     *              33 : thirty three
     *              70 : seventy
     *              91 : ninety one
     *              991 : nine hundred ninety nine
     *              9991 : nine thousand nine hundred ninety nine
     *              99991 : ninety nine thousand nine hundred ninety nine
     */

    @ParameterizedTest
    @MethodSource("dataProvider")
    void convert(int input, String expected) {
        String actual = numberToWord.convert(input);
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(13, "thirteen"),
                Arguments.of(20, "twenty "),
                Arguments.of(21, "twenty one"),
                Arguments.of(33, "thirty three"),
                Arguments.of(70, "seventy "),
                Arguments.of(91, "ninety one"),
                Arguments.of(991, "nine hundred ninety nine"),
                Arguments.of(9991, "nine thousand nine hundred ninety nine"),
                Arguments.of(99991, "ninety nine thousand nine hundred ninety nine")
        );
    }
}