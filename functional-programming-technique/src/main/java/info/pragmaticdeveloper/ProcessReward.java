package info.pragmaticdeveloper;

public class ProcessReward {
    public static Order issueReward(Order order) {
        return new Order(OrderStatus.REWARD_ISSUED, order.getOrderRewards());
    }

    public static Customer updateBalanceReward(Order order, Customer customer) {
        return new Customer(order.getOrderRewards() + customer.getRewardsBalance());
    }
}
