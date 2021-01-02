package info.pragmaticdeveloper;

/**
 * Given a string str consisting of letters only and an integer n, the task is to replace every character of the given string by a character which is n times more than it. If the letter exceeds ‘z’, then start checking from ‘a’ in a cyclic manner.
 *
 * Examples:
 * Input: str = “abc”, n = 2
 * Output: cde
 * a is moved by 2 times which results in character c
 * b is moved by 2 times which results in character d
 * c is moved by 2 times which results in character e
 *
 * Input: str = “abc”, n= 28
 * Output: cde
 * a is moved 25 times, z is reached. Then the 26th character will be a, 27th b and 28th c.
 * b is moved 24 times, z is reached. 28-th is d.
 * c is moved 23 times, z is reached. 28-th is f.
 *
 * Question:
 * a/ Write an algorithm to solve the above issue. Please consider the complexity of the algorithm.
 * b/ What is the disadvantage of using the ASCII value of the letters to solve this problem?
 */

public class CyclicCharacterIncrementer {
    private static final int LAST_CODE_POINT = 122;
    private static final int FIRST_CODE_POINT = 96;
    private static final int SMALL_LETTERS_COUNT = 26;

    public String incrementChars(String input, int counter) {
        StringBuilder sb = new StringBuilder();
        //a = 97
        //z = 122
        counter = counter % SMALL_LETTERS_COUNT;

        for (int i = 0; i < input.length(); i++) {
            int asciiValue = input.codePointAt(i);
            int afterAddingCount = counter + asciiValue;
            if (afterAddingCount > LAST_CODE_POINT) {
                sb.append((char) ((afterAddingCount % LAST_CODE_POINT) + FIRST_CODE_POINT));
            } else {
                sb.append((char) afterAddingCount);
            }
        }
        return sb.toString();
    }
}
