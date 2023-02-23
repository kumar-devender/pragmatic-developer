package info.pragmaticdeveloper.dsa.array;

import java.util.Arrays;

public class MaxBlockWithPeak {
    public int findMaxBlock(int[] arr) {
        int[] peaks = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peaks[i] = 1;
            }
        }

        int totalPeaks = Arrays.stream(peaks)
                .sum();
        if (totalPeaks == 0) {
            return 0;
        }

        for (int k = totalPeaks; k >= 2; k--) {
            //bec we want to divide array into equal size bock
            if (arr.length % k == 0) {
                int blockSize = arr.length / k;
                int i = 0;
                int peakInCurrentBlock = 0;
                for (i = 0; i < peaks.length; i++) {
                    peakInCurrentBlock += peaks[i];
                    /*
                     * current block end reached and still no peak in the block that mean with
                     * current block size not possible to divide array into equal size block having atleast one peak
                     */
                    if ((i + 1) % blockSize == 0 && peakInCurrentBlock < 1) {
                        break;
                    }

                    // current block end reached and its peak count is greater than 0
                    if ((i + 1) % blockSize == 0) {
                        peakInCurrentBlock = 0;
                    }
                }
                if (i >= arr.length) {
                    return k;
                }
            }
        }

        return 1;
    }
}
