package info.pragmaticdeveloper.dsa.array;

public class MinMaxDivision {
    public int getMinPossibleBlockSize(int K, int M, int[] A) {
        int max = 0;
        int min = 0;

        for (int item : A) {
            max += item;
            min = Math.max(min, item);
        }
        int result = max;
        while (min <= max) {
            int mid = (max + min) / 2;
            int block = blocksOfSize(A, mid);
            if (block > K) {
                min = mid + 1;
            } else {
                max = mid - 1;
                if (mid < result) {
                    result = mid;
                }
            }
        }
        return result;
    }

    private int blocksOfSize(int[] A, int maxBlockSize) {
        int block = 1;
        int currentBlockSum = 0;
        for (int item : A) {
            currentBlockSum += item;
            if (currentBlockSum > maxBlockSize) {
                currentBlockSum = item;
                block++;
            }
        }
        return block;
    }
}
