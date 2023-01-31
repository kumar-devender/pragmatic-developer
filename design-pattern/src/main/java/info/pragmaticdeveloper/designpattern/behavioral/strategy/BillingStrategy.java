package info.pragmaticdeveloper.designpattern.behavioral.strategy;

import java.util.function.IntUnaryOperator;

public enum BillingStrategy {
    // Normal billing strategy (unchanged price)
    NORMAL(a -> a),
    // Strategy for Happy hour (50% discount)
    HAPPY_HOUR(a -> a / 2),
    ;
    private final IntUnaryOperator strategy;

    BillingStrategy(IntUnaryOperator strategy) {
        this.strategy = strategy;
    }

    // Use a price in cents to avoid floating point round-off error
    int getActPrice(int rawPrice) {
        return this.strategy.applyAsInt(rawPrice);
    }
}
