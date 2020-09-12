package info.pragmaticdeveloper;

public class PalindromeFinder {
    public boolean isPalindrome(int number) {
        int numberCopy = number;
        int reverseNumber = 0;
        while (numberCopy > 0) {
            reverseNumber = reverseNumber * 10 + numberCopy % 10;
            numberCopy = numberCopy / 10;
        }
        return reverseNumber == number;
    }
}
