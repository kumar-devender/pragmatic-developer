package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PeekPopulationYearTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new PeekPopulationYear.Person[]{
                        new PeekPopulationYear.Person(2009, 2010),
                        new PeekPopulationYear.Person(2010, 2013),
                        new PeekPopulationYear.Person(2021, 2022),
                        new PeekPopulationYear.Person(2011, 2015),
                        new PeekPopulationYear.Person(2012, 2016),
                        new PeekPopulationYear.Person(2013, 2021),
                        new PeekPopulationYear.Person(2010, 2021)
                }, 2013),
                Arguments.of(new PeekPopulationYear.Person[]{
                        new PeekPopulationYear.Person(2009, 2010),
                        new PeekPopulationYear.Person(2010, 2013)
                }, 2010)
        );
    }

    @MethodSource("testDataProvider")
    @ParameterizedTest
    void getPeekPopulationYear(PeekPopulationYear.Person[] persons, int maxPopulationYear) {
        int result = new PeekPopulationYear().getPeekPopulationYear(persons);
        assertThat(result, is(maxPopulationYear));
    }
}