package info.pragmaticdeveloper.stream.collector;

import info.pragmaticdeveloper.domain.CountryCode;
import info.pragmaticdeveloper.domain.Customer;
import info.pragmaticdeveloper.domain.Order;
import info.pragmaticdeveloper.stream.TestDataProvider;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

public class groupingByCollectorTest {
    private static final List<Order> orders = TestDataProvider.buildStaticOrders();

    @Test
    void testCustomMutableReductionDefaultGrouping() {
        Map<CountryCode, List<Order>> groupByCountry = orders.stream()
                .collect(groupingBy(Order::getCountry));
        System.out.println(groupByCountry);
    }

    @Test
    void testCustomMutableReductionGroupingDownstreamCollection() {
        Map<CountryCode, Set<Order>> groupByCountry = orders.stream()
                .collect(groupingBy(Order::getCountry, toSet()));
        System.out.println(groupByCountry);
    }

    @Test
    void testCustomMutableReductionGroupingMapperAndCustomMapImplementation() {
        Map<CountryCode, List<Order>> customerByCountry = orders.stream()
                .collect(groupingBy(Order::getCountry, TreeMap::new, toList()));
        System.out.println(customerByCountry);
    }

    @Test
    void testCustomMutableReductionGroupingCustomDownstreamCollection() {
        Map<CountryCode, Set<Customer>> customerByCountry = orders.stream()
                .collect(groupingBy(Order::getCountry, mapping(Order::getCustomer, toSet())));
        System.out.println(customerByCountry);
    }
}
