package info.pragmaticdeveloper.dsa.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {
    public int[] getPrimeUpTo(int end) {
        Set<Integer> prime = IntStream.rangeClosed(2, end)
                .boxed()
                .collect(Collectors.toSet());
        for (int i = 2; i <= ((int) Math.sqrt(end)); i++) {
            // if number has already been remove then do not need check it.
            if (prime.contains(i)) {
                for (int j = i; i * j <= end + 1; j++) {
                    prime.remove(i * j);
                }
            }
        }
        return prime
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

    //https://www.khanacademy.org/computing/computer-science/cryptography/comp-number-theory/v/sieve-of-eratosthenes-prime-adventure-part-4
    public int[] getPrimeUpToNumber(int inclusiveEnd) {
        if (inclusiveEnd < 2) {
            return new int[]{};
        }
        boolean[] isPrime = new boolean[inclusiveEnd + 1];
        for (int i = 2; i <= inclusiveEnd; i++) {
            isPrime[i] = true;
        }
        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 2; i <= (int) Math.sqrt(inclusiveEnd); i++) {
            if (isPrime[i]) {
                primeNumber.add(i);
                // start with square of number and mark all its multiple as non prime. i.e composite
                for (int j = i * i; j <= inclusiveEnd; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = (int) Math.sqrt(inclusiveEnd) + 1; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeNumber.add(i);
            }
        }
        return primeNumber.stream().mapToInt(i -> i).toArray();
    }
}
