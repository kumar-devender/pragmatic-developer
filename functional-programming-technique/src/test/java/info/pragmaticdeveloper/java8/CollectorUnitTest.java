package info.pragmaticdeveloper.java8;

import info.pragmaticdeveloper.domain.Dish;
import info.pragmaticdeveloper.domain.Dish.Type;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static info.pragmaticdeveloper.domain.Dish.Type.*;
import static info.pragmaticdeveloper.util.TestDataProvider.buildMenu;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectorUnitTest {
    @Test
    void testMaxCalorieDish() {
        var result = buildMenu().stream()
                .max(comparing(Dish::getCalories)).get();
        assertThat(result, equalTo(new Dish("pork", false, 800, MEAT)));
        result = buildMenu().stream()
                .collect(maxBy(comparing(Dish::getCalories))).get();
        assertThat(result, equalTo(new Dish("pork", false, 800, MEAT)));
    }

    @Test
    void testDishTypeByDecreasingOrderOfCalories() {
        Map<Dish.Type, Integer> expected = new LinkedHashMap<>();
        expected.put(MEAT, 1900);
        expected.put(OTHER, 1550);
        expected.put(FISH, 750);
        var result = buildMenu().stream()
                .collect(groupingBy(Dish::getType))
                .entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey, e -> sumCalories(e.getValue())))
                .entrySet()
                .stream()
                .sorted(comparingInt(Map.Entry<Dish.Type, Integer>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
        assertThat(result, equalTo(expected));
    }

    private int sumCalories(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::getCalories)
                .mapToInt(calories -> calories)
                .sum();
    }

    @Test
    void testSumCaloriesOfDishes() {
        var result = buildMenu()
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();
        assertThat(result, is(4200));
        result = buildMenu()
                .stream()
                .mapToInt(Dish::getCalories)
                .reduce(Integer::sum).getAsInt();
        assertThat(result, is(4200));
        result = buildMenu()
                .stream()
                .collect(summingInt(Dish::getCalories));
        assertThat(result, is(4200));
        result = buildMenu()
                .stream()
                .collect(reducing(0, Dish::getCalories, (i1, i2) -> i1 + i2));
        assertThat(result, is(4200));
    }

    @Test
    void testHighestCaloriesOfDishes() {
        var result = buildMenu()
                .stream()
                .mapToInt(Dish::getCalories)
                .max().getAsInt();
        assertThat(result, is(800));
        result = buildMenu()
                .stream()
                .map(Dish::getCalories)
                .collect(reducing((d1, d2) -> d1 > d2 ? d1 : d2)).get();
        assertThat(result, is(800));
    }

    @Test
    void testAverageCalories() {
        var result = buildMenu()
                .stream()
                .collect(averagingInt(Dish::getCalories));
        assertThat(result.intValue(), is(466));
    }

    @Test
    void testCaloriesDishStatistics() {
        var result = buildMenu()
                .stream()
                .collect(summarizingInt(Dish::getCalories));
        assertThat((int) result.getAverage(), is(466));
        assertThat((int) result.getCount(), is(9));
        assertThat(result.getMax(), is(800));
    }

    @Test
    void testJoinDishesName() {
        var result = buildMenu()
                .stream()
                .map(Dish::getName)
                .collect(Collectors.joining(" ,"));
        assertThat(result, equalTo("pork ,beef ,chicken ,french fries ,rice ,season fruit ,pizza ,prawns ,salmon"));
    }

}
