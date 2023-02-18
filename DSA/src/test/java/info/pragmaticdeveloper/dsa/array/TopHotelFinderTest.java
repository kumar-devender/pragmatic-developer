package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class TopHotelFinderTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 1, 2},
                        new String[]{"This hotel has a nice view of the city center. The location is perfect.",
                                "The breakfast is ok. Regarding location, it is quite far from city center but price is cheap so it is worth.",
                                "Location is excellent, 5 minutes from city center. There is also a metro station very close to the hotel",
                                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from city center"},
                        "breakfast beach city center location metro view staff price",
                        "not",
                        2, new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testFindTopRatedHotel(int[] hotel, String[] review, String positiveKeywords,
                               String negativeKeywords, int top, int[] expected) {
        var result = new TopHotelFinder().find(hotel, review, positiveKeywords, negativeKeywords, top);
        assertThat(result, equalTo(expected));
    }
}