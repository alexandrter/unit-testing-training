import java.awt.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculationPerformerTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculationPerformer calculationPerformer;

    @Test
    public void testPerformMultiplicationEven() {
        when(calculator.multiply(anyDouble(), anyDouble())).thenReturn(50d);
        when(calculator.isOdd(anyInt())).thenReturn(false);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.MULTIPLICATION);

        verify(calculator, times(1)).multiply(10, 5);
        verify(calculator, times(1)).isOdd(50);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(50, Color.GRAY);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformMultiplicationOdd() {
        when(calculator.multiply(anyDouble(), anyDouble())).thenReturn(51d);
        when(calculator.isOdd(anyInt())).thenReturn(true);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.MULTIPLICATION);

        verify(calculator, times(1)).multiply(10, 5);
        verify(calculator, times(1)).isOdd(51);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(51, Color.RED);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformDivisionEven() {
        when(calculator.divide(anyDouble(), anyDouble())).thenReturn(50d);
        when(calculator.isOdd(anyInt())).thenReturn(false);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.DIVISION);

        verify(calculator, times(1)).divide(10, 5);
        verify(calculator, times(1)).isOdd(50);
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(50, Color.GRAY);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformDivisionOdd() {
        when(calculator.divide(anyDouble(), anyDouble())).thenReturn(51d);
        when(calculator.isOdd(anyInt())).thenReturn(true);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.DIVISION);

        verify(calculator, times(1)).divide(10, 5);
        verify(calculator, times(1)).isOdd(51);
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(51, Color.RED);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformAdditionEven() {
        when(calculator.add(anyDouble(), anyDouble())).thenReturn(50d);
        when(calculator.isOdd(anyInt())).thenReturn(false);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.ADDITION);

        verify(calculator, times(1)).add(10, 5);
        verify(calculator, times(1)).isOdd(50);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(50, Color.GRAY);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformAdditionOdd() {
        when(calculator.add(anyDouble(), anyDouble())).thenReturn(51d);
        when(calculator.isOdd(anyInt())).thenReturn(true);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.ADDITION);

        verify(calculator, times(1)).add(10, 5);
        verify(calculator, times(1)).isOdd(51);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).subtract(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(51, Color.RED);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformSubtractionEven() {
        when(calculator.subtract(anyDouble(), anyDouble())).thenReturn(50d);
        when(calculator.isOdd(anyInt())).thenReturn(false);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.SUBTRACTION);

        verify(calculator, times(1)).subtract(10, 5);
        verify(calculator, times(1)).isOdd(50);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(50, Color.GRAY);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }

    @Test
    public void testPerformSubtractionOdd() {
        when(calculator.subtract(anyDouble(), anyDouble())).thenReturn(51d);
        when(calculator.isOdd(anyInt())).thenReturn(true);

        final CalculationResult actualCalculationResult = calculationPerformer.getCalculationResult(10, 5, Operator.SUBTRACTION);

        verify(calculator, times(1)).subtract(10, 5);
        verify(calculator, times(1)).isOdd(51);
        verify(calculator, never()).divide(anyDouble(), anyDouble());
        verify(calculator, never()).multiply(anyDouble(), anyDouble());
        verify(calculator, never()).add(anyDouble(), anyDouble());

        final CalculationResult expectedCalculationResult = new CalculationResult(51, Color.RED);
        assertEquals(expectedCalculationResult, actualCalculationResult);
    }
}
