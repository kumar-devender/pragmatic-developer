package info.pragmaticdeveloper.dsa.gcd;

public class ChocolateTable {

    public int countEatenChocolate(int n, int m) {
        //(n*m / gcd(n, m))/m
        return n / gcd(n, m);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
