package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

class RemoveDuplicateElementFromArrayUsingSetTest {
    private RemoveDuplicateElementFromArrayUsingSet removeDuplicateElement;

    @BeforeEach
    void setUp() {
        removeDuplicateElement = new RemoveDuplicateElementFromArrayUsingSet();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testRemoveDuplicateElement(int input[], int expected[]) {
        Integer[] actual = removeDuplicateElement.removeDuplicate(input);
        MatcherAssert.assertThat(actual, is(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 2, 2, 2}, new int[]{2}),
                Arguments.of(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5}, new int[]{1, 2, 3, 4, 5})
        );
    }
}