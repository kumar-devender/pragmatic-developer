package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.atm;

public class ATMWithdraw {
    public static void main(String[] args) {
        new ATMConfig().getDispenser()
                .dispense(new PaperCurrency(350));
    }
}
