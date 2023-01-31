package info.pragmaticdeveloper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class AnagramCheckerTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void checkByFrequency(String s1, String s2, boolean expected) {
        AnagramChecker anagramChecker = new AnagramChecker();
        boolean result = anagramChecker.checkByFrequency(s1, s2);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void checkBySort(String s1, String s2, boolean expected) {
        AnagramChecker anagramChecker = new AnagramChecker();
        boolean result = anagramChecker.checkBySort(s1, s2);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
//                Arguments.of("BABA", "BBAA", true),
                Arguments.of("BABA", "BBAC", false)
        );
    }
}