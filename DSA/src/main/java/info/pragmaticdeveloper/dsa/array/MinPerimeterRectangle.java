package info.pragmaticdeveloper.dsa.array;

public class MinPerimeterRectangle {
    public int getMinPerimeterRectangle(int n) {
        int aMin = 1;
        int bMin = n;
        int i = 1;
        while (i * i < n) {
            if (n % i == 0) {
                if (i + (n / i) < aMin + bMin) {
                    aMin = i;
                    bMin = n / i;
                }
            }
            i++;
        }

        if (i * i == n) {
            aMin = i;
            bMin = i;
        }
        return 2 * (aMin + bMin);

    }
}
