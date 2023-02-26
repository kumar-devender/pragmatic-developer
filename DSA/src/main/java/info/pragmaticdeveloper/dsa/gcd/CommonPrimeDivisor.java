package info.pragmaticdeveloper.dsa.gcd;

public class CommonPrimeDivisor {
    public int getCommonPrimeDivisor(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            int d = gcd(a, b);
            while (gcd(a, d) != 1) {
                a /= gcd(a, d);
            }

            while (gcd(b, d) != 1) {
                b /= gcd(b, d);
            }

            if (a == 1 && b == 1) {
                count++;
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
