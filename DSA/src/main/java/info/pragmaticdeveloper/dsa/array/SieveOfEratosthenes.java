package info.pragmaticdeveloper.dsa.array;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {
    public int[] getPrimeUpTo(int end) {
        Set<Integer> prime = IntStream.rangeClosed(2, end)
                .boxed()
                .collect(Collectors.toSet());
        for (int i = 2; i <= ((int) Math.sqrt(end)) + 1; i++) {
            for (int j = i; i * j <= end + 1; j++) {
                prime.remove(i * j);
            }
        }
        return prime
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
