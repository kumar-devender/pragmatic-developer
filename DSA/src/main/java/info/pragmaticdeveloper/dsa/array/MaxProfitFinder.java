package info.pragmaticdeveloper.dsa.array;

public class MaxProfitFinder {
    public int maxPossibleProfitBruteForce(int[] price) {
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                int sliceProfit = price[j] - price[i];
                maxProfit = Math.max(maxProfit, sliceProfit);
            }
        }
        return maxProfit;
    }

    public int maxPossibleProfit(int[] price) {
        if (price.length < 1) {
            return 0;
        }

        int maxProfit = 0;
        int min = price[0];
        int currentSum = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] < min) {
                min = price[i];
                currentSum = 0;
            } else {
                currentSum += price[i] - price[i - 1];
            }

            if (maxProfit < currentSum) {
                maxProfit = currentSum;
            }
        }
        return maxProfit;
    }
}
