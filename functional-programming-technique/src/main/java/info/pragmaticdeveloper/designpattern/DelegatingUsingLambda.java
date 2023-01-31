package info.pragmaticdeveloper.designpattern;

public class DelegatingUsingLambda {
    public static void main(String[] args) {
        int x = 4;
    }

    private static int compute(int number) {
        System.out.println("Compute called...");
        return number * 2;
    }
}
