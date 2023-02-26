package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;

public class SemiPrimeFinder {

    public int[] getSemiPrime(int n, int[] P, int[] Q) {
        var semiPrimePrefixSum = semiPrimePrefixSum(n);
        int[] semiPrime = new int[P.length];
        for (int i = 0; i < semiPrime.length; i++) {
            semiPrime[i] = semiPrimePrefixSum[Q[i]] - semiPrimePrefixSum[P[i] - 1];
        }
        return semiPrime;
    }

    private int[] semiPrimePrefixSum(int n) {
        boolean[] primeIndicator = buildPrime(n);
        boolean[] subPrimes = new boolean[n + 1];
        Arrays.fill(subPrimes, 2, n + 1, false);
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (primeIndicator[i] && primeIndicator[j] && i * j <= n) {
                    subPrimes[i * j] = true;
                }
                if (i * j > n) {
                    break;
                }
            }
        }
        int[] primePrefixSum = new int[n + 1];
        for (int i = 4; i <= n; i++) {
            if (subPrimes[i]) {
                primePrefixSum[i] = primePrefixSum[i - 1] + 1;
            } else {
                primePrefixSum[i] = primePrefixSum[i - 1];
            }
        }
        return primePrefixSum;
    }

    private boolean[] buildPrime(int n) {
        boolean[] primeIndicator = new boolean[n + 1];
        Arrays.fill(primeIndicator, 2, n + 1, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j < n; j = j + i) {
                primeIndicator[j] = false;
            }
        }
        return primeIndicator;
    }
}
