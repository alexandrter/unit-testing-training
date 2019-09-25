import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testMultiplication() {
        assertEquals(200, calculator.multiply(10, 20)); //Junit
        assertThat(calculator.multiply(10,20)).isEqualTo(200); //assertJ
        org.hamcrest.MatcherAssert.assertThat(calculator.multiply(10,20), equalTo(200.0)); //hamcrest
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

    @ParameterizedTest
    @ValueSource(ints = {-35, 71, 1273671, Integer.MAX_VALUE})
    public void testShouldBeOdd(int numbers) {
        assertTrue(calculator.isOdd(numbers));
    }

    @ParameterizedTest
    @ValueSource(ints = {-151812, 22, 21518, Integer.MIN_VALUE})
    public void testShouldNotBeOdd(int numbers) {
        assertFalse(calculator.isOdd(numbers));
    }

}
