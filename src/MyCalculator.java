public class MyCalculator implements Calculator {
    @Override
    public Integer calculate(Integer num1, Integer num2, String op) {
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
