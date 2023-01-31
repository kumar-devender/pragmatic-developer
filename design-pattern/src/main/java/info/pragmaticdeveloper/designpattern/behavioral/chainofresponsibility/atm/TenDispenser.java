package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class TenDispenser extends PaperCurrencyDispenser {
    public static final int TEN = 10;

    @Override
    public void dispense(PaperCurrency currency) {
        int amount = currency.getAmount();
        int remainder = amount % TEN;
        if (amount >= TEN) {
            int total10Notes = amount / TEN;
            System.out.printf("Dispensing %d TEN notes\n", total10Notes);
        }

        if (remainder != 0 && this.nextDispenser != null) {
            this.nextDispenser.dispense(new PaperCurrency(remainder));
        }
    }
}
