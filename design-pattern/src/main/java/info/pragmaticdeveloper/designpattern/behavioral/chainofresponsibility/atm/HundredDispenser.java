package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class HundredDispenser extends PaperCurrencyDispenser {
    public static final int HUNDRED = 100;

    @Override
    public void dispense(PaperCurrency currency) {
        int amount = currency.getAmount();
        int remainder = amount % HUNDRED;
        if (amount >= HUNDRED) {
            int total100Notes = amount / HUNDRED;
            System.out.printf("Dispensing %d HUNDRED notes\n", total100Notes);
        }

        if (remainder != 0 && this.nextDispenser != null) {
            this.nextDispenser.dispense(new PaperCurrency(remainder));
        }
    }
}
