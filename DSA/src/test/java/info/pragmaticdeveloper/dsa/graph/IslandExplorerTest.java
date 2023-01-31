package info.pragmaticdeveloper.dsa.graph;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class IslandExplorerTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'W', 'L', 'W', 'W', 'W'},
                        {'W', 'L', 'W', 'W', 'W'},
                        {'W', 'W', 'W', 'L', 'W'},
                        {'W', 'W', 'L', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'L', 'L', 'W', 'W', 'W'}
                }, 3),
                Arguments.of(new char[][]{
                        {'L', 'W', 'W', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'W', 'L', 'W', 'L', 'W'},
                        {'W', 'W', 'W', 'W', 'W'},
                        {'W', 'W', 'L', 'L', 'L'}
                }, 4)
        );
    }

    private static Stream<Arguments> minSizeIslandDataProvider() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'W', 'L', 'W', 'W', 'W'},
                        {'W', 'L', 'W', 'W', 'W'},
                        {'W', 'W', 'W', 'L', 'W'},
                        {'W', 'W', 'L', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'L', 'L', 'W', 'W', 'W'}
                }, 2),
                Arguments.of(new char[][]{
                        {'L', 'W', 'W', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'W', 'L', 'W', 'L', 'W'},
                        {'W', 'W', 'W', 'W', 'W'},
                        {'W', 'W', 'L', 'L', 'L'}
                }, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void countIsland(char[][] grid, int expected) {
        IslandExplorer islandExplorer = new IslandExplorer();
        int result = islandExplorer.islandCount(grid);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("minSizeIslandDataProvider")
    void minSizeIsland(char[][] grid, int expected) {
        IslandExplorer islandExplorer = new IslandExplorer();
        int result = islandExplorer.minIslandSize(grid);
        assertThat(result, equalTo(expected));
    }
}
