package info.pragmaticdeveloper.dsa.recursion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TowerOfHanoiTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(3, new char[]{'A', 'B', 'C'}),
                Arguments.of(2, new char[]{'A', 'B', 'C'}),
                Arguments.of(4, new char[]{'A', 'B', 'C'})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMoveDisk(int totalDisc, char[] towers) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.moveDisk(totalDisc, towers[0], towers[1], towers[2]);
    }
}
