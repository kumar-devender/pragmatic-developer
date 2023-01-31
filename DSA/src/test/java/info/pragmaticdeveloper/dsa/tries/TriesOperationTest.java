package info.pragmaticdeveloper.dsa.tries;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TriesOperationTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testFind(String[] names, String prefix, int expected) {
        TriesOperation triesOperation = new TriesOperation();
        triesOperation.add(names);
        int result = triesOperation.find(prefix);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
//                Arguments.of(new String[]{"hack", "hackerrank",}, "hac", 2),
//                Arguments.of(new String[]{"hack", "hackerrank",}, "hak", 0),
                Arguments.of(new String[]{"aaaaa"}, "aaa", 1)
        );
    }
}