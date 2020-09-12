package info.pragmaticdeveloper;

public class ReverseNumber {
    public int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }
}
