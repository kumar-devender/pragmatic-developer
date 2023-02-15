package info.pragmaticdeveloper.dsa.array;

public class CountDiv {

    int countDiv(int a, int b, int k) {
        int count = b / k;
        count += a == 0 ? 1 : 0;
        if (a < k) {
            return count;
        }

        int prefixCount = 0;
        for (int i = k; i < a; i = i + k) {
            prefixCount++;
        }
        return count - prefixCount;
    }
}
