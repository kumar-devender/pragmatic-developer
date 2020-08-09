package info.pragmaticdeveloper;

import java.util.Objects;

public class RewardPoints {
    private int value;

    public RewardPoints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RewardPoints)) return false;
        RewardPoints that = (RewardPoints) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
