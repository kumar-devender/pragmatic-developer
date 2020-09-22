package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

class RelationshipsAnalyzerTest {
    private RelationshipsAnalyzer relationshipsAnalyzer;

    @BeforeEach
    void setUp() {
        relationshipsAnalyzer = new RelationshipsAnalyzer();
    }

    @ParameterizedTest
    @MethodSource("singleParentDataProvider")
    void getWithSingleParent(int arr[][], List<Integer> expected) {
        List<Integer> actual = relationshipsAnalyzer.getWithSingleParent(arr);
        MatcherAssert.assertThat(actual, containsInAnyOrder(expected.toArray(new Integer[0])));
    }

    @ParameterizedTest
    @MethodSource("zeroParentDataProvider")
    void getWithNoParent(int arr[][], List<Integer> expected) {
        List<Integer> actual = relationshipsAnalyzer.getWithZeroParent(arr);
        MatcherAssert.assertThat(actual, containsInAnyOrder(expected.toArray(new Integer[0])));
    }

    @ParameterizedTest
    @MethodSource("hasCommonAncestorDataProvider")
    void hasCommonAncestor(int arr[][], int node1, int node2, boolean expected) {
        boolean actual = relationshipsAnalyzer.hasCommonAncestor(arr, node1, node2);
        MatcherAssert.assertThat(actual, is(expected));
    }

    private static Stream<Arguments> hasCommonAncestorDataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 7, 11, true),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 3, 8, false),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 5, 8, true),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 6, 8, true),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 6, 9, true),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 1, 3, false),

                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}}, 6, 5, true)
        );
    }

    private static Stream<Arguments> singleParentDataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                        {4, 5}, {4, 8}, {4, 9}, {9, 11}}, Arrays.asList(5, 7, 8, 9, 11))
        );
    }

    private static Stream<Arguments> zeroParentDataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                        {4, 5}, {4, 8}, {4, 9}, {9, 11}}, Arrays.asList(1, 2, 4))
        );
    }
}