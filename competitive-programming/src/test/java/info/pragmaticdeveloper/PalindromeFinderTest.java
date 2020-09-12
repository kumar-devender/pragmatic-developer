package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PalindromeFinderTest {
    private PalindromeFinder palindromeFinder;

    @BeforeEach
    public void setUp() {
        palindromeFinder = new PalindromeFinder();

    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void isPalindrome(int input, boolean expected) {
        boolean actual = palindromeFinder.isPalindrome(input);
        MatcherAssert.assertThat(actual, Is.is(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(313, true),
                Arguments.of(111111, true),
                Arguments.of(543533, false)
        );
    }
}