package info.pragmaticdeveloper.dsa.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class ChangeTellerTest {

    @ParameterizedTest
    @MethodSource("testDatProvider")
    void waysToMakeChange(int targetSum, int arr[], int expected) {
        ChangeTeller changeTeller = new ChangeTeller();
        int result = changeTeller.waysToMakeChange(targetSum, arr);
        assertThat(result, is(expected));
    }


    private static Stream<Arguments> testDatProvider() {
        return Stream.of(
                Arguments.of(4, new int[]{1,2,3}, 4)
        );
    }
}