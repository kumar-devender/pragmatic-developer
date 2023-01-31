package info.pragmaticdeveloper.designpattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class CustomerBill {
    private final List<Integer> drinks = new ArrayList<>();
    private BillingStrategy strategy;

    public CustomerBill(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public void print() {
        drinks.forEach(System.out::println);
    }

    public double getTotal() {
        return drinks.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void add(int price, int quantity) {
        drinks.add(strategy.getActPrice(price) * quantity);
    }

    // Set Strategy
    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}
