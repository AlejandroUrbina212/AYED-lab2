/**
 * Implementation of the Calculator interface
 */
public class MyCalculator implements Calculator {
    /**
     * To calculate the result of two numbers, digits 0-9 only
     * @param num1 first picked number of the String
     * @param num2 second picked number of the String
     * @param op   math operator for the previous two numbers
     * @return result of the operation
     */
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
                result = num1 / num2;

        }
        return result;
    }
}
