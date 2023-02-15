package info.pragmaticdeveloper;

import org.junit.jupiter.api.Test;

public class DecimalToBinaryConversionTest {
    @Test
    void testBinary() {
        int n = 15;
        boolean numberDigitBegined = false;
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if (k == 1 && !numberDigitBegined) {
                numberDigitBegined = true;
            }
            if ((k & 1) > 0)
                System.out.print("1");
            else if (numberDigitBegined)
                System.out.print("0");
        }
    }
}
