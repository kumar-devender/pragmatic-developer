package info.pragmaticdeveloper.collection;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;

class ObjectTypeInCollectionFinderTest {
    private ObjectTypeInCollectionFinder typeInCollectionFinder;

    @BeforeEach
    public void setUp() {
        typeInCollectionFinder = new ObjectTypeInCollectionFinder();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testGuessElementType(Collection<?> collection, Class<?> itemType, boolean isAssignable) {
        Class<?> resultType = typeInCollectionFinder.guessElementType(collection);
        MatcherAssert.assertThat(itemType.isAssignableFrom(resultType), is(isAssignable));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Integer(2)), Integer.class, true),
                Arguments.of(Arrays.asList(new Integer(2)), String.class, false)
        );
    }
}