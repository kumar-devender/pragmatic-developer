package info.pragmaticdeveloper;

public class DecimalToBinary {
    public static String convert(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }
        result = decimal % 2 + result;
        return convert(decimal / 2, result);
    }

    public static void main(String[] args) {
        System.out.println(convert(233, ""));
    }
}
