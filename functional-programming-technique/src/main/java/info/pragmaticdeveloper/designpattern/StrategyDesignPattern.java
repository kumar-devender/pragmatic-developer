package info.pragmaticdeveloper.designpattern;

import java.util.List;
import java.util.function.Predicate;

public class StrategyDesignPattern {
    public Integer total(List<Integer> items, Predicate<Integer> predicate) {
        return items.stream()
                .filter(predicate)
                .mapToInt(value -> value)
                .sum();
    }
}
