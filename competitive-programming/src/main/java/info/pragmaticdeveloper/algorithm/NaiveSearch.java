package info.pragmaticdeveloper.algorithm;

/**
 * https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching
 */
public class NaiveSearch {
    public static void main(String[] args) {
        char[] fullText = "AABAACAADAABAAABAA".toCharArray();
        char[] searchText = "AABA".toCharArray();

        for (int i = 0; i < fullText.length - searchText.length; i++) {
            int j;
            for (j = 0; j < searchText.length; j++) {
                if (fullText[i + j] != searchText[j]) {
                    break;
                }
            }

            if (j == searchText.length) {
                System.out.println("Found at index " + i);
            }
        }
    }
}
