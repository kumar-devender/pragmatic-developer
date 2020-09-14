package info.pragmaticdeveloper;

public class WeightCalculator {
    public static void main(String[] args) {
        String input[] = "10B20 20B10 10 5B10".split(" ");
        int sum = 0;
        for (String label : input) {
            String weight[] = label.split("B");
            if (weight.length > 1) {
                sum += Integer.parseInt(weight[0]) * Integer.parseInt(weight[1]);
            } else {
                sum += Integer.parseInt(weight[0]);
            }
        }

        System.out.println(sum);
    }

}
