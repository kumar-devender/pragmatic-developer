package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class FiftyDispenser extends PaperCurrencyDispenser {
    public static final int FIFTY = 50;

    @Override
    public void dispense(PaperCurrency currency) {
        int amount = currency.getAmount();
        int remainder = amount % FIFTY;
        if (amount >= FIFTY) {
            int total50Notes = amount / FIFTY;
            System.out.printf("Dispensing %d FIFTY notes\n", total50Notes);
        }

        if (remainder != 0 && this.nextDispenser != null) {
            this.nextDispenser.dispense(new PaperCurrency(remainder));
        }
    }
}
