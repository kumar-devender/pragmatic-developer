package info.pragmaticdeveloper;

public class Order {
    private OrderStatus orderStatus;
    private Integer orderRewards;

    public Order(OrderStatus orderStatus, Integer orderRewards) {
        this.orderStatus = orderStatus;
        this.orderRewards = orderRewards;
    }

    public Integer getOrderRewards() {
        return orderRewards;
    }
}
