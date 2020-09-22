package info.pragmaticdeveloper;

public class LongestCommonSubSequenceRecursive {
    private static String X = "hello";
    private static String Y = "hello world";

    public static void main(String[] args) {
        System.out.println(lcs(X.length(), Y.length(), 0));

    }

    public static int lcs(int i, int j, int count) {
        if (i == 0 || j == 0) {
            return count;
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            count = lcs(i - 1, j - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcs(i - 1, j, 0), lcs(i, j - 1, 0)));
        return count;
    }
}
