package info.pragmaticdeveloper.dsa.array;

public class MaximumProduct {
    public int maxThreeProduct(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int j : arr) {
            if (min1 >= j) {
                min2 = min1;
                min1 = j;
            } else if (min2 >= j) {
                min2 = j;
            }

            if (max1 <= j) {
                max3 = max2;
                max2 = max1;
                max1 = j;
            } else if (max2 <= j) {
                max3 = max2;
                max2 = j;
            } else if (max3 <= j) {
                max3 = j;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
