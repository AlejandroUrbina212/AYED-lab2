public class MyCalculator implements Calculator {
    @Override
    public int calculate(int num1, int num2, String op) {
        int result = -1;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 / num1;

        }
        return result;
    }
}
