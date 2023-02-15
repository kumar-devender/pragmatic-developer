package info.pragmaticdeveloper.dsa.stack;

import java.util.HashMap;
import java.util.Map;

public class BracketsVerifier {
    private static final Map<Character, Character> PARENTHESES = new HashMap<>();

    static {
        PARENTHESES.put('}', '{');
        PARENTHESES.put(']', '[');
        PARENTHESES.put(')', '(');
    }

    public int verify(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (PARENTHESES.containsValue(input.charAt(i))) {
                stack.push(input.charAt(i));
            } else if (stack.isEmpty()) {
                return 0;
            } else if (PARENTHESES.containsKey(input.charAt(i)) && stack.pop() != PARENTHESES.get(input.charAt(i))) {
                return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
