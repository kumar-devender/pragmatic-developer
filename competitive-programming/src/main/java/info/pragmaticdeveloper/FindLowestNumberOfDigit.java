package info.pragmaticdeveloper;

public class FindLowestNumberOfDigit {
    public int findLowestNumber(int number) {
        if (number < 10) {
            return 0;
        }
        int currentSum = 10;
        int multiplicationFactor = 10;
        while (number >= currentSum * multiplicationFactor) {
            currentSum = currentSum * multiplicationFactor;
        }
        return currentSum;
    }
}
