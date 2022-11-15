import java.util.Scanner;

enum AllowedOperators {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        new Calculator(scanner.nextLine());
        scanner.close();
    }
}

class Calculator {
    int a, b, c;
    AllowedOperators op1, op2;

    Calculator(String inputStr) {
        input(inputStr);
        calculate();
    }

    public void input(String input) {
        String[] inputArray = input.split(" ");

        if (inputArray.length != 5) {
            throw new Error("Invalid input");
        }

        handleIntegers(inputArray[0], inputArray[2], inputArray[4]);

        op1 = assignOperator(inputArray[1]);
        op2 = assignOperator(inputArray[3]);
    }

    private AllowedOperators assignOperator(String c) {
        try {
            switch (c) {
                case "+":
                    return AllowedOperators.ADD;
                case "-":
                    return AllowedOperators.SUBTRACT;
                case "*":
                    return AllowedOperators.MULTIPLY;
                case "/":
                    return AllowedOperators.DIVIDE;
                default:
                    throw new Exception("Invalid Operator. Must be +, -, / or *.");
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    private void handleIntegers(String s1, String s2, String s3) {
        try {

            try {
                a = Integer.parseInt(s1);
                b = Integer.parseInt(s2);
                c = Integer.parseInt(s3);
            } catch (NumberFormatException e) {
                throw new Exception("Invalid input: Numbers must be integers");
            }

            if (a > 10 || b > 10 || c > 10) {
                throw new Exception("Number is greater than 10");
            }

            if (a < 1 || b < 1 || c < 1) {
                throw new Exception("Number is less than 1");
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void calculate() {
        double result = 0;
        if ((op2 == AllowedOperators.MULTIPLY || op2 == AllowedOperators.DIVIDE)
                && (op1 == AllowedOperators.ADD || op1 == AllowedOperators.SUBTRACT)) {
            double temp = 0;

            if (op2 == AllowedOperators.MULTIPLY) {
                temp = b * c;
            } else {
                try {
                    temp = Double.valueOf(b) / Double.valueOf(c);
                    System.out.println("temp: " + temp);
                } catch (ArithmeticException e) {
                    throw new Error("Cannot divide by 0");
                }
            }

            switch (op1) {
                case ADD:
                    result = a + temp;
                    break;
                case SUBTRACT:
                    result = a - temp;
                    break;
                case MULTIPLY:
                    result = a * temp;
                    break;
                case DIVIDE:
                    try {
                        result = Double.valueOf(a) / Double.valueOf(temp);
                    } catch (ArithmeticException e) {
                        throw new Error("Cannot divide by 0");
                    }
                    break;
            }
            return;
        }

        switch (op1) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                try {
                    result = Double.valueOf(a) / Double.valueOf(b);
                } catch (ArithmeticException e) {
                    throw new Error("Cannot divide by 0");
                }
                break;
        }

        switch (op2) {
            case ADD:
                result += c;
                break;
            case SUBTRACT:
                result -= c;
                break;
            case MULTIPLY:
                result *= c;
                break;
            case DIVIDE:
                try {
                    result /= Double.valueOf(c);
                } catch (ArithmeticException e) {
                    throw new Error("Cannot divide by 0");
                }
                break;
        }

        System.out.println("Output: " + result);
    }
}