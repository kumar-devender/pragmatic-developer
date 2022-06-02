package info.pragmaticdeveloper.callbacks;

import info.pragmaticdeveloper.Customer;

import java.util.function.Consumer;

public class CallBackClient {
    public static void main(String[] args) {
        Customer customer = new Customer( 5000, "Devender", 19);
        validateAndProceed(customer, (Customer customer1) -> System.out.println("Please add more balance : " + customer.getName()));
        validateAndProceed(customer, () -> System.out.println("Please provide name"));
    }

    private static void validateAndProceed(Customer customer, Consumer<Customer> callback) {
        if (customer.getRewardsBalance() < 10000) {
            callback.accept(customer);
        }
    }

    private static void validateAndProceed(Customer customer, Runnable callback) {
        if (customer.getRewardsBalance() < 10000) {
            callback.run();
        }
    }
}
