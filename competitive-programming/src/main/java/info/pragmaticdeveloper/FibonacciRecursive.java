package info.pragmaticdeveloper;

import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursive {
    private static Map<Integer, Integer> previousComputed = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(fibonacci(i, previousComputed));
        }
    }

    private static int fibonacci(int n, Map<Integer, Integer> previousComputed) {
        if (previousComputed.containsKey(n)) {
            return previousComputed.get(n);
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fibonacci(n - 1, previousComputed) + fibonacci(n - 2, previousComputed);
        previousComputed.put(n, result);
        return result;
    }
}
