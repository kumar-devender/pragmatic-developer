package info.pragmaticdeveloper.stream.collector;

import info.pragmaticdeveloper.domain.CountryCode;
import info.pragmaticdeveloper.domain.Order;
import info.pragmaticdeveloper.stream.TestDataProvider;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToMapStreamCollectorTest {
    private static final List<Order> orders = TestDataProvider.buildStaticOrders();

    @Test
    void testCustomMutableReductionToMap() {
        Map<Integer, Order> mapById = orders.stream()
                .collect(toMap(Order::getId, identity()));
        System.out.println(mapById);
    }

    @Test
    void testCustomMutableReductionToMapDuplicateKeyException() {
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> {
                    Map<CountryCode, Order> mapByCountry = orders.stream()
                            .collect(toMap(Order::getCountry, identity()));
                });
        assertThat(exception.getMessage(), CoreMatchers.startsWith("Duplicate key Order"));
    }


    @Test
    void testCustomMutableReductionToMapDuplicateKey() {
        Map<CountryCode, Order> mapByCountry = orders.stream()
                .collect(toMap(Order::getCountry, identity(), (left, right) -> right));
        System.out.println(mapByCountry);
    }

    @Test
    void testCustomMutableReductionToMapDuplicateKeyCustomMapImplementation() {
        Map<CountryCode, Order> mapByCountry = orders.stream()
                .collect(toMap(Order::getCountry, identity(), (left, right) -> right, TreeMap::new));
        System.out.println(mapByCountry);
    }
}
