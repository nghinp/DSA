import java.util.Stack;

public class Problem2 {

    public static int evaluateInfixExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If character is a digit, extract the whole number
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                operands.push(num);
                i--; // Move back one position since the loop moves ahead
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop(); // Remove '('
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    private static int applyOperator(char operator, int operand2, int operand1) {
        if (operator =='/' && operand2 ==0){
            throw new ArithmeticException("Division by 0");
        }
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Method to determine precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] expressions = {
                "17 / 5",
                "9 / 12",
                "9.0 / 12.0",
                "1 / 2",
                "1 % 2",
                "14 % 5",
                "-14 % 5",
                "14 % -5",
                "5 + 12 / 5 - 10 % 3",
                "123 + 56 * 78 - 1"
        };

        for (String expression : expressions) {
            System.out.println(expression + " = " + evaluateInfixExpression(expression));
        }
    }
}

