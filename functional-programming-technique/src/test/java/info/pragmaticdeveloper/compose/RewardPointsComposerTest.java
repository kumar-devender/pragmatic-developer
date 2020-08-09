package info.pragmaticdeveloper.compose;

import info.pragmaticdeveloper.RewardPoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class RewardPointsComposerTest {
    private RewardPointsComposer rewardPointsComposer;

    @BeforeEach
    void setUp() {
        rewardPointsComposer = new RewardPointsComposer();
    }

    @ParameterizedTest
    @MethodSource("rewardPointsProvider")
    void moreThan40AndLessThan100(List<RewardPoints> input, List<RewardPoints> expected) {
        List<RewardPoints> actual = rewardPointsComposer.moreThan40AndLessThan100(input);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @ParameterizedTest
    @MethodSource("rewardPointsProvider")
    void lessThan40OrMoreThan100(List<RewardPoints> input, List<RewardPoints> expected) {
        List<RewardPoints> actual = rewardPointsComposer.moreThan40AndLessThan100(input);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    private static Stream<Arguments> rewardPointsProvider() {
        return Stream.of(
                Arguments.of(
                        asList(new RewardPoints(10),
                                new RewardPoints(20),
                                new RewardPoints(30),
                                new RewardPoints(40),
                                new RewardPoints(50),
                                new RewardPoints(60),
                                new RewardPoints(70),
                                new RewardPoints(110)),
                        asList(new RewardPoints(50),
                                new RewardPoints(60),
                                new RewardPoints(70))
                )/*,
                Arguments.of(
                        asList(new RewardPoints(10),
                                new RewardPoints(20),
                                new RewardPoints(30),
                                new RewardPoints(40),
                                new RewardPoints(30),
                                new RewardPoints(20),
                                new RewardPoints(70),
                                new RewardPoints(110)),
                        asList(new RewardPoints(10),
                                new RewardPoints(20),
                                new RewardPoints(30),
                                new RewardPoints(20),
                                new RewardPoints(30))
                )*/
        );
    }
}