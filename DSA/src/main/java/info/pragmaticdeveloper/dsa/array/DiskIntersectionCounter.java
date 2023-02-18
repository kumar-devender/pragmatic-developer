package info.pragmaticdeveloper.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class DiskIntersectionCounter {

    public int getMaxIntersectionBruteForce(int[] arr) {
        Map<Integer, Range> boundaries = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            boundaries.put(i, diskRange(i, arr[i]));
        }

        int intersection = 0;
        for (int i = 0; i < arr.length; i++) {
            Range source = boundaries.get(i);
            for (int j = i + 1; j < arr.length; j++) {
                Range target = boundaries.get(j);
                if (source.isIntersectWith(target)) {
                    intersection++;
                }
            }
        }
        return intersection;
    }

    private Range diskRange(int index, int radius) {
        return new Range(index - radius, index + radius);
    }

    static class Range {
        int left;
        int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        boolean isIntersectWith(Range other) {
            return this.right >= other.left;
        }
    }
}
