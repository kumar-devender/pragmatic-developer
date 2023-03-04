package info.pragmaticdeveloper.dsa.array;

public class SubSequenceSum {
    public int[] getSubsSequence(int arr[], int s) {

        int total = 0;
        int front = 0;
        for (int back = 0; back <= arr.length; back++) {
            while (front < arr.length && total + arr[front] <= s) {
                total += arr[front++];
            }
            if (total == s) {
                // make array
            }
            total -= arr[back];
        }
        return new int[]{};
    }
}
