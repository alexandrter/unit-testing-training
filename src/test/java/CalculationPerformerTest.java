import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

public class CalculationPerformerTest {

    private Calculator calculator = mock(Calculator.class);

    private CalculationPerformer calculationPerformer = new CalculationPerformer(calculator);

    @Test
    public void testPerformMultiplication() {
        calculationPerformer.getCalculationResult(10, 5, Operator.MULTIPLICATION);

        verify(calculator, only()).multiply(10, 5);
    }

    @Test
    public void testPerformDivision() {
        calculationPerformer.getCalculationResult(10, 5, Operator.DIVISION);
        verify(calculator, only()).divide(10, 5);
    }

    @Test
    public void testPerformAddition() {
        calculationPerformer.getCalculationResult(10, 5, Operator.ADDITION);
        verify(calculator, only()).add(10, 5);
    }

    @Test
    public void testPerformSubtraction() {
        calculationPerformer.getCalculationResult(10, 5, Operator.SUBTRACTION);
        verify(calculator, only()).subtract(10, 5);
    }

    @Test
    public void testShouldThrowException() {
        //Junit
        Throwable actualException =
                assertThrows(UnsupportedOperationException.class,
                        () -> calculationPerformer.getCalculationResult(10, 5, Operator.MODULO));

        assertEquals("This method supports only multiplication, division, addition and subtraction", actualException.getMessage());

        //assertJ
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    calculationPerformer.getCalculationResult(10, 5, Operator.MODULO);
                }).withMessage("This method supports only multiplication, division, addition and subtraction");

    }
}
