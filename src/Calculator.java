/**
 * Interface of a Math Calculator
 */
public interface Calculator {
    /**
     * @param num1 first picked number of the String
     * @param num2 second picked number of the String
     * @param op math operator for the previous two numbers
     * @return the result of the operation between this two numbers
     */
    int calculate(int num1, int num2, String op);
}
