package info.pragmaticdeveloper;

public class WeightCalculator {
    public int calculate(String input) {
        String boxes[] = input.split(" ");
        int sum = 0;
        for (String label : boxes) {
            String weight[] = label.split("B");
            if (weight.length > 1) {
                sum += Integer.parseInt(weight[0]) * Integer.parseInt(weight[1]);
            } else {
                sum += Integer.parseInt(weight[0]);
            }
        }
        return sum;
    }

}
