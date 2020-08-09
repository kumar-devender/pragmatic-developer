package info.pragmaticdeveloper.stream.collector;

import info.pragmaticdeveloper.domain.CountryCode;
import info.pragmaticdeveloper.domain.Order;
import info.pragmaticdeveloper.stream.TestDataProvider;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class ReducingCollectorTest {
    private static final List<Order> orders = TestDataProvider.buildStaticOrders();

    @Test
    public void testMutableReductionReducingWithIdentityAndMapperFunction() {
        Comparator<Integer> maxByAmount = Comparator.comparing(Integer::valueOf);
        Map<CountryCode, Integer> countryWiseOrderMaxAmount = orders.stream()
                .collect(groupingBy(Order::getCountry,
                        reducing(0, Order::getAmount, BinaryOperator.maxBy(maxByAmount))));
        System.out.println(countryWiseOrderMaxAmount);
    }

    @Test
    public void testMutableReductionReducing() {
        Comparator<Order> maxByAmount = Comparator.comparing(Order::getAmount);
        Map<CountryCode, Optional<Order>> countriesOfOrders = orders.stream()
                .collect(groupingBy(Order::getCountry,
                        reducing(BinaryOperator.maxBy(maxByAmount))));
        System.out.println(countriesOfOrders);
    }
}
