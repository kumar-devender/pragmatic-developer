package info.pragmaticdeveloper.dsa.recursion;

public class SumOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 7, 4};
        System.out.println(sum(arr, 0));
    }

    private static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        } else {
            return arr[index] + sum(arr, ++index);
        }
    }
}
