enum AllowedOperators {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class Input {
  
  int a, b, c;
  AllowedOperators op1, op2;

  Input(String inputStr) {
    getInput(inputStr);
  }

  private void getInput(String input) {
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
}

public class Calculator extends Input {

  Calculator(String input) {
    super(input);
  }

  public double calculate() {
    double result = 0;
    if (checkOrder()) {
      double temp = 0;

      temp = getResult(op2, b, c);
      result = getResult(op1, a, temp);

      System.out.println(result);

      return result;
    }

    result = getResult(op1, a, b);
    result = getResult(op2, result, c);

    System.out.println("Output: " + result);
    return result;
  }

  private boolean checkOrder() {
    if ((op2 == AllowedOperators.MULTIPLY || op2 == AllowedOperators.DIVIDE)
        && (op1 == AllowedOperators.ADD || op1 == AllowedOperators.SUBTRACT)) {
      return true;
    }
    return false;
  }

  private double getResult(AllowedOperators op, double a, double b) {
    switch (op) {
      case ADD:
        return a + b;
      case SUBTRACT:
        return a - b;
      case MULTIPLY:
        return a * b;
      case DIVIDE:
        try {
          return a / b;
        } catch (ArithmeticException e) {
          throw new Error("Cannot divide by 0");
        }
      default:
        throw new Error("Invalid operator");
    }
  }
}