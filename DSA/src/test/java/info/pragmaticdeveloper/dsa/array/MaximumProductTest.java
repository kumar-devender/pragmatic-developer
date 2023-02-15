package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


class MaximumProductTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60),
                Arguments.of(new int[]{-5, 5, -5, 4}, 125));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void maxThreeProduct(int[] arr, int expected) {
        MaximumProduct maximumProduct = new MaximumProduct();
        var result = maximumProduct.maxThreeProduct(arr);
        assertThat(result, equalTo(expected));
    }
}