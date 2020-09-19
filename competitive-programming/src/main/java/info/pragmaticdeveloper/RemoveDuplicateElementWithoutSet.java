package info.pragmaticdeveloper;

public class RemoveDuplicateElementWithoutSet {
    public int[] removeDuplicate(int[] arr) {
        int aux[] = new int[arr.length];
        int j = 0;
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                aux[j++] = arr[i];
            }
        }
        aux[j++] = arr[i];
        return sliceUp(aux, 0, j);
    }

    private int[] sliceUp(int[] arr, int startIndex, int endIndex) {
        int[] slice = new int[endIndex - startIndex];
        int j = 0;
        for (int i = startIndex; i < endIndex; i++) {
            slice[j++] = arr[i];
        }
        return slice;
    }
}
