package info.pragmaticdeveloper;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicateElementWithoutSetTest {
    private RemoveDuplicateElementWithoutSet removeDuplicate;

    @BeforeEach
    void setUp() {
        removeDuplicate = new RemoveDuplicateElementWithoutSet();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void removeDuplicate(int input[], int expected[]) {
        int[] actual = removeDuplicate.removeDuplicate(input);
        MatcherAssert.assertThat(actual, CoreMatchers.is(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 2, 2, 2}, new int[]{2}),
                Arguments.of(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5}, new int[]{1, 2, 3, 4, 5})
        );
    }
}