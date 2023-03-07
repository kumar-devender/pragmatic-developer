package info.pragmaticdeveloper.dsa;

import java.util.Stack;

public class ExpressionEvaluation {

    public int evaluate(String input) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        String[] tokens = input.split("");
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
        return operands.pop();
    }
}
