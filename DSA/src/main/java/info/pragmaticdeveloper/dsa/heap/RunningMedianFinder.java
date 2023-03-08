package info.pragmaticdeveloper.dsa.heap;

import java.util.PriorityQueue;

public class RunningMedianFinder {
    public double[] getRunningMedian(int[] arr) {
        double[] median = new double[arr.length];

        //max heap
        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));
        //min heap
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            addItem(arr[i], lower, higher);
            rebalance(lower, higher);
            median[i] = getMedian(lower, higher);
        }
        return median;
    }

    private double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> smallerHeap = lower.size() < higher.size() ? lower : higher;
        PriorityQueue<Integer> biggerHeap = lower.size() < higher.size() ? higher : lower;
        if (smallerHeap.size() == biggerHeap.size()) {
            return (double) (smallerHeap.peek() + biggerHeap.peek()) / 2;
        }
        return biggerHeap.peek();
    }

    private void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> smallerHeap = lower.size() < higher.size() ? lower : higher;
        PriorityQueue<Integer> biggerHeap = lower.size() < higher.size() ? higher : lower;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private void addItem(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }
}
