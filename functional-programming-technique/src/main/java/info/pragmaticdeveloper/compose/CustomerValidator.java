package info.pragmaticdeveloper.compose;

import info.pragmaticdeveloper.Customer;

import java.util.function.Function;


public interface CustomerValidator extends Function<Customer, CustomerValidator.Result> {

    static CustomerValidator isBalanceEnough() {
        return customer -> customer.getRewardsBalance() > 100 ? Result.SUCCESS : Result.FAIL;
    }

    static CustomerValidator isNameValid() {
        return customer -> customer.getName() != null
                && !customer.getName().trim().equals("") ? Result.SUCCESS : Result.FAIL;
    }

    static CustomerValidator isAge() {
        return customer -> customer.getAge() > 18 ? Result.SUCCESS : Result.FAIL;
    }

    default CustomerValidator and(CustomerValidator other) {
        return customer -> {
            Result result = this.apply(customer);
            return result == Result.SUCCESS ? other.apply(customer) : result;
        };
    }

    enum Result {
        SUCCESS,
        FAIL
    }
}
