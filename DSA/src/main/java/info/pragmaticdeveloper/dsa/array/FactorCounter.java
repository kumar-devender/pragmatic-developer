package info.pragmaticdeveloper.dsa.array;

public class FactorCounter {
    int count(int n) {
        int i = 1;
        int result = 0;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                result++;
            }
            i++;
        }
        i--;
        if (i == Math.sqrt(n)) {
            return 2 * result - 1;
        }

        return 2 * result;
    }
}
