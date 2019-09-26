import java.awt.*;

public class CalculationPerformer {

    private final Calculator calculator;

    public CalculationPerformer(final Calculator calculator) {
        this.calculator = calculator;
    }

    public CalculationResult getCalculationResult(double x, double y, Operator operator) {

        final CalculationResult calculationResult = new CalculationResult();

        if (Operator.MULTIPLICATION.equals(operator)) {
            calculationResult.setNumber(calculator.multiply(x, y));
        } else if (Operator.DIVISION.equals(operator)) {
            calculationResult.setNumber(calculator.divide(x, y));
        } else if (Operator.ADDITION.equals(operator)) {
            calculationResult.setNumber(calculator.add(x, y));
        } else if (Operator.SUBTRACTION.equals(operator)) {
            calculationResult.setNumber(calculator.subtract(x, y));
        } else {
            throw new UnsupportedOperationException("This method supports only multiplication, division, addition and subtraction");
        }

        if (calculator.isOdd((int)calculationResult.getNumber())) {
            calculationResult.setColor(Color.RED);
        } else {
            calculationResult.setColor(Color.GRAY);
        }

        return calculationResult;
    }

}
