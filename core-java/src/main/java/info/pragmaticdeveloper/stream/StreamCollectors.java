package info.pragmaticdeveloper.stream;

import info.pragmaticdeveloper.domain.Customer;
import info.pragmaticdeveloper.domain.Order;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectors {

    public List<Customer> getCustomers(List<Order> orders) {
        return orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toList());
    }

}
