package info.pragmaticdeveloper.algorithm;

public class NaiveSearch {
    public static void main(String[] args) {
        char[] fullText = "THIS IS A TEST TEXT".toCharArray();
        char[] searchText = "TEST".toCharArray();
        int i = 0;
        int j = 0;
        while (i < fullText.length) {
            if (fullText[i] == searchText[j] && j < searchText.length) {
                i++;
                j++;
            } else {
                j = 0;
                i++;
            }
        }
    }
}
