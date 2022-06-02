package info.pragmaticdeveloper.compose;

import info.pragmaticdeveloper.RewardPoints;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RewardPointsComposer {
    private final Predicate<RewardPoints> lessThan100 = rewardPoint -> rewardPoint.getValue() < 100;
    private final Predicate<RewardPoints> moreThan40 = rewardPoint -> rewardPoint.getValue() > 40;
    private final Predicate<RewardPoints> lessThan40 = rewardPoint -> rewardPoint.getValue() < 40;
    private final Predicate<RewardPoints> moreThan100 = rewardPoint -> rewardPoint.getValue() > 100;

    public List<RewardPoints> moreThan40AndLessThan100(List<RewardPoints> rewardPoints) {
        return rewardPoints.stream()
                .filter(moreThan40.and(lessThan100))
                .collect(Collectors.toList());
    }

    public List<RewardPoints> lessThan40OrMoreThan100(List<RewardPoints> rewardPoints) {
        return rewardPoints.stream()
                .filter(lessThan40.or(moreThan100))
                .collect(Collectors.toList());
    }
}
