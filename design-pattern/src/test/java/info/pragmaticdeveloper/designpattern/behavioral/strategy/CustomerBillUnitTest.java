package info.pragmaticdeveloper.designpattern.behavioral.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class CustomerBillUnitTest {
    private final CustomerBill customerBill = new CustomerBill(BillingStrategy.NORMAL);

    @ParameterizedTest(name = "billingStrategy : {0}, drinkPrice: {1}, quantity {2}, expectTotal:{3}")
    @CsvSource(value = {"NORMAL:100:2:200", "HAPPY_HOUR:100:2:100"}, delimiterString = ":")
    @DisplayName("Test different strategy result correct calculation")
    void testCustomerBill(BillingStrategy billingStrategy, int drinkPrice, int quantity, double expectTotal) {
        customerBill.setStrategy(billingStrategy);
        customerBill.add(drinkPrice, quantity);
        assertThat(customerBill.getTotal(), is(expectTotal));
    }
}