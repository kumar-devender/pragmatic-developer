package info.pragmaticdeveloper.stream.collector;

import info.pragmaticdeveloper.domain.CountryCode;
import info.pragmaticdeveloper.domain.Order;
import info.pragmaticdeveloper.stream.TestDataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class PartitioningByCollectorTest {
    private static final List<Order> orders = TestDataProvider.buildStaticOrders();
    @Test
    void testMutableReductionPartitioningBy() {
        Map<Boolean, List<Order>> orderPartitionByAmount = orders.stream()
                .collect(partitioningBy(order -> order.getAmount() > 500));
        System.out.println(orderPartitionByAmount);
    }

    @Test
    void testMutableReductionPartitioningCustomDownStreamCollector() {
        Map<Boolean, Set<Order>> orderPartitionByAmount = orders.stream()
                .collect(partitioningBy(order -> order.getAmount() > 500, toSet()));
        System.out.println(orderPartitionByAmount);
    }

    @Test
    public void testMutableReductionPartitioningCustomDownStreamCollectorMapping() {
        Map<Boolean, Set<CountryCode>> countryPartitionByAmount = orders.stream()
                .collect(partitioningBy(order -> order.getAmount() > 500, mapping(Order::getCountry, toSet())));
        System.out.println(countryPartitionByAmount);
    }
}
