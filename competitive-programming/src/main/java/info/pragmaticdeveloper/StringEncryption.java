package info.pragmaticdeveloper;

public class StringEncryption {

    public String encryptString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char charArray[] = input.toCharArray();
        char currentChar = charArray[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < charArray.length; i++) {
            if (currentChar == charArray[i]) {
                count++;
            } else {
                sb.append(currentChar).append(count);
                currentChar = charArray[i];
                count = 1;
            }
        }
        sb.append(currentChar).append(count);
        return sb.toString();
    }

    public String decryptString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char charArray[] = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        char previousChar = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                appendChar(sb, previousChar, Character.getNumericValue(charArray[i]));
            } else {
                previousChar = charArray[i];
            }
        }
        return sb.toString();
    }

    private static void appendChar(StringBuilder sb, char ch, int time) {
        for (int i = 0; i < time; i++) {
            sb.append(ch);
        }
    }
}
