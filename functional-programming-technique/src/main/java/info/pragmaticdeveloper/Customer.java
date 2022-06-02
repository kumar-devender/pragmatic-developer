package info.pragmaticdeveloper;

public class Customer {
    private Integer rewardsBalance;
    private String name;
    private Integer age;

    public Customer(Integer rewardsBalance, String name, Integer age) {
        this.rewardsBalance = rewardsBalance;
        this.name = name;
        this.age = age;
    }

    public Integer getRewardsBalance() {
        return rewardsBalance;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
