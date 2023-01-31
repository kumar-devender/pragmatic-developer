package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class ATMConfig {
    public PaperCurrencyDispenser getDispenser() {
        HundredDispenser hundredDispenser = new HundredDispenser();
        hundredDispenser.setNextDispenser(fiftyDispenser());
        return hundredDispenser;
    }

    public FiftyDispenser fiftyDispenser() {
        FiftyDispenser fiftyDispenser = new FiftyDispenser();
        fiftyDispenser.setNextDispenser(twentyDispenser());
        return fiftyDispenser;
    }

    public TwentyDispenser twentyDispenser() {
        TwentyDispenser twentyDispenser = new TwentyDispenser();
        twentyDispenser.setNextDispenser(tenDispenser());
        return twentyDispenser;
    }

    public TenDispenser tenDispenser() {
        return new TenDispenser();
    }
}
