package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class MushroomPickerUnitTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 7, 5, 1, 3, 9}, 4, 6, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void collectMaxPossible(int[] input, int currentPos, int move, int expected) {
        var mushroomPicker = new MushroomPicker();
        var result = mushroomPicker.collectMaxPossible(input, currentPos, move);
        assertThat(result, is(expected));
    }
}
