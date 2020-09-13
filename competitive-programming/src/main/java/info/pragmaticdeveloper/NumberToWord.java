package info.pragmaticdeveloper;

import static java.lang.String.format;

public class NumberToWord {
    private static String[] FIRSTNINTEEN = {"", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String convert(int number) {
        if (number < 20) {
            return FIRSTNINTEEN[number];
        }

        if (number < 100) {
            return TENS[number / 10] + " " + convert(number % 10);
        }

        if (number < 1000) {
            return FIRSTNINTEEN[number / 100] + " hundred " + convert(number / 10);
        }

        if (number < 10000) {
            return FIRSTNINTEEN[number / 1000] + " thousand " + convert(number / 10);
        }

        if (number < 100000) {
            return TENS[number / 10000] + " " + FIRSTNINTEEN[number / 10000] + " thousand " + convert(number / 100);
        }

        throw new IllegalArgumentException(format("Not implemented for number %d", number));
    }
}
