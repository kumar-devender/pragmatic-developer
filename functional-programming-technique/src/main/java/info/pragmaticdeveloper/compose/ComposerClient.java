package info.pragmaticdeveloper.compose;

import info.pragmaticdeveloper.Customer;

public class ComposerClient {
    public static void main(String[] args) {
        Customer customer = new Customer(5000, "Devender", 19);
        CustomerValidator customerValidator = CustomerValidator.isBalanceEnough()
                .and(CustomerValidator.isAge())
                .and(CustomerValidator.isNameValid());
        System.out.println(customerValidator.apply(customer));
    }
}
