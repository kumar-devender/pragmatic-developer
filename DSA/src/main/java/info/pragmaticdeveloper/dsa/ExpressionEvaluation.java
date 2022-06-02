package info.pragmaticdeveloper.dsa;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluation {
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        System.out.println("Enter expression. No space please!");
//        String[] tokens = "(1+((2+3)*(4*5)))".split("");
        String[] tokens = SC.next().split("");
        for (String token : tokens) {
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(token);
                    break;
                case ")":
                    String operator = operators.pop();
                    Integer operand = operands.pop();
                    Integer result = null;
                    switch (operator) {
                        case "+":
                            result = operand + operands.pop();
                            break;
                        case "*":
                            result = operand * operands.pop();
                            break;
                        case "/":
                            result = operand / operands.pop();
                            break;
                        case "-":
                            result = operand - operands.pop();
                            break;
                    }
                    operands.push(result);
                    break;
                default:
                    operands.push(Integer.parseInt(token));
                    break;
            }
        }
        System.out.println("Result : " + operands.pop());
    }
}
