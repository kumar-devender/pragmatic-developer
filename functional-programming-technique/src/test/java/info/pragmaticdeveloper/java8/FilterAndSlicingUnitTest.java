package info.pragmaticdeveloper.java8;

import info.pragmaticdeveloper.domain.Dish;
import info.pragmaticdeveloper.domain.Trader;
import info.pragmaticdeveloper.domain.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static info.pragmaticdeveloper.util.TestDataProvider.buildMenu;
import static info.pragmaticdeveloper.util.TestDataProvider.buildTransactions;
import static java.util.stream.Collectors.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;

public class FilterAndSlicingUnitTest {
    @Test
    void getFirstThreeDishWithCaloriesAbove300() {
        List<Dish> menu = buildMenu();
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        assertThat(dishes, hasSize(3));
    }

    @Test
    void getDistinctCharsFromAllStrings() {
        String[] arraysOfWords = {"hello", "world"};
        String uniqueChars = Arrays.stream(arraysOfWords)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.joining(","));
        assertThat(uniqueChars, equalTo("h,e,l,o,w,r,d"));
    }

    @Test
    void getSquareOfNumber() {
        int[] numbers = {1, 2, 3, 4, 5};
        List<Integer> squares = Arrays.stream(numbers)
                .boxed()
                .map(n -> n * n)
                .collect(Collectors.toList());
        assertThat(squares, equalTo(Arrays.asList(1, 4, 9, 16, 25)));
    }

    @Test
    void getPairNumber() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2};
        List<int[]> pairs = Arrays.stream(arr1)
                .boxed()
                .flatMap(i -> Arrays.stream(arr2)
                        .boxed()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        assertThat(pairs, hasSize(6));
    }

    @Test
    void sumAllNumbers() {
        int[] arr = {1, 2, 3};
        int sum = Arrays.stream(arr)
                .boxed()
                .reduce(0, (n1, n2) -> n1 + n2);
        assertThat(sum, is(6));
        sum = Arrays.stream(arr)
                .sum();
        assertThat(sum, is(6));
        sum = Arrays.stream(arr)
                .boxed()
                .reduce(0, Integer::sum);
        assertThat(sum, is(6));
        sum = Arrays.stream(arr)
                .boxed()
                .collect(reducing(0, Integer::sum));
        assertThat(sum, is(6));
        sum = Arrays.stream(arr)
                .boxed()
                .reduce((a, b) -> a + b).get();
        assertThat(sum, is(6));
        sum = Arrays.stream(arr)
                .boxed()
                .reduce(Integer::sum).get();
        assertThat(sum, is(6));
    }

    @Test
    void testMinNumbers() {
        int[] arr = {1, 2, 3};
        int min = Arrays.stream(arr)
                .boxed()
                .reduce(Integer::min).get();
        assertThat(min, is(1));
        min = Arrays.stream(arr)
                .boxed()
                .reduce((a, b) -> a > b ? b : a).get();
        assertThat(min, is(1));
    }

    @Test
    void testVegetarianFriendly() {
        boolean isVegetarianFriendly = buildMenu()
                .stream()
                .anyMatch(Dish::isVegetarian);
        assertThat(isVegetarianFriendly, is(true));
    }

    @Test
    void testAllTransactionsIn2011AndSortByValue() {
        var result = buildTransactions()
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        assertThat(result, hasSize(2));

        assertThat(result, contains(hasProperty("value", is(300)),
                hasProperty("value", is(400))));

        assertThat(result, hasItems(
                allOf(hasProperty("value", is(400)),
                        hasProperty("trader", allOf(
                                hasProperty("name", equalTo("Raoul")),
                                hasProperty("city", equalTo("Cambridge"))))),
                allOf(hasProperty("value", is(300)),
                        hasProperty("trader", allOf(
                                hasProperty("name", equalTo("Brian")),
                                hasProperty("city", equalTo("Cambridge")))))
        ));
    }

    @Test
    void testAllTheUniqueCitiesWhereTradersWork() {
        var result = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        assertThat(result, containsInAnyOrder("Cambridge", "Milan"));
        var result2 = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
        assertThat(result2, containsInAnyOrder("Cambridge", "Milan"));
    }

    @Test
    void testGetAllTraderFromCambridgeAndSortByName() {
        var result = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        assertThat(result, contains("Alan", "Brian", "Raoul"));
    }

    @Test
    void testGetAllAsSingleStringSortByName() {
        var result = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (s1, s2) -> s1 + s2);
        assertThat(result, equalTo("AlanBrianMarioRaoul"));
        result = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        assertThat(result, equalTo("AlanBrianMarioRaoul"));
    }

    @Test
    void IsAnyTraderFromMilan() {
        var result = buildTransactions()
                .stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> !"Milan".equals(trader.getCity()));
        assertThat(result, is(true));
    }

    @Test
    void highestTransactionValue() {
        var result = buildTransactions()
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).get();
        assertThat(result, is(1000));
        result = buildTransactions()
                .stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getValue)
                .findFirst().get();
        assertThat(result, is(1000));
    }

    @Test
    void minValueTransaction() {
        var result = buildTransactions()
                .stream()
                .min(Comparator.comparing(Transaction::getValue)).get();
        assertThat(result.getValue(), is(300));
        result = buildTransactions()
                .stream()
                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t2 : t1).get();
        assertThat(result.getValue(), is(300));
    }

    @Test
    void getTotalTransactionValue() {
        var result = buildTransactions()
                .stream()
                .mapToInt(Transaction::getValue)
                .sum();
        assertThat(result, is(4060));
        result = buildTransactions()
                .stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        assertThat(result, is(4060));
        result = buildTransactions()
                .stream()
                .map(Transaction::getValue)
                .reduce(0, (t1, t2) -> t1 + t2);
        assertThat(result, is(4060));
    }

    @Test
    void generateNumber() {
        var result = Stream.iterate(0, i -> i < 5, i -> i + 1)
                .collect(Collectors.toList());
        assertThat(result, contains(0, 1, 2, 3, 4));
        result = Stream.generate(() -> 2)
                .limit(5)
                .collect(Collectors.toList());
        assertThat(result, contains(2, 2, 2, 2, 2));
    }

    @Test
    void generate10Fibonacci() {
        var result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .collect(Collectors.toList());
        assertThat(result, contains(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));

        IntSupplier supplier = new IntSupplier() {
            int current = 1;
            int previous = 0;

            @Override
            public int getAsInt() {
                int next = current + previous;
                int oldPrevious = previous;
                previous = current;
                current = next;
                return oldPrevious;
            }
        };
        result = IntStream.generate(supplier)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        assertThat(result, contains(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
    }

    @Test
    void groupTransactionByCity() {
        var result = buildTransactions()
                .stream()
                .collect(groupingBy(transaction -> transaction.getTrader().getCity()));
        assertThat(result.keySet(), containsInAnyOrder("Cambridge", "Milan"));
    }
}
