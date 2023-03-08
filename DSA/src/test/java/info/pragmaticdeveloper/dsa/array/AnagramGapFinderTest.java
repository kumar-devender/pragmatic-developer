package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class AnagramGapFinderTest {

    @ParameterizedTest
    @CsvSource({"hello,billion,6",
            "glue,legs,2",
            "candy,day,2"})
    void getAnagramDiff(String s1, String s2, int expected) {
        var result = new AnagramGapFinder().findGap(s1, s2);
        assertThat(result, is(expected));
    }
}