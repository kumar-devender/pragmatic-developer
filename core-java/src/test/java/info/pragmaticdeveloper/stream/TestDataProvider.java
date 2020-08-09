package info.pragmaticdeveloper.stream;

import info.pragmaticdeveloper.domain.Customer;
import info.pragmaticdeveloper.domain.Item;
import info.pragmaticdeveloper.domain.Order;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static info.pragmaticdeveloper.domain.CountryCode.*;

@UtilityClass
public class TestDataProvider {
    private static final Random random = new Random();
    public static List<String> customerNames = Arrays.asList("Devender", "Devendra", "Dheeraj", "Alex", "Christina", "Tom", "Paul", "Bob");
    public static List<String> itemNames = Arrays.asList("Carriage", "Marbles", "Pen", "Lock", "Carriage", "Ring", "Pen", "Scissors", "Car", "Handicraft", "String", "Bed", "Car");

    public List<Order> buildOrders(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> buildOrder(index))
                .collect(Collectors.toList());
    }

    public List<Order> buildStaticOrders() {
        return Arrays.asList(
                new Order(1, 550, IN, new Customer(2, "Alex")),
                new Order(2, 550, IN, new Customer(3, "Christina")),
                new Order(3, 200, FR, new Customer(4, "Tom")),
                new Order(4, 250, FR, new Customer(1, "Devender")),
                new Order(5, 1200, US, new Customer(5, "Paul")),
                new Order(6, 1210, US, new Customer(2, "Alex")),
                new Order(7, 400, CN, new Customer(1, "Devender")),
                new Order(8, 400, CN, new Customer(6, "Mohemad")),
                new Order(9, 550, AF, new Customer(7, "Dheeraj")),
                new Order(10, 550, AF, new Customer(8, "Bob")),
                new Order(11, 560, AF, new Customer(1, "Devender")),
                new Order(12, 600, IN, new Customer(1, "Devender")));
    }

    public List<Order> buildStaticOrdersWihtoutCustomer() {
        return Arrays.asList(new Order(1, 50, IN, new Customer(1, "Devender")),
                new Order(1, 500, IN, new Customer(2, "Alex")),
                new Order(2, 510, IN, new Customer(3, "Christina")),
                new Order(3, 200, FR, new Customer(4, "Tom")),
                new Order(4, 140, FR, new Customer(1, "Devender")),
                new Order(5, 1200, US, new Customer(5, "Paul")),
                new Order(6, 160, US, new Customer(2, "Alex")),
                new Order(7, 400, CN, new Customer(1, "Devender")),
                new Order(8, 350, CN, new Customer(6, "Mohemad")),
                new Order(9, 550, AF, new Customer(7, "Dheeraj")),
                new Order(10, 150, AF, new Customer(8, "Bob")),
                new Order(11, 50, AF, new Customer(1, "Devender")));
    }

    public List<Item> buildStaticItem() {
        return Arrays.asList(
                new Item(1, 5, "Carriage"),
                new Item(2, 3, "Marbles"),
                new Item(3, 6, "Pen"),
                new Item(4, 2, "Lock"),
                new Item(5, 4, "Ring"),
                new Item(6, 2, "Carriage"),
                new Item(7, 5, "Pen"),
                new Item(8, 4, "Scissors"),
                new Item(9, 6, "Car"),
                new Item(10, 5, "Handicraft")
        );
    }

    public List<Item> buildItems(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> buildItem(index))
                .collect(Collectors.toList());
    }

    public List<Order> buildOrders(int count, Customer customer) {
        return IntStream.range(0, count)
                .mapToObj(index -> buildOrder(index))
                .collect(Collectors.toList());
    }

    private Item buildItem(int id) {
        int itemIndex = random.nextInt(itemNames.size() - 1);
        return Item.builder().id(id)
                .name(itemNames.get(itemIndex))
                .price(itemIndex)
                .build();
    }

    private Order buildOrder(int id) {
        return Order.builder()
                .id(id)
                .customer(buildCustomer(id, customerNames.get(id)))
                .amount(0)
                .build();
    }

    private Order buildOrder(int id, Customer customer) {
        return Order.builder()
                .id(id)
                .customer(customer)
                .build();
    }

    private Customer buildCustomer(int id, String name) {
        return Customer.builder()
                .id(id)
                .name(name).build();
    }

}
