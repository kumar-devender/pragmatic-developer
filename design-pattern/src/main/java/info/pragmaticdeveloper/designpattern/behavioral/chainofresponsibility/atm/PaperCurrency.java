package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class PaperCurrency {
    private int amount;

    public PaperCurrency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
