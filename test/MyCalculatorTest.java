import static org.junit.Assert.*;

public class MyCalculatorTest {

    @org.junit.Test
    public void calculate() {
        //TODO: Create assertEquarls()
        MyCalculator testCalculator = new MyCalculator();
        int result = testCalculator.calculate(4, 2, "/");
        assertEquals(2, result);
    }
}