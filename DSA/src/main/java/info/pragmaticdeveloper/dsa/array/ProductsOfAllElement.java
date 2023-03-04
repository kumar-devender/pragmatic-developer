package info.pragmaticdeveloper.dsa.array;

public class ProductsOfAllElement {
    public int[] getProductOfAllElementExceptCurrent(int[] arr) {
        int currentProduct = 1;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = currentProduct;
            currentProduct *= arr[i];
        }
        currentProduct = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * currentProduct;
            currentProduct *= arr[i];
        }
        return result;
    }
}
