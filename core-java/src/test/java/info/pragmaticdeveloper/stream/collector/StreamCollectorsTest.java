package info.pragmaticdeveloper.stream.collector;

import info.pragmaticdeveloper.domain.CountryCode;
import info.pragmaticdeveloper.domain.Customer;
import info.pragmaticdeveloper.domain.Order;
import info.pragmaticdeveloper.stream.TestDataProvider;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static info.pragmaticdeveloper.stream.TestDataProvider.itemNames;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

class StreamCollectorsTest {
    private static final List<Order> orders = TestDataProvider.buildStaticOrders();

    @Test
    void testCustomMutableReduction() {
        Set<String> itemsSet = itemNames.stream()
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println(itemsSet);
    }

    @Test
    void testCustomMutableReductionEquivalent() {
        String str = itemNames.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(str);
    }

    @Test
    void testCollectName() {
        Map<String, Integer> map = itemNames.stream()
                .collect(groupingBy(identity(), collectingAndThen(counting(), Long::intValue)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value2, LinkedHashMap::new));

        System.out.println(map);
    }


    //CollectingAndThen
    @Test
    void testMutableReductionCollectingAndThen() {
        Map<String, CountryCode> CountryCodeMap = stream(CountryCode.values())
                .collect(collectingAndThen(toMap(CountryCode::getValue, identity()),
                        Collections::unmodifiableMap));
        System.out.println(CountryCodeMap);
    }

    //toList
    @Test
    void testMutableReductionToList() {
        List<Customer> customers = orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toList());
        System.out.println(customers);
    }

    @Test
    void testMutableReductionToListCustomCollector() {
        List<Customer> customers = orders.stream()
                .map(Order::getCustomer)
                .collect(LinkedList::new, List::add, List::addAll);
        System.out.println(customers);
    }

    //toSet
    @Test
    void testMutableReductionToSet() {
        Set<Customer> customers = orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toSet());
        System.out.println(customers);
    }

    @Test
    void testMutableReductionToSetCustomCollector() {
        Set<Customer> customers = orders.stream()
                .map(Order::getCustomer)
                .collect(LinkedHashSet::new, Set::add, Set::addAll);
        System.out.println(customers);
    }

    //toCollection
    @Test
    void testMutableReductionToCollection() {
        Set<Customer> customers = orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(customers);
    }

    //mapping
    @Test
    void testCustomMutableReductionMapping() {
        Set<CountryCode> countriesOfOrders = orders.stream()
                .collect(mapping(Order::getCountry, toSet()));
        System.out.println(countriesOfOrders);
    }

}