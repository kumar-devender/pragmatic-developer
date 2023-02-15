package info.pragmaticdeveloper.dsa.stack;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class BracketsVerifierTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(")(", 0),
                Arguments.of("{[()()]}", 1),
                Arguments.of("([)()]", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void verify(String input, int expected) {
        BracketsVerifier bracketsVerifier = new BracketsVerifier();
        var result = bracketsVerifier.verify(input);
        assertThat(result, is(expected));
    }
}