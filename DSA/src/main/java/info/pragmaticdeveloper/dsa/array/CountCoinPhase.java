package info.pragmaticdeveloper.dsa.array;

public class CountCoinPhase {
    public int countCoinPhase(int coin) {
        int[] coinFlipCount = new int[coin];
        for (int i = 1; i <= coin; i++) {
            coinFlipCount[i - 1] = countDivisor(i);
        }
        int flipCoinCount = 0;
        for (int i = 0; i < coin; i++) {
            if (coinFlipCount[i] % 2 != 0) {
                flipCoinCount++;
            }
        }
        return flipCoinCount;
    }

    private int countDivisor(int n) {
        int sum = 0;

        int i = 1;
        while (i * i < n) {
            if (n % i == 0) {
                sum += 2;
            }
            i++;
        }
        if (i * i == n) {
            sum += 1;
        }
        return sum;
    }
}
