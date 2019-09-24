import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CalculationPerformerTest {

    private Calculator calculator = mock(Calculator.class);

    private CalculationPerformer calculationPerformer = new CalculationPerformer(calculator);

    @Test
    public void testPerformMultiplication() {
        calculationPerformer.getCalculationResult(10, 5, Operator.MULTIPLICATION);

        verify(calculator, times(1)).multiply(10, 5);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());
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
}
