package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class TwentyDispenser extends PaperCurrencyDispenser {
    public static final int TWENTY = 20;

    @Override
    public void dispense(PaperCurrency currency) {
        int amount = currency.getAmount();
        int remainder = amount % TWENTY;
        if (amount >= TWENTY) {
            int total20Notes = amount / TWENTY;
            System.out.printf("Dispensing %d TWENTY notes\n", total20Notes);
        }

        if (remainder != 0 && this.nextDispenser != null) {
            this.nextDispenser.dispense(new PaperCurrency(remainder));
        }
    }
}
