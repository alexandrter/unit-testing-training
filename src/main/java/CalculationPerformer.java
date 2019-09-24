public class CalculationPerformer {

    private final Calculator calculator;

    public CalculationPerformer(final Calculator calculator) {
        this.calculator = calculator;
    }

    public double getCalculationResult(double x, double y, Operator operator) {
        if (Operator.MULTIPLICATION.equals(operator)) {
            return calculator.multiply(x, y);
        } else if (Operator.DIVISION.equals(operator)) {
            return calculator.divide(x, y);
        } else if (Operator.ADDITION.equals(operator)) {
            return calculator.add(x, y);
        } else if (Operator.SUBTRACTION.equals(operator)) {
            return calculator.subtract(y, x);
        } else {
            throw new UnsupportedOperationException("This method supports only multiplication, division, addition and subtraction");
        }
    }

}
