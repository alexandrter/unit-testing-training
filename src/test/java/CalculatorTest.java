import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testMultiplication() {
        assertEquals(200, calculator.multiply(10, 20));
    }

    @Test
    public void testDivision() {
        assertEquals(0.5, calculator.divide(10, 20));
    }

    @Test
    public void testSubtraction() {
        assertEquals(-10, calculator.subtract(10, 20));
    }

    @Test
    public void testAddition() {
        assertEquals(30, calculator.add(10, 20));
    }


}
