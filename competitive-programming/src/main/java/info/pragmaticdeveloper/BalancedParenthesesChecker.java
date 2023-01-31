package info.pragmaticdeveloper;

import java.util.Stack;

public class BalancedParenthesesChecker {
    private static final char[][] TOKEN = {{'(', ')'}, {'{', '}'}, {'[', ']'}};

    public static void main(String[] args) {
        System.out.println(isBalanced("[((())){{}}]"));
    }

    private static boolean isOpen(Character c) {
        for (char[] chars : TOKEN) {
            if (chars[0] == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatched(Character openTerm, Character closeTerm) {
        for (char[] chars : TOKEN) {
            if (chars[0] == openTerm) {
                return chars[1] == closeTerm;
            }
        }
        return false;
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || !isMatched(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
